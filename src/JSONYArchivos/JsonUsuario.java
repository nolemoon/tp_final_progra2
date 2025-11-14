package JSONYArchivos;

import Usuarios.Cliente;
import Usuarios.Usuario;
import org.json.JSONException;
import org.json.JSONObject;
import Enum.Suscripcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonUsuario {

    public JsonUsuario() {
    }

    public JSONObject serializarUsuario(Usuario aux) throws JSONException {
        JSONObject jsonUsuario=null;
        File archi= new File("clientes.json");
      try{
        PrintWriter pw = new PrintWriter(archi);
        try {

             jsonUsuario = new JSONObject();
             jsonUsuario.put("tipoUsuario", aux.getClass().getSimpleName());
            jsonUsuario.put("nombre", aux.getNombre());
            jsonUsuario.put("email", aux.getEmail());
            jsonUsuario.put("telefono", aux.getTelefono());
            jsonUsuario.put("usuarioActivo", aux.isUsuarioActivo());
            jsonUsuario.put("fechaRegistro", aux.getFechaRegistro().toString());
            jsonUsuario.put("id", aux.getId());

            if(aux instanceof Cliente) {

                jsonUsuario.put("Suscripcion", ((Cliente) aux).getTipoSuscripcion().toString());
            }
            pw.println(jsonUsuario);
            pw.flush();
            pw.close();
        }catch (JSONException e) {
            e.printStackTrace();

        }}catch(FileNotFoundException e)
      {e.printStackTrace();}

        return jsonUsuario;
    }

    public void deserializarUsuario(JSONObject json, Usuario s) throws JSONException {
       try{
           System.out.println(json.getString("tipoUsuario"));
        s.setNombre(json.getString("nombre"));
        s.setEmail(json.getString("email"));
        s.setTelefono(json.getString("telefono"));
        s.setUsuarioActivo(json.getBoolean("usuarioActivo"));
    }catch (JSONException e) {
       e.printStackTrace();}
    }



    public Cliente deserializarCliente(JSONObject json) throws JSONException {
        Cliente aux;

        try{
        aux= new Cliente();
        deserializarUsuario(json,aux);
        String x=(json.getString("Suscripcion"));
        aux.setTipoSuscripcion(Suscripcion.valueOf(x));



        return aux;
    }catch (JSONException e) {
        e.printStackTrace();
        return null;
        }
    }


}
