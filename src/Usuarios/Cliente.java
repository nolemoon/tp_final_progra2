package Usuarios;

import Enum.Suscripcion;

import Interfaces.ABMCL;
import Productos.Producto;

import java.util.*;

/**
 * Clase que representa a un cliente, extiende de la clase abstracta {@code Usuario}.
 * Posee una suscripción y una biblioteca personal donde almacena sus productos adquiridos.
 *
 * Implementa la interfaz {@link ABMCL} para realizar las operaciones CRUD sobre clientes.
 * @author Franco
 */
public class Cliente extends Usuario implements ABMCL<Cliente> {

    private Suscripcion tipoSuscripcion;
    private HashSet<Producto> biblioteca;


    /// METODOS
    /**
     * Da de alta un cliente.
     * @param c cliente a agregar a usuarios
     * @return {@code true} si la operación fue exitosa
     */
    @Override
    public boolean alta(Cliente c) {
        getListaUsuarios().add(c);
        return true;

    }

    /**
     * Da de baja lógica un cliente.
     * @param id identificador del objeto a dar de baja
     * @return {@code true} si la operación fue exitosa
     */
    @Override
    public boolean baja(int id) {
       Cliente aux=buscarUsuario(id);
       if(aux == null) return false;

       aux.setUsuarioActivo(false);
       return true;
    }

    /**
     * Modifica atributos de un cliente según la opción que se elige
     * @param c cliente a modificar
     * @return {@code true} si la operación fue exitosa
     */
    @Override
    public boolean modificar(Cliente c) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Ingrese el numero de la opcion que desea modificar\
                
                1. Nombre\
                
                2. email\
                
                3. telefono\
                
                4. tipoSuscripcion\
                
                5. salir""");

        int opcion = sc.nextInt();
        sc.nextLine();

            return switch (opcion) {


                case 1 -> {
                    c.setNombre(sc.nextLine());
                    yield true;
                }
                case 2 -> {
                    c.setEmail(sc.nextLine());
                    yield true;
                }
                case 3 -> {
                    c.setTelefono(sc.nextLine());
                    yield true;

                }
                case 4 -> {
                    c.setTipoSuscripcion(Suscripcion.valueOf(sc.nextLine().toUpperCase()));
                    yield true;
                }
                default -> false;

            };

        }

    /**
     * Consulta un cliente según su email.
      * @param email email del cliente a buscar
     * @return cliente encontrado o null si no existe
     */
    @Override
    public Cliente consultar(String email) {

        for(int i=0; i < super.getListaUsuarios().size(); i++) {
            if(super.getListaUsuarios().get(i).getEmail().equals(email)){
                return (Cliente) super.getListaUsuarios().get(i);
            }
        }
        return null;
    }

    /**
     * Lista todos los clientes registrados.
     */
    @Override
    public void listar() {

        for(int i=0; i < super.getListaUsuarios().size(); i++){

            Cliente aux = (Cliente) super.getListaUsuarios().get(i);
            System.out.println("Cliente número "+ i + aux.toString());
        }
    }

    /**
     * Agrega un producto a la biblioteca del cliente.
     * @param producto producto a agregar
     */
    public void agregarProducto(Producto producto){
        biblioteca.add(producto);
    }

    /**
     * Muestra la biblioteca del cliente.
     */
    public void mostrarBiblioteca(){
        System.out.println(biblioteca);
    }

    /**
     * Busca un cliente dentro de la lista de usuarios por su id.
     * @param id id del cliente
     * @return cliente encontrado o null
     */
    public Cliente buscarUsuario(int id) {
        for(int i=0; i < super.getListaUsuarios().size(); i++){
            if(super.getListaUsuarios().get(i).getId() == id){
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
        biblioteca = new HashSet<>();
    }

    public Cliente() {}

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
