package JSONYArchivos;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;

public final class OperacionesArchivos {

    /**
     * Graba un objeto JSON en un archivo.
     * @param jsonArray objeto JSON a grabar.
     * @param nombreArchivo nombre del archivo donde se va a grabar.
     */
    public static void grabarArchivo(JSONArray jsonArray, String nombreArchivo){
        try{
            PrintWriter fw = new PrintWriter(new FileWriter(nombreArchivo));
            fw.println(jsonArray.toString(4));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee un archivo y devuelve un JSON Tokener
     * @param file archivo a leer.
    * @return tokener leido del archivo.
     */
    public static JSONTokener leerArchivo(String file){
        JSONTokener token = null;

        try{
            token = new JSONTokener(new FileReader(file));

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(JSONException e){
            e.printStackTrace();
        }

        return token;
    }

}
