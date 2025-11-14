package Productos;

import Exceptions.ProductoNoEncontradoException;
import Exceptions.UsuarioExistenteException;
import Exceptions.UsuarioNoEncontradoException;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Usuario;



import java.util.Map;
import java.util.Scanner;


public class Tienda {
    protected CatalogoProducto catalogo;
    protected Scanner sc = new Scanner(System.in);
    protected Cliente clienteActual;
    protected Administrador adminAux = new Administrador();

    public Tienda() {
        catalogo = new CatalogoProducto();
    }


    public void iniciar() {
        System.out.println(" Ingresar como: \n1)CLIENTE\n2)ADMINISTRADOR");
        int tipoUsuario = sc.nextInt();
        sc.nextLine();
        if (tipoUsuario == 2) {//ADMIN{
            try {
                ingresar(2);
            } catch (UsuarioNoEncontradoException e) {
                System.out.println(e.getMessage());
            } catch (ProductoNoEncontradoException e) {
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
                    } catch (UsuarioNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    } catch (ProductoNoEncontradoException e) {
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
                System.out.println("Bienvenido" + aux.getNombre());

                if (tipoUsuario == 1) {
                    menuCliente();
                } else {
                    menuAdmin();
                }
                encontrado= true;
                break;
            }

        }

        if(!encontrado){
            throw new UsuarioNoEncontradoException("No encontrado");

        }
    }



    public void menuCliente() throws ProductoNoEncontradoException {
        int opcion;
        Map<Integer, Producto> peliculas = catalogo.filtrarPorTipo(Pelicula.class);
        Map<Integer, Producto> series = catalogo.filtrarPorTipo(Serie.class);
        Map<Integer, Producto> juegos = catalogo.filtrarPorTipo(Juego.class);
        Map<Integer, Producto> ebooks = catalogo.filtrarPorTipo(Ebook.class);

        System.out.println("""
                        1 - Ver disponibles.
                        2 - Buscar.
                        3 - Ver biblioteca.
                        """);

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("""
                        1-Peliculas
                        2-Series
                        3-Juegos
                        4-E-books
                        """);
                opcion = sc.nextInt();
                sc.nextLine();


                switch (opcion) {
                    case 1:
                        catalogo.mostrarCatalogo(peliculas);
                        break;
                    case 2:
                        catalogo.mostrarCatalogo(series);
                        break;
                    case 3:
                        catalogo.mostrarCatalogo(juegos);
                        break;
                    case 4:
                        catalogo.mostrarCatalogo(ebooks);
                        break;

                }
                //buscar por nombre
                break;
            case 2:
                String nombre;
                System.out.println("Ingrese el nombre:");
                nombre = sc.nextLine();
                try {
                    Producto buscado = catalogo.buscarPorNombre(nombre);
                    VerComprar(buscado);

                } catch (ProductoNoEncontradoException e) {
                    e.printStackTrace();
                }
                break;
            case 3: clienteActual.mostrarBiblioteca();
            break;
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
                        clienteActual.agregarProducto(p);
                        System.out.println("Compraste: " + p.getNombre());
                    } else {
                        System.out.println("No hay cliente logueado.");
                    }
                    break;
                case 3: try{ menuCliente();
                        }catch ( ProductoNoEncontradoException e)
                        {e.printStackTrace();}

                default:
                    System.out.println("Opcion incorrecta");
            }

        }


        public void menuAdmin(){
            int opcion;
            Producto aux;
            System.out.println("1-Ver catalogo"+
                            "2-Buscar producto"


            );
            opcion=sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    catalogo.mostrarCatalogo();
                    break;
                case 2:
                    System.out.println("Ingrese el id del producto");
                    int id  = sc.nextInt(); sc.nextLine();
                   try{
                       aux = catalogo.buscarPorId(id);
                       System.out.println("Encontrado:" +aux.getNombre());
                       System.out.println("1-Ver"+
                                            "2-Eliminar"+
                                            "3-Modificar+"+
                                              "4-Atras");
                       opcion= sc.nextInt();sc.nextLine();
                       switch (opcion){
                           case 1:  System.out.println(aux);break;
                           case 2: catalogo.getProductos().remove(id);break;
                           case 3: adminAux.modificar(aux);break;
                           case 4: menuAdmin(); break;
                           default:
                               System.out.println("Opción incorrecta.");
                       }

                   }catch (ProductoNoEncontradoException e){e.printStackTrace();}
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        }





    }




