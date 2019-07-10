package main;

import controller.MainMenuController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainMenuView.fxml"));
        MainMenuController menuController = new MainMenuController();
        loader.setController(menuController);        
        
        Parent root = loader.load();
        menuController.setStage(primaryStage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("view/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
