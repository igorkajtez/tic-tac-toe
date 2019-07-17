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
    
    @FXML
    public void buttonClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String symbol = gameModel.getCurrentPlayerMark();
        
        if(!gameModel.isPlayable()){
            return;
        }
        
        if(!btn.getText().isEmpty()){
              return;    
        }
        
        btn.setText(symbol); 
        
        int col = GridPane.getColumnIndex(btn);
        int row = GridPane.getRowIndex(btn);
        
        gameModel.addSymbol(col, row);        
        gameModel.updateCombos();
        
        gameModel.checkForWin();
        gameModel.checkForTie(gameModel.getBoard());
        gameModel.changePlayer();
    }
        
    public void createBoard(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                btn.setText("");
                btn.setPrefSize(100, 100);
                btn.setOnAction(this::buttonClicked);                
                grid.add(btn, j, i); 
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1Lbl.setText(gameModel.player1Name());
        player2Lbl.setText(gameModel.player2Name());
        
        createBoard();           
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
