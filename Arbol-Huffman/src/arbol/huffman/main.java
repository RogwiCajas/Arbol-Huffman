
package arbol.huffman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rogwi
 */
public class main extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("Codigo HUFFMAN");
        stage.setScene(new Scene(new Pantalla(stage).getRoot(),1000,600));
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
