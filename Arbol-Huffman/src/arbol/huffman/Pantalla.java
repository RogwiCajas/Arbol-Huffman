/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.huffman;

import ec.edu.espol.arbol.ArbolHuffman;
import ec.edu.espol.util.Util;
import java.io.File;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author rogwi
 */
public class Pantalla {
    
    private Button btnComprimir;
    private Button btnDescomprimir;
    private Label titulo;
    
    private VBox contenedor;
    private Pane root;
    
    
    public Pantalla(Stage stage){
        iniciar(stage);
    }
    private void iniciar(Stage stage){
        this.contenedor = new VBox(40);
        this.root=new StackPane(contenedor);
        this.titulo= new Label("--MENU PRINCIPAL--");
        this.btnDescomprimir = new Button("DESCOMPRIMIR");
        this.btnComprimir = new Button("COMPRIMIR");
        
        
        
        estilos();
        setearAcciones(stage);
        contenedor.getChildren().addAll(titulo,btnComprimir,btnDescomprimir);
    }
    
    private void estilos(){
        contenedor.setPadding(new Insets(100,70,70,100));
        contenedor.setAlignment(Pos.CENTER);
        btnDescomprimir.setPrefSize(240,40);
        btnComprimir.setPrefSize(240, 40);
        
    }
     private  void setearAcciones(Stage stage){
        btnComprimir.setOnAction( new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent t) {
                            Comprimir(stage);
			}
	});
        btnDescomprimir.setOnAction( new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent t) {
                            
			}
	});
    }
    private String elegirArchivo(Stage stage ,String msj){
        FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle(msj);
                            fileChooser.getExtensionFilters().addAll(
                            new ExtensionFilter("Text Files", "*.txt"));
                            File selectedFile = fileChooser.showOpenDialog(stage);
                            return selectedFile.getPath();
    }
    private void Comprimir(Stage stage){
        //abro el archivo
        String path=elegirArchivo(stage, "Escoja archivo a Comprimir: ");
        String texto=Util.leerTexto(path);
        //genero el mapa de frecuencia
        HashMap<String,Integer> mapaF=Util.calcularFrecuencias(texto);
        //Creo el tda Arbol
        ArbolHuffman arbol=new ArbolHuffman();
        arbol.calcularArbol(mapaF);
        //genero el mapa de compresion
        HashMap<String,String> mapaC=arbol.calcularCodigos();
        //Codifico a binario
        String codificadoB=ArbolHuffman.codificar(texto, mapaC);
        //Paso a Hexadecimal
        String codificadoH=Util.binarioHexadecimal(codificadoB);
        //EScribo y genero archivo de codigos
        Util.guardarTexto(path,codificadoH, mapaC);   
    }
    private void Descomprimir(Stage stage){
        //abro el archivo
        String path=elegirArchivo(stage, "Escoja archivo a Descomprimir: ");
        String texto=Util.leerTexto(path);
        //Paso a binario
        String binario=Util.hexadecimalBinario(texto);
        //Creo el mapa de codigo
        HashMap<String,String> codigos=Util.leerMapa(path+"_compress.txt");
        //DEscomprimo
        String original = ArbolHuffman.decodificar(binario, codigos);
        //Escribo en el archivo
        Util.actualizarArchivo(path,original);
    }
    public Pane getRoot(){
        return this.root;
    }
    public void setRoot(Pane nuevoRoot){
        this.root=nuevoRoot;
    }
}
