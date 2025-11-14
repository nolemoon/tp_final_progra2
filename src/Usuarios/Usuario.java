package Usuarios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase abstracta USUARIO tiene como campos su nombre, email, telefono, contraseña y fecha de registro.
 * Además, tiene como atributo 'usuarioActivo' para controlar su estado de actividad.
 * Cuenta con un constructor vacío y otro con los atributos nombre, email, teléfono y contraseña.
 * Métodos: setters y getters de cada atributo, toString para devolver sus datos, equals y hashcode.
 * @author Renata, Franco
 */
public abstract class Usuario  {
    protected String nombre;
    protected String email;
    protected String telefono;
    protected boolean usuarioActivo;
    private final LocalDateTime fechaRegistro;
    private static ArrayList<Usuario> listaUsuarios= new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
    protected int id;
    private static int contador=0;
    private String contrasenia;


    /**
     * Constructor que inicializa un usuario con los datos indicados
     * @param nombre nombre de usuario
     * @param email correo electrónico del usuario
     * @param telefono número de teléfono del usuario
     * @param contrasenia contraseña de la cuenta del usuario
     */
    public Usuario(String nombre, String email, String telefono, String contrasenia) {
        this.id=contador++;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.usuarioActivo = true;
        this.fechaRegistro = LocalDateTime.now();
        this.contrasenia=contrasenia;
        listaUsuarios.add(this);
    }

    /**
     * Constructor vacío que inicializa un usuario con su estado activo y fecha de registro
     */
    public Usuario() {
        this.usuarioActivo = true;
        this.fechaRegistro = LocalDateTime.now();
    }

    /// INICIO GETTER AND SETTER
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {}
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
    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public int getId() {return id;}

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /// FIN GETTER AND SETTER

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuarios.Usuario {" +
                "id=" + id +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuenta activa=" + usuarioActivo +
                ", fecha de registro=" + fechaRegistro.format(formatter) +
                '}';
    }
}
