/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.huffman;

import ec.edu.espol.util.Util;
import java.util.HashMap;

/**
 *
 * @author rogwi
 */
public class Pruebas {

    public static void main(String[] args) {
        //System.out.println(Util.leerTexto("src\\recursos\\archivo.txt"));
        String texto=Util.leerTexto("src\\recursos\\archivo.txt");
        HashMap<String,Integer> mapa=Util.calcularFrecuencias(texto);
        String hex=Util.binarioHexadecimal("0010010010010010011101101101101101101101100000000000000001011011011011011011011001001001001001001111111111111111111111110101010101010101010101");
        
        System.out.println(hex);
        HashMap<String,String> mapaClaves= new HashMap<>();
        mapaClaves.put("A","001");
        mapaClaves.put("B","110");
        Util.guardarTexto("src\\recursos\\archivo.txt", hex, mapaClaves);
        
        /*System.out.println("------------------------Binario-----------------------\n");
        System.out.println(Util.hexadecimalBinario(hex));
           */
    }
    
}
