package Usuarios;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public abstract class Usuario  {
    protected String nombre;
    protected String email;
    protected String telefono;
    protected boolean usuarioActivo;
    private final LocalDateTime fechaRegistro;
    private ArrayList<Usuario> listaUsuarios=null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

    public Usuario(String nombre, String email, String telefono) {
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




    @Override
    public String toString() {
        return "Usuarios.Usuario {" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuenta activa=" + usuarioActivo +
                ", fecha de registro=" + fechaRegistro.format(formatter) +
                '}';
    }
}
