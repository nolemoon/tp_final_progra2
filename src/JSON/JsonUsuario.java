package JSON;

import Usuarios.Cliente;
import Usuarios.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUsuario {

    public JsonUsuario() {
    }

    public JSONObject serializarCliente(Cliente aux) throws JSONException {
        JSONObject jsonUsuario=null;
        File archi= new File("clientes.json");
      try{
        PrintWriter pw = new PrintWriter(archi);
        try {

             jsonUsuario = new JSONObject();
            jsonUsuario.put("nombre", aux.getNombre());
            jsonUsuario.put("email", aux.getEmail());
            jsonUsuario.put("telefono", aux.getTelefono());
            jsonUsuario.put("usuarioActivo", aux.isUsuarioActivo());
            jsonUsuario.put("fechaRegistro", aux.getFechaRegistro().toString());
            jsonUsuario.put("idCliente", aux.getId());
            jsonUsuario.put("Suscripcion",aux.getTipoSuscripcion().toString());

            pw.println(jsonUsuario);
            pw.flush();
            pw.close();
        }catch (JSONException e) {
            e.printStackTrace();

        }}catch(FileNotFoundException e)
      {e.getMessage();}

        return jsonUsuario;
    }


}
