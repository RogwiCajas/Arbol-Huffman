/*
 * El TDA Util será el encargado de tener las funcionalidades complementarias 
 * necesarias para la implementación del proyecto
 */
package ec.edu.espol.util;

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
        throw  new UnsupportedOperationException("");
    }
    /**
     * Esta función recibe el texto que se leyó desde el archivo y procede a calcular la frecuencia de cada uno de los caracteres del texto, 
     * finalmente retorna un mapa con la información de la frecuencia de cada uno de los caracteres que contiene el texto.
     * @param texto
     * @return 
     */
    public static HashMap<String,Integer> calcularFrecuencias(String texto ){
        throw  new UnsupportedOperationException("");
    }
    /**
     * Recibe una cadena en binario y la transforma en hexadcimal, agrupando en grupos de 4
     * Completando con ceros si un grupo no es de 4, agregando tantos "-"  como ceros se uso para completar
     * el ultimo bloque.
     * @param binario
     * @return 
     */
    public static String binarioHexadecimal(String binario){
        throw  new UnsupportedOperationException("");
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
        throw  new UnsupportedOperationException("");
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
