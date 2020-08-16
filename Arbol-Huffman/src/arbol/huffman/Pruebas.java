/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.huffman;

import ec.edu.espol.arbol.ArbolHuffman;
import ec.edu.espol.util.Util;
import java.util.HashMap;

/**
 *
 * @author rogwi
 */
public class Pruebas {

    public static void main(String[] args) {
        /*
        //System.out.println(Util.leerTexto("src\\recursos\\archivo.txt"));
        String texto=Util.leerTexto("src\\recursos\\archivo.txt");
        HashMap<String,Integer> mapa=Util.calcularFrecuencias(texto);
        String hex=Util.binarioHexadecimal("0010010010010010011101101101101101101101100000000000000001011011011011011011011001001001001001001111111111111111111111110101010101010101010101");
        
        //System.out.println(hex);
        HashMap<String,String> mapaClaves= new HashMap<>();
        mapaClaves.put("A","001");
        mapaClaves.put("B","110");
        //Util.guardarTexto("src\\recursos\\archivo.txt", hex, mapaClaves);
        System.out.println("----------------------------Mapa generado----------------------");
        System.out.println(Util.leerMapa("src\\recursos\\archivo.txt_compress.txt"));
        /*System.out.println("------------------------Binario-----------------------\n");
        System.out.println(Util.hexadecimalBinario(hex));
        */
        System.out.println("Prueba CrearArbol");
        ArbolHuffman arbol=new ArbolHuffman();
        
        String texto=Util.leerTexto("src\\recursos\\archivo.txt");//lee el archivo y genera el texto
        HashMap<String,Integer> mapa=Util.calcularFrecuencias(texto);//recorre el texto y hace un mapa
        arbol.calcularArbol(mapa);//usa el mapa para generar un arbol
        //arbol.enOrden();
        System.out.println(arbol.calcularCodigos());
        
    }
    
}
