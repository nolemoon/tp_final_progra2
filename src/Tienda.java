import java.util.Scanner;

public class Tienda {

    Scanner sc= new Scanner(System.in);

    public void iniciar()
    {   Scanner sc =new Scanner(System.in);
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();

        System.out.println("1)Ya tengo cuenta\n2)Registrarme");
        int opcionIngreso = sc.nextInt();

        switch(opcionIngreso)
        {
            case 1:

                //if(tipoUsuario==1){ buscarenlalista}
        }   case 2:
                    registrarse();

    }

    public void registrarse()
    {
        String email;
        String contrasenia;
        String nombre;
        String telefono;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();
        System.out.println("Ingrese su nombre");
        nombre = sc.nextLine();
        System.out.println("Ingrese su telefono");
        telefono = sc.nextLine();
        Usuario aux = new Usuario(nombre,email ,telefono,contrasenia);

        Usuario.listaUsuarios.add(aux);
    }

    public void ingresar(){
        String email;
        String contrasenia;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();

    }




}
