/*
 * El TDA Util será el encargado de tener las funcionalidades complementarias 
 * necesarias para la implementación del proyecto
 */
package ec.edu.espol.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author rogwi
 */
public class Util {
    
    
    /**
     * Esta función recibe el nombre del archivo, 
     * procede a leer el texto que tiene un archivo y retorna una cadena de caracteres
     * @param nombreArchivo
     * @return 
     */
    public static String leerTexto(String nombreArchivo){
        String texto="";
        
        try {
            File file=new File(nombreArchivo);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            texto=br.readLine();
            if(texto==null) throw  new NullPointerException("Archivo Vacío");
            
        } catch ( NullPointerException | IOException e) {
            if(e instanceof NullPointerException){
                System.err.println("Archivo Vacio!!");
            }else{
                System.err.println("Archivo no encontrado!!");
            }
        }
        return  texto;
        
    }
    /**
     * Esta función recibe el texto que se leyó desde el archivo y procede a calcular la frecuencia de cada uno de los caracteres del texto, 
     * finalmente retorna un mapa con la información de la frecuencia de cada uno de los caracteres que contiene el texto.
     * @param texto
     * @return 
     */
    public static HashMap<String,Integer> calcularFrecuencias(String texto ){
        HashMap<String,Integer> mapa=new HashMap<>();
        for(char c: texto.toCharArray()){
            String letra=String.valueOf(c);
            if(mapa.containsKey(letra)){
                mapa.put(letra,mapa.get(letra)+1);
            }else{
                mapa.put(letra,1);
            }
        }
        return mapa;
            
        
    }
    /**
     * Recibe una cadena en binario y la transforma en hexadcimal, agrupando en grupos de 4
     * Completando con ceros si un grupo no es de 4, agregando tantos "-"  como ceros se uso para completar
     * el ultimo bloque.
     * @param binario
     * @return 
     */
    public static String binarioHexadecimal(String binario){
        StringBuilder hex=new StringBuilder();
        //Completamos el ultimo Byte
        int l=binario.length();
        StringBuilder corregido = new StringBuilder();
        corregido.append(binario);
        int residuo=l%4;
        if(residuo!=0){
            for(int j=0;j<residuo;j++){
                corregido.append("0");
            }
        }
        //Transforma a hex
        for(int i=0 ; i<corregido.length() ; i+=4){//REcorro de 4 en 4
            int numero=Integer.parseInt(corregido.substring(i,i+4),2);
            String reph=Integer.toString(numero,16);
            hex.append(reph);
        }
        //añado - por cada 0
        for(int k=0; k<residuo; k++){
            hex.append("-");
        }
        return hex.toString();
    }
    /**
     * Esta función recibe una cadena de caracteres que representa la 
     * cadena codificada en hexadecimal y procede a transformarla en formato binario. 
     * En caso de que existan signos menos al final, se deberá remover la cantidad de ceros 
     * equivalente a los signos menos que aparecen en la cadena de caracteres. 
     * @param hexadecimal
     * @return 
     */
    public static String hexadecimalBinario(String hexadecimal){
        StringBuilder bin = new StringBuilder();
        int ceros=0;
        for(int i=0; i<hexadecimal.length() ; i++){
            String c=hexadecimal.substring(i, i+1);
            if(c.equals("-")){
                ceros++;
            }else{    
                int valInt=Integer.parseInt(c, 16);
                String binario=Integer.toBinaryString(valInt);
                //completo el bloque de 4 de ceros a la izq p
                StringBuilder corregido=new StringBuilder();
                int dif=4-binario.length();
                for(int j=0 ;j<dif ; j++){
                    corregido.append("0");
                }
                corregido.append(binario);
                bin.append(corregido);
            }
        }
        //quito ceros yu retorno
        return bin.substring(0, bin.length()-ceros);
    }
    /**
     *  La función procede a almacenar el nuevo texto en el archivo y genera un 
     * archivo adicional con la tabla de códigos, esto es con la finalidad de posteriormente 
     * poder decodificar el archivo en función del código asignado a cada letra. 
     * El nombre del archivo adicional puede ser definido de la siguiente manera:              
     *          nombreArchivo+” _compress.txt”.
     * @param nombreArchivo
     * @param texto
     * @param mapa 
     */
    public static void guardarTexto(String nombreArchivo,String texto,HashMap<String,String > mapa){
        throw  new UnsupportedOperationException("");
    }
    /**
     * Esta función lee el mapa de códigos para cada carácter desde un archivo 
     * y lo retorna en un mapa
     * @param nombreArchivo
     * @return 
     */
    public static HashMap<String,String> leerMapa(String nombreArchivo){
        throw  new UnsupportedOperationException("");
    }
}
