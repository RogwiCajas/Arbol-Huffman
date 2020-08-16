
package ec.edu.espol.arbol;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        int frecuencia;

        public Nodo(String caracter) {
            this.caracter = caracter;
        }
        public Nodo(String caracter,int f){
            this.caracter=caracter;
            this.frecuencia=f;
        }

        @Override
        public String toString() {
            return  caracter + "," + frecuencia; 
        }
        
    }

    public ArbolHuffman() {
    }
    
    
    /**
     * Recibe el mapa de frecuencias de los carcateres y genera el Arbol huffman
     * @param mapa 
     */
    public void calcularArbol(HashMap<String,Integer> mapa){
           //Obetener orden de menor a mayor
           List<Nodo> hojas=new LinkedList<>();
           
           Iterator<Map.Entry<String,Integer>> it= mapa.entrySet().iterator();
           while(it.hasNext()){
                Map.Entry<String,Integer> e=it.next();
                Nodo n=new Nodo(e.getKey(),e.getValue());
                hojas.add(n);
           }
           hojas.sort((Nodo n1,Nodo n2) -> n1.frecuencia-n2.frecuencia);
           Deque<Nodo> pila=new LinkedList<>();
           pila.addAll(hojas);
           System.out.println(pila);
           //REcorro la pila mientras no este vacia
           while(!pila.isEmpty()){
               if(pila.size()>=2){
                   Nodo izq=pila.pop();
                   Nodo der=pila.pop();
                   System.out.println(izq+" : "+der);
                   //Creo el Nodo superior
                   Nodo padre=new Nodo(izq.caracter.concat(der.caracter),der.frecuencia+izq.frecuencia);
                   padre.der = der;
                   padre.izq = izq;
                   pila.offer(padre);
               }
               else{
                   this.raiz=pila.pop();
               }
           }
           
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
    
    /**
     * Imprime el arbol en preOrden
     * raiz, izq,derecha
     */
    public void preOrden(){
        preOrden(raiz);
    }
    private void preOrden(Nodo n){
        if(n!=null){
            System.out.println(n.caracter);
            preOrden(n.izq);
            preOrden(n.der);
        }
    }
    /**
     * Imprime el arbol en PostOrden
     * izq, derecho, raiz
     */
    public void postOrden(){
        postOrden(raiz);
    }
    private void postOrden(Nodo n)
    {
        if(n!=null){
            postOrden(n.izq);         
            postOrden(n.der);
            System.out.println(n.caracter);
        }
    }
    /**
     * Imprime el arbol en Orden
     * izq, raiz, derecho
     */
    public void enOrden(){
        enOrden(raiz);
    }
    private void enOrden(Nodo n){
        if(n!=null){
            enOrden(n.izq);
            System.out.println(n.caracter);
            enOrden(n.der);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
