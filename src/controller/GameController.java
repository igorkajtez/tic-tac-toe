package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.GameModel;
import model.JavaFxTile;

public class GameController implements Controller, Initializable{
    private GameModel gameModel = new GameModel();
    
    @FXML
    private Stage stage;
    @FXML
    private Label player1Lbl;
    @FXML
    private Label player2Lbl;    
    @FXML
    private GridPane grid; 
    
    private JavaFxTile[][] tiles = new JavaFxTile[3][3];
    
    @FXML
    public void buttonClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();
        char symbol = gameModel.getCurrentPlayerMark();
        
        if(!gameModel.isPlayable()){
            return;
        }
        
        if(!btn.getText().isEmpty()){
              return;    
        }
        
        btn.setText(String.valueOf(symbol));        
        
        gameModel.checkForWin();
        gameModel.checkForTie(tiles);
        gameModel.changePlayer();
    }
        
    public void createBoard(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                JavaFxTile btn = new JavaFxTile();
                btn.setOnAction(this::buttonClicked);                
                grid.add(btn, j, i);   
                tiles[j][i] = btn;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1Lbl.setText(gameModel.player1Name());
        player2Lbl.setText(gameModel.player2Name());
        
        createBoard();           
        gameModel.addAllCombos(tiles);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
