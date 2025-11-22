package Usuarios;

import Enum.Suscripcion;

import Interfaces.ABMCL;
import Productos.Producto;

import java.util.*;

public class Cliente extends Usuario implements ABMCL {

    private Suscripcion tipoSuscripcion;
    private static HashSet<Producto> biblioteca=null;

    /// METODOS

    @Override
    public boolean alta(Object o) {

        if (!(o instanceof Cliente cliente)) return false;
        getListaUsuarios().add(this);
        return true;

    }

    @Override
    public boolean baja(int id) {
        Cliente aux=buscarUsuario(id);

        getListaUsuarios().remove(aux);
        aux.setUsuarioActivo(false);
        getListaUsuarios().add(aux);

        return true;
            }


    @Override
    public boolean modificar(Object o) {
        Scanner sc=new Scanner(System.in);

        System.out.println("""
                Ingrese el numero de la opcion que desea modificar\
                
                1. Nombre\
                
                2. Email\
                
                3. Telefono\
                
                4. Tipo de suscripción\
                
                5. Salir""");
        int opcion=sc.nextInt();
        sc.nextLine();

        return switch (opcion) {
                case 1 -> {
                    this.setNombre(sc.nextLine());
                    yield true;
                }
                case 2 -> {
                    this.setEmail(sc.nextLine());
                    yield true;
                }
                case 3 -> {
                    this.setTelefono(sc.nextLine());
                    yield true;

                }
                case 4 -> {
                    this.setTipoSuscripcion(Suscripcion.valueOf(sc.nextLine().toUpperCase()));
                    yield true;
                }
                default -> false;

            };

        }

    @Override
    public Usuario consultar(String email) {
              for(int i = 0; i< getListaUsuarios().size(); i++){

            if(getListaUsuarios().get(i).getEmail().equals(email)){
                return getListaUsuarios().get(i);

            }
        }

        return null;
    }

    @Override
    public void listar() {

        for(int i = 0; i< getListaUsuarios().size(); i++){

            Usuario aux = getListaUsuarios().get(i);
            System.out.println("usuario numero "+ i +
                                aux.toString());
            if(aux instanceof Cliente) {
                System.out.println("Suscripcion: " + ((Cliente) aux).getTipoSuscripcion());
            }
            }
        }


    public void agregarProducto(Producto producto){
        biblioteca.add(producto);
    }

    public void mostrarBiblioteca(){
        System.out.println(biblioteca);
    }

    public Cliente buscarUsuario(int id) {
        for(int i = 0; i< getListaUsuarios().size(); i++){
            if(getListaUsuarios().get(i).getId()==id){
                return (Cliente) getListaUsuarios().get(i);
            }
        }


        return null;
    }


    @Override
    public String toString() {
        return "Usuarios.Cliente{" + super.toString() +
                ", tipo Suscripcion=" + tipoSuscripcion + '\n';
    }

    /// CONSTRUCTOR - INICIO
    public Cliente(String nombre, String email, String telefono, String contrasenia) {
        super(nombre, email, telefono, contrasenia);

        biblioteca=new HashSet<>();
    }

    public Cliente() {

        }

   /// CONSTRUCTOR - FINAL

    /// GETTER AND SETTER - INICIO


    public Suscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(Suscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    /// GETTER AND SETTER - FINAL

}
