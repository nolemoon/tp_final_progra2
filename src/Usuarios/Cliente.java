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
        cliente.getListaUsuarios().add(this);
        return true;

    }

    @Override
    public boolean baja(int id) {
Cliente aux=buscarUsuario(id);

aux.getListaUsuarios().remove(aux);
aux.setUsuarioActivo(false);
aux.getListaUsuarios().add(aux);


return true;
    }


    @Override
    public boolean modificar( Object o) {
Scanner sc=new Scanner(System.in);

if (!(o instanceof Cliente cliente)) return false;
        System.out.println("""
                Ingrese el numero de la opcion que desea modificar\
                
                1. Nombre\
                
                2. email\
                
                3. telefono\
                
                4. tipoSuscripcion\
                
                5. salir""");
 int opcion=sc.nextInt();
 sc.nextLine();

            return switch (opcion) {


                case 1 -> {
                    cliente.nombre= sc.nextLine();
                    yield true;
                }
                case 2 -> {
                    cliente.email = sc.nextLine();
                    yield true;
                }
                case 3 -> {
                    cliente.telefono = sc.nextLine();
                    yield true;

                }
                case 4 -> {
                    cliente.tipoSuscripcion=Suscripcion.valueOf(sc.nextLine().toUpperCase());
                    yield true;
                }
                default -> false;

            };

        }

    @Override
    public Usuario consultar(String email) {
              for(int i=0; i<super.getListaUsuarios().size(); i++){

            if(super.getListaUsuarios().get(i).getEmail().equals(email)){
                return super.getListaUsuarios().get(i);

            }
        }

        return null;
    }

    @Override
    public void lista() {

        for(int i=0; i<super.getListaUsuarios().size(); i++){

            Usuario aux = super.getListaUsuarios().get(i);
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
        for(int i=0; i<super.getListaUsuarios().size(); i++){
            if(super.getListaUsuarios().get(i).getId()==id){
                return (Cliente) super.getListaUsuarios().get(i);
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
