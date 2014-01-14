package labopti;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * Crea un scanner y lee archivos.
 * @author Luis Loyola
 */
public class Reader {
    private String path;
    private File archivo;
    private Scanner sc;
    
    /**
     * Instancia la clase Reader arrojando los errores posibles.
     * Muestra un JFileChooser para seleccionar el archivo a leer.
     * @throws Exception si no se puede abrir el archivo, o no se encuentra.
     */
    Reader() throws Exception{
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(fc);
        try{
            path=fc.getSelectedFile().getAbsolutePath();
            archivo = new File(path);
            sc = new Scanner(archivo);
        }
       catch(Exception e){
           sc.close();
           throw e;
       }
    }
    
    /**
     * Instancia la clase Reader arrojando los errores posibles.
     * @param path direccion del archivo a leer.
     * @throws Exception si no se puede abrir el archivo, o no se encuentra.
     */
    Reader(String path) throws Exception{
        this.path=path;
        try{
            File archivo = new File(path);
            Scanner sc = new Scanner(archivo);
        }
        catch(Exception e){
            sc.close(); 
            throw e;
        }
    }
    
    /**
     * Lee una linea del archivo.
     * @return linea leida.
     */
    public String readLine(){
        if(sc.hasNextLine()){
            return sc.nextLine();
        }
        else{
        return "";
        }
    }
    
    /**
     * Verifica si el archivo contiene mas lineas por leer.
     * @return true si puede leer, false en caso contrario.
     */
    public boolean HasNextLine(){
        return sc.hasNextLine();
    }
    
    /**
     * Cierra la lectura del archivo.
     */
    public void close(){
        sc.close();
    }
    
    /**
     * Obtiene la dirección del archivo.
     * @return dirección del archivo.
     */
    public String get_path(){
        return path;
    }
    
    /**
     * Retorna el archivo como objeto.
     * @return el archivo como objeto File.
     */
    public File get_file(){
        return archivo;
    }
}
