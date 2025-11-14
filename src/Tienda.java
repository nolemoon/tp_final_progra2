import Exceptions.UsuarioExistenteException;
import Exceptions.UsuarioNoEncontradoException;

import java.util.Scanner;

public class Tienda {

    Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();
        sc.nextLine();
        if (tipoUsuario == 2) {//ADMIN{
            try {
                ingresar(2);
            } catch (UsuarioNoEncontradoException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("1)Ya tengo cuenta\n2)Registrarme");
            int opcionIngreso = sc.nextInt();
            sc.nextLine();

            switch (opcionIngreso) {
                case 1:
                    try {
                        ingresar(1);
                    } catch (UsuarioNoEncontradoException e) {
                        e.printStackTrace();
                    }
                    break;
                //if(tipoUsuario==1){ buscarenlalista}
                case 2:
                    try {
                        registrarse();
                    } catch (UsuarioExistenteException e) {
                        System.out.println("El usuario ya existe");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
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

    public void ingresar(int tipoUsuario) throws UsuarioNoEncontradoException {
        String email;
        String contrasenia;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();

        for (Usuario aux : listaUsuarios) {
            if (aux.getEmail().equals(email) && aux.getContrasenia().equals(contrasenia)) {
                System.out.println("Bienvenido" + aux.getNombre);
                mostrarmenu();
            } else throw new UsuarioNoEncontradoException("No se encontró usuario con los datos ingresados.");
        }

    }

    public void menuCliente(){
        int opcion;
        System.out.println("1-Ver peliculas disponibles.\n"+
                "2-Ver series disponibles.\n"+
                "3-Ver juegos disponibles.\n"+
                "4-Ver e-books disponibles.\n");
        sc.nextInt();
        switch (opcion){
            case 1:

        }

    }

    public void menuAdmin(){}

