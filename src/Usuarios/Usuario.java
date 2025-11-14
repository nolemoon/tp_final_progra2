package Usuarios;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;


public abstract class Usuario  {
    protected String nombre;
    protected String email;
    protected String telefono;
    protected boolean usuarioActivo;
    private final LocalDateTime fechaRegistro;
    private ArrayList<Usuario> listaUsuarios=null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
    protected int id=contador;
    private static int contador=0;

    public Usuario(String nombre, String email, String telefono) {
        this.id=contador++;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.usuarioActivo = true;
        this.fechaRegistro = LocalDateTime.now();
        this.listaUsuarios=new ArrayList<>();
    }

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
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public int getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /// FIN GETTER AND SETTER



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
