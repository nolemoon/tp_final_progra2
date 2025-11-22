package Productos;

import Exceptions.ProductoNoEncontradoException;
import Exceptions.UsuarioExistenteException;
import Exceptions.UsuarioNoEncontradoException;
import JSONYArchivos.JsonUsuario;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Enum.Genero;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * La clase Tienda contiene un catálogo de productos, permite el registro e inicio de sesión de clientes y administradores,
 * y proporciona menús para la navegación y gestión de productos según el tipo de usuario..
 * Métodos:
 * - iniciar(): inicia la interacción con el usuario, permitiendo registro o inicio de sesión., toString para devolver sus datos, equals y hashcode.
 * - registrarse(): permite crear un nuevo cliente si el correo no está registrado.
 * - ingresar(int tipoUsuario): valida el inicio de sesión de un cliente o administrador.
 * - menuCliente(): muestra el menú de opciones para un cliente.
 * - VerComprar(Producto p): muestra opciones de ver o comprar un producto.
 * - menuAdmin(): muestra el menú de opciones para un administrador.
 * @author Noel
 */

public class Tienda {
    protected Scanner sc = new Scanner(System.in);
    protected Cliente clienteActual;
    protected Administrador adminAux = new Administrador();

    public Tienda() {

    }


    public void iniciar() {
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();
        sc.nextLine();
        if (tipoUsuario == 2) {//ADMIN{
            try {
                ingresar(2);
            } catch (UsuarioNoEncontradoException | ProductoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("1)Ya tengo cuenta\n2)Registrarme");
            int opcionIngreso = sc.nextInt();
            sc.nextLine();

            switch (opcionIngreso) {
                case 1:
                    try {
                        ingresar(1);
                    } catch (UsuarioNoEncontradoException | ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
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
        for (Usuario aux : Usuario.getListaUsuarios()) {
            if (aux.getEmail().equalsIgnoreCase(email)) {
                throw new UsuarioExistenteException("El mail ya se encuentra registrado");
            }
        }
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();
        System.out.println("Ingrese su nombre");
        nombre = sc.nextLine();
        System.out.println("Ingrese su telefono");
        telefono = sc.nextLine();

        Cliente nuevo = new Cliente(nombre, email, telefono, contrasenia);

        Usuario.getListaUsuarios().add(nuevo);

        JsonUsuario j = new JsonUsuario();
        j.ListaToArchivo();

        System.out.println("Usuario registrado");
        try {
            ingresar(1);
        } catch (UsuarioNoEncontradoException | ProductoNoEncontradoException e) {
            e.printStackTrace();
        }

    }

    public void ingresar(int tipoUsuario) throws UsuarioNoEncontradoException, ProductoNoEncontradoException {
        String email;
        String contrasenia;
        boolean encontrado=false;

        System.out.println("Ingrese su e-mail");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contrasenia = sc.nextLine();


        for (Usuario aux : Usuario.getListaUsuarios()) {
            if (aux.getEmail().equals(email) && aux.getContrasenia().equals(contrasenia)) {
                encontrado= true;
                System.out.println("Bienvenido " + aux.getNombre());

                if (aux instanceof Cliente cliente && tipoUsuario == 1) {
                    clienteActual = cliente;
                    menuCliente();
                } else if (tipoUsuario == 2 && aux instanceof Administrador admin) {
                    adminAux = admin;
                    menuAdmin();

                }else  {
                    System.out.println("El tipo de usuario no coincide con la cuenta ingresada.");
                }

                break;
            }

        }

        if(!encontrado){
            throw new UsuarioNoEncontradoException("No encontrado");

        }
    }



    public void menuCliente() throws ProductoNoEncontradoException {
        int opcion;
        Map<Integer, Producto> catalogoFiltrado = new LinkedHashMap<>();

        System.out.println("""
                        1 - Ver disponibles.
                        2 - Buscar.
                        3 - Ver biblioteca
                        4 - Modificar perfil.
                        """);

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("""
                        1 - Peliculas
                        2 - Series
                        3 - Juegos
                        4 - E-books
                        """);
                opcion = sc.nextInt();
                sc.nextLine();


                switch (opcion) {
                    case 1:
                        catalogoFiltrado = CatalogoProducto.filtrarPorTipo(Pelicula.class);
                        break;
                    case 2:
                        catalogoFiltrado = CatalogoProducto.filtrarPorTipo(Serie.class);
                        break;
                    case 3:
                        catalogoFiltrado = CatalogoProducto.filtrarPorTipo(Juego.class);
                        break;
                    case 4:
                        catalogoFiltrado = CatalogoProducto.filtrarPorTipo(Ebook.class);
                        break;
                    default:
                        System.out.println("\nOpción inválida.");
                        return;

                }
                System.out.println("\nDesea filtrar por género? (s/n)= ");
                String generoOpcion = sc.nextLine();

                if(generoOpcion.equalsIgnoreCase("s")){
                    for (Genero g : Genero.values()) {
                        System.out.println("- " + g);
                    }

                    System.out.println("\nIndique el género que desea ver: ");
                    String generoIngresado = sc.nextLine();
                    catalogoFiltrado = CatalogoProducto.filtrarPorGenero(catalogoFiltrado, generoIngresado);
                    CatalogoProducto.mostrarCatalogo(catalogoFiltrado);
                }
                else{
                    CatalogoProducto.mostrarCatalogo(catalogoFiltrado);
                }

                break;
            case 2:
                System.out.println("\nIngrese el nombre del producto:");
                String nombre = sc.nextLine();
                try {
                    Producto buscado = CatalogoProducto.buscarPorNombre(nombre);
                    VerComprar(buscado);

                } catch (ProductoNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                clienteActual.mostrarBiblioteca();
                break;
            case 4:
                //clienteActual.modificar(clienteActual);
                break;

            default:
                System.out.println("\nOpción inválida.");
        }
    }


        public void VerComprar(Producto p) {
            System.out.println(
                    "1-Ver descripcion"+
                    "2-Comprar"+
                    "3-Volver"
            );

            int opcion= sc.nextInt();sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(p.toString());
                    break;
                case 2:
                    if (clienteActual != null) {
                        gestionfacturacion(p);
                    } else {
                        System.out.println("No hay cliente logueado.");
                    }
                    break;
                case 3:
                    try{
                        menuCliente();
                    } catch ( ProductoNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

    private void gestionfacturacion(Producto p) {
        String aux ="";
        System.out.println("Ingrese el metodo de pago"+
                "1-DEBITO"+
                "2-CREDITO");
        aux= sc.nextLine();
        clienteActual.agregarProducto(p);
        System.out.println("Compraste: " + p.getNombre());
    }


    public void menuAdmin(){
            int opcion;
            Producto aux;
            System.out.println("""
                    1. Ver catálogo
                    2. Buscar producto
                    3. Salir
                    """);
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    CatalogoProducto.mostrarCatalogo();
                    break;
                case 2:
                    System.out.println("Ingrese el id del producto");
                    int id  = sc.nextInt();
                    sc.nextLine();

                    try{
                       aux = CatalogoProducto.buscarPorId(id);
                       System.out.println("Encontrado: " + aux.getNombre());
                       System.out.println("""
                               1. Ver
                               2. Eliminar
                               3. Modificar
                               4. Atrás
                               """);
                       opcion= sc.nextInt();sc.nextLine();
                       switch (opcion){
                           case 1:  System.out.println(aux); break;
                           case 2: adminAux.baja(id); break;
                           case 3: adminAux.modificar(aux); break;
                           case 4: menuAdmin(); break;
                           default:
                               System.out.println("Opción incorrecta.");
                       }

                   }catch (ProductoNoEncontradoException e){e.getMessage();}
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        }





    }




