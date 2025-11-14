package JSONYArchivos;

import Usuarios.Cliente;
import Usuarios.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Enum.Suscripcion;
import java.io.File;

import java.util.ArrayList;

public class JsonUsuario {
public String nombreArchivo="Usuarios.json";
public static final JSONArray json=new JSONArray();

    public JsonUsuario() {
    }

    public JSONObject serializarUsuario(Usuario aux) throws JSONException {
        JSONObject jsonUsuario = null;
        File archi = new File("clientes.json");

        try {

            jsonUsuario = new JSONObject();
            jsonUsuario.put("tipoUsuario", aux.getClass().getSimpleName());
            jsonUsuario.put("nombre", aux.getNombre());
            jsonUsuario.put("email", aux.getEmail());
            jsonUsuario.put("telefono", aux.getTelefono());
            jsonUsuario.put("usuarioActivo", aux.isUsuarioActivo());
            jsonUsuario.put("fechaRegistro", aux.getFechaRegistro().toString());
            jsonUsuario.put("id", aux.getId());

            if (aux instanceof Cliente) {

                jsonUsuario.put("Suscripcion", ((Cliente) aux).getTipoSuscripcion().toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();

            return jsonUsuario;
        }
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

    public ArrayList<Usuario> deserializarArrayUsuarios(JSONArray json) throws JSONException {
        ArrayList<Usuario> aux = new ArrayList<>();
        for(int i=0; i<json.length(); i++){
            aux.add(deserializarCliente(json.getJSONObject(i)));
        }
        return aux;
    }

    public void serializarArrayUsuarios(ArrayList<Usuario> usuarios) throws JSONException {


        for(int i=0; i<usuarios.size(); i++)
        {
            if(usuarios.get(i)!=null) {
            json.put(serializarUsuario(usuarios.get(i)));
        }



    }OperacionesArchivos.grabarArchivo(json, nombreArchivo);
}}
