
import JSONYArchivos.GestorJSONProductos;
import JSONYArchivos.JsonUsuario;
import Productos.*;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Enum.Genero;
import Enum.Suscripcion;
import Usuarios.Usuario;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();


        System.out.println
        (
                """
                        ╲┏━┳━━━━━━━━┓╲╲
                        ╲┃◯┃╭┻┻╮╭┻┻╮┃╲╲
                        ╲┃╮┃┃╭╮┃┃╭╮┃┃╲╲
                        ╲┃╯┃┗┻┻┛┗┻┻┻┻╮╲
                        ╲┃◯┃╭╮╰╯┏━━━┳╯╲
                        ╲┃╭┃╰┏┳┳┳┳┓◯┃╲╲
                        ╲┃╰┃◯╰┗┛┗┛╯╭┃╲╲"""
        );



        tienda.iniciar();
        DatosHardcoded.cargarTodo();

    }
}