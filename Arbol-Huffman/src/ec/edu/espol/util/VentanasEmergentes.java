/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import javafx.scene.control.Alert;

/**
 *
 * @author rogwi
 */
public class VentanasEmergentes {
     /**
     * Crea una ventana emergente del tipo Error
     * @param titulo
     * @param mensaje 
     */
    public static void crearError(String titulo,String mensaje){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    /**
     * Crea una ventana emergente del tipo Information.
     * @param titulo
     * @param mensaje 
     */
    public static void crearInformacion(String titulo,String mensaje){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    /**
     * Crea una ventana emergente del tipo Warning.
     * @param titulo
     * @param mensaje 
     */
    public static void crearAlerta(String titulo,String mensaje){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    /**
     * Crea una ventana emergente dle tipo confirmation.
     * @param titulo
     * @param mensaje 
     */
    public static void crearConfirmacion(String titulo,String mensaje){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
