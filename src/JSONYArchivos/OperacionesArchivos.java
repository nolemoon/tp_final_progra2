package JSONYArchivos;

import org.json.JSONArray;

import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class OperacionesArchivos {

    /**
     * Graba un objeto JSON en un archivo.
     * @param j objeto JSON a grabar.
     * @param nombreArchivo nombre del archivo donde se va a grabar.
     */
    public static void grabarArchivo(JSONArray j, String nombreArchivo){
        try{
            FileWriter fw = new FileWriter(nombreArchivo, false);
            fw.write(j.toString(4));
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

        return token;
    }

}
