import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase abstracta USUARIO tiene como campos su nombre, email, telefono y fecha de registro.
 * Además, tiene como atributo 'usuarioActivo' para controlar su estado de actividad.
 * Cuenta con un constructor vacío y otro con los atributos nombre, email y teléfono.
 * Métodos: setters y getters de cada atributo, toString para devolver sus datos.
 * Implementa la interfaz ABMCL<Usuario> y sus métodos: alta, baja, modificar, consultar y lista.
 * @author Renata
 */

public abstract class Usuario implements ABMCL<Usuario> {  //tengo que actualizar con ABMCL
    private String nombre;
    private String email;
    private String telefono;
    private boolean usuarioActivo;
    private final LocalDateTime fechaRegistro;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

    /**
     * Constructor que inicializa un usuario con los datos indicados
     * @param nombre nombre de usuario
     * @param email correo electrónico del usuario
     * @param telefono número de teléfono del usuario
     */
    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.usuarioActivo = true;
        this.fechaRegistro = LocalDateTime.now();
    }

    /**
     * Constructor vacío que inicializa un usuario con su estado activo y fecha de registro
     */
    public Usuario() {
        this.usuarioActivo = true;
        this.fechaRegistro = LocalDateTime.now();
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Da de alta un usuario en el sistema
     * @param obj usuario a registrar
     * @return {@code true} si se registra el usuario con éxito, {@code false} en caso contrario
     */
    @Override
    public abstract boolean alta(Usuario obj);

    /**
     * Da de baja un usuario por su id
     * @param id identificador único del usuario
     * @return usuario dado de baja
     */
    @Override
    public abstract Usuario baja(int id);

    /**
     * Modifica la información de un usuario que ya existe
     * @param obj usuario con datos actualizados
     * @return {@code true} si se modificó con éxito, {@code false} en caso contrario
     */
    @Override
    public abstract boolean modificar(Usuario obj);

    /**
     * Consulta los datos de un usuario a partir de su nombre
     * @param nombre usuario a buscar
     * @return usuario encontrado
     */
    @Override
    public abstract Usuario consultar(String nombre);

    /**
     * Devuelve listado con los usuarios registrados
     * @return cadena con los datos de los usuarios
     */
    @Override
    public abstract String lista();

    /**
     * Devuelve los datos principales del usuario
     * @return cadena con información formateada del usuario
     */
    @Override
    public String toString() {
        return "Usuario {" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuenta activa=" + usuarioActivo +
                ", fecha de registro=" + fechaRegistro.format(formatter) +
                '}';
    }
}
