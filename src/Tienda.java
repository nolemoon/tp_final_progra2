import Exceptions.UsuarioExistenteException;
import Exceptions.UsuarioNoEncontradoException;

import java.util.Scanner;

public class Tienda {

    Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();
        sc.nextLine();
        System.out.println("1)Ya tengo cuenta\n2)Registrarme");
        int opcionIngreso = sc.nextInt();
        sc.nextLine();

        switch (opcionIngreso) {
            case 1:
                try {
                    ingresar();
                }catch (UsuarioNoEncontradoException e){
                    e.printStackTrace();
                }
                break;
            //if(tipoUsuario==1){ buscarenlalista}
            case 2:
                try {
                    registrarse();
                }catch (UsuarioExistenteException e){
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public void registrarse() throws UsuarioExistenteException {
        String email;
        String contrasenia;
        String nombre;
        String telefono;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        for (Usuario aux : listaUsuarios) {
            if (aux.getEmail().equals(email)){
                throw new UsuarioExistenteException("El mail ya se encuentra registrado");
            }
        }
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();
        System.out.println("Ingrese su nombre");
        nombre = sc.nextLine();
        System.out.println("Ingrese su telefono");
        telefono = sc.nextLine();
        Usuario aux = new Usuario(nombre, email, telefono, contrasenia);

        Usuario.listaUsuarios.add(aux);
    }

    public void ingresar() throws UsuarioNoEncontradoException {
        String email;
        String contrasenia;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();

        for (Usuario aux : listaUsuarios) {
            if (aux.getEmail().equals(email) && aux.getContrasenia().equals(contrasenia)) {
                System.out.println("Bienvenido" + aux.getNombre);
                mostrarmenu
            } else throw new UsuarioNoEncontradoException("No se encontró usuario con los datos ingresados.");
        }


    }

}





