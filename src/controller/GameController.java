package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.GameModel;
import model.Tile;

public class GameController implements Initializable{

    private GameModel gameModel = new GameModel();
    
    @FXML
    private GridPane grid; 
    private Tile[][] tiles = new Tile[3][3];   
    private Tile button = new Tile();
    
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
                Tile btn = new Tile();                
                btn.setOnAction(this::buttonClicked);                
                grid.add(btn, j, i);   
                tiles[j][i] = btn;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createBoard();        
        gameModel.addAllCombos(tiles);
    }

}
