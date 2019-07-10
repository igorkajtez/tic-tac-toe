package util;

import controller.Controller;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    
    public static void changeScene(Stage stage, URL fxmlUrl, Controller controller) throws IOException{
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        controller.setStage(stage);
        loader.setController(controller);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);        
    }

}
