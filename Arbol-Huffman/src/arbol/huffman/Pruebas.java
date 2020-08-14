/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.huffman;

import ec.edu.espol.util.Util;

/**
 *
 * @author rogwi
 */
public class Pruebas {

    public static void main(String[] args) {
        //System.out.println(Util.leerTexto("src\\recursos\\archivo.txt"));
        String texto=Util.leerTexto("src\\recursos\\archivo.txt");
        System.out.println(Util.calcularFrecuencias(texto));
        
    }
    
}
