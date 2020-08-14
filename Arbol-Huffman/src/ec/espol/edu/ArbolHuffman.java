
package ec.espol.edu;

import java.util.HashMap;

/**
 *
 * @author rogwi
 */
public class ArbolHuffman {
    private Nodo raiz;
    
    private class Nodo{
        //Creo que estos valores deberiamos manejra en el nodo
        Nodo izq;
        Nodo der;
        String  caracter;
        //int frecuencia;

        public Nodo(String caracter) {
            this.caracter = caracter;
        }  
    }
   
    
    /**
     * Recibe el mapa de frecuencias de los carcateres y genera el Arbol huffman
     * @param mapa 
     */
    public void calcularArbol(HashMap<String,Integer> mapa){
        throw  new UnsupportedOperationException("");
    }
    /**
     * Genera un mapa con los codigos de cada caracter en base al recorrido del arbol
     * @return 
     */
    public HashMap<String,String> calcularCodigos(){
        throw  new UnsupportedOperationException("");
    }
    /**
     * Recibe el texto leido y el mapa con los codigos de cada caracter y retorna
     * el codio huffman correspondiente.
     * @param texto
     * @param mapa
     * @return 
     */
    public static String codificar(String texto, HashMap<String, String> mapa){
        throw  new UnsupportedOperationException("");
    }
    /**
     * Recibe el codio Huffman y el mapa con los codigos de cada caracter y retorna
     * el Texto original
     * @param texto
     * @param mapa
     * @return 
     */
    public static String decodificar(String texto,HashMap<String,String> mapa){
        throw  new UnsupportedOperationException("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
