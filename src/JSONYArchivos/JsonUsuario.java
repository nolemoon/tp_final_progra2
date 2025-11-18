package JSONYArchivos;

import Usuarios.Cliente;
import Usuarios.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Enum.Suscripcion;
import org.json.JSONTokener;

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

                Cliente aux2= new Cliente();

                aux2.setUsuarioActivo(aux.isUsuarioActivo());
                aux2.setEmail(aux.getEmail());
                aux2.setNombre(aux.getNombre());
                aux2.setTelefono(aux.getTelefono());
                aux2.setTipoSuscripcion(((Cliente) aux).getTipoSuscripcion());

                jsonUsuario= serializarCliente( aux2, jsonUsuario);
            }
        } catch (JSONException e) {
            e.printStackTrace();

            return jsonUsuario;
        }
        return jsonUsuario;
    }

    public JSONObject serializarCliente(Cliente aux, JSONObject jsonUsuario) throws JSONException {

        try {
            jsonUsuario.put("Suscripcion ", aux.getTipoSuscripcion().toString());
        }catch (JSONException e){e.printStackTrace();}
        catch (NullPointerException e){e.printStackTrace();}

        return jsonUsuario;
    }

    public void serializarListaUsuarios(ArrayList<Usuario> usuarios) throws JSONException {


        for(int i=0; i<usuarios.size(); i++)
        {
            if(usuarios.get(i)!=null) {
                json.put(serializarUsuario(usuarios.get(i)));
            }



        }
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

    public ArrayList<Usuario> deserializarListaUsuarios(JSONArray json) throws JSONException {
        ArrayList<Usuario> aux = new ArrayList<>();

        for(int i=0; i<json.length(); i++){

            if(json.getJSONObject(i)==null){
                continue;
            }

            aux.add(deserializarCliente(json.getJSONObject(i)));
        }
        return aux;
    }

    public void ListaToArchivo() throws JSONException {
        File archivo = new File(nombreArchivo);

        OperacionesArchivos.grabarArchivo(json,nombreArchivo);

    }

    public ArrayList<Usuario> ArchivoToLista(){

        ArrayList<Usuario> lista = new ArrayList<>();
        JSONTokener token = OperacionesArchivos.leerArchivo(nombreArchivo);

        try{
            lista = deserializarListaUsuarios(new JSONArray(token));
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        return lista;
    }
    }
