import java.util.Scanner;

public class Tienda {


    public void iniciar()
    {   Scanner sc =new Scanner(System.in);
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();

        System.out.println("1)Ya tengo cuenta\n2)Registrarme");
        int opcionIngreso = sc.nextInt();

        switch(opcionIngreso)
        {
            case 1:
                System.out.println(" Ingrese su mail: ");
                String mail = sc.nextLine();
                System.out.println("Ingrese su clave: ");
                String pass = sc.nextLine();
                //if(tipoUsuario==1){ buscarenlalista}
        }   case 2:
               // if(tipoUsuario==1){alta de cliente}else{alta de administrador}
    }
}
