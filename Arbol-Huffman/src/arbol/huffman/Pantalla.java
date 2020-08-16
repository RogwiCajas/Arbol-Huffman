/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.huffman;

import ec.edu.espol.arbol.ArbolHuffman;
import ec.edu.espol.util.Util;
import ec.edu.espol.util.VentanasEmergentes;
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
        
        btnDescomprimir.setStyle("-fx-text-fill: White;-fx-background-color: linear-gradient(#61a2b1, #2A5058);");
        btnComprimir.setStyle("-fx-background-color: linear-gradient(#61a2b1, #2A5058); -fx-text-fill: White;");
        
        
        //Contenedor
        contenedor.setPadding(new Insets(150,70,70,100));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setStyle("-fx-background-color: indianred");
        
        //Titulo
        titulo.setStyle("-fx-text-fill: Black; -fx-font-size: 35; -fx-font-weight: BOLD; -fx-background-color: Cyan");
        titulo.setAlignment(Pos.CENTER);
        titulo.setLayoutX(150);
        titulo.setLayoutY(80);
        
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
                            Descomprimir(stage);
                            
			}
	});
    }
    private String elegirArchivo(Stage stage ,String msj){
        FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle(msj);
                            fileChooser.getExtensionFilters().addAll(
                            new ExtensionFilter("Text Files", "*.txt"));
                            File selectedFile = fileChooser.showOpenDialog(stage);
                            if(selectedFile==null){
                                return "";
                            }
                            return selectedFile.getPath();
    }
    private void Comprimir(Stage stage){
        //abro el archivo
        String path=elegirArchivo(stage, "Escoja archivo a Comprimir: ");
        if(!path.equals("")){
        String texto=Util.leerTexto(path);
        if(texto!=null ){
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
        VentanasEmergentes.crearInformacion("Estado Compresion", "Archivo comprimido en :"+path);
        }
        }
    }    
    private void Descomprimir(Stage stage){
        //abro el archivo
        String path=elegirArchivo(stage, "Escoja archivo a Descomprimir: ");
        if(!path.equals("")){
        String texto=Util.leerTexto(path);
        if(texto!=null ){//Si no hubo error al abrir
            //Paso a binario
            String binario=Util.hexadecimalBinario(texto);
            //Creo el mapa de codigo, depuro el nombre
            HashMap<String,String> codigos=Util.leerMapa(path+"_compress.txt");
            if(!codigos.isEmpty()){
                //DEscomprimo
                String original = ArbolHuffman.decodificar(binario, codigos);
                //Escribo en el archivo
                Util.actualizarArchivo(path,original);
                VentanasEmergentes.crearInformacion("Estado Desccmpresion", "Archivo descomprimido en :"+path);
            }
        }    
        }
    }    
    public Pane getRoot(){
        return this.root;
    }
    public void setRoot(Pane nuevoRoot){
        this.root=nuevoRoot;
    }
}
