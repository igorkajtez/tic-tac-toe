package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import util.SceneManager;

public class MainMenuController implements Controller, Initializable{
    
    @FXML
    private Stage stage;    

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    public void onNewGameBtnClicked(){
        try {            
            SceneManager.changeScene(stage, getClass().getResource("/view/GameView2.fxml"), new GameController());
        } catch (IOException ex) {
            ex.printStackTrace();
        }                
    }
    
    @FXML
    public void onExitBtnClicked(){
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
