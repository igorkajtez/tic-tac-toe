package model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    
    private Player player1;
    private Player player2;
    private List<Combo> combos = new ArrayList<>();    
    private Tile[][] board = new Tile[3][3];
    private Tile tile = new Tile();
    private boolean playable = true; 

    public GameModel() {
        player1 = new Player("Player 1", 'X', true);
        player2 = new Player("Player 2", 'O', false);         
        createBoard();
    }
    
    public char getCurrentPlayerMark(){
        return player1.isCurrentPlayer() ? player1.getPlayerSymbol() : player2.getPlayerSymbol();
    }
    
    public Player getCurrentPlayer(){
        return player1.isCurrentPlayer() ? player1 : player2;
    }
    
    public void changePlayer(){
        if(player1.isCurrentPlayer()){
            player1.setCurrentPlayer(false);
            player2.setCurrentPlayer(true);
        }else{
            player2.setCurrentPlayer(false);
            player1.setCurrentPlayer(true);
        }
    }
    
    public boolean isPlayable(){
        return this.playable;
    }
    
    public void addAllCombos(Tile[][] board){        
        //rows
        for(int row = 0; row < 3; row++){
            combos.add(new Combo(board[0][row], board[1][row], board[2][row]));
        }
        //columns
        for(int col = 0; col < 3; col++){
            combos.add(new Combo(board[col][0], board[col][1], board[col][2]));
        }
        //diagonals
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));
        
    }
    
    public void createBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[j][i] = new Tile();                
            }            
        }               
    }
    
    public boolean boardFull(Tile[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[j][i].getText().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }  
    
    public void checkForTie(Tile[][] board){
        if(boardFull(board) && playable){
            playable = false;
            System.out.println("It's a tie");
        }
    }
    
    public void checkForWin(){        
        for(Combo combo : combos){
            if(combo.isComplete()){
                playable = false;
                System.out.println(getCurrentPlayer().getName() + " wins");
                break;
            }            
        }
    }
    
    

}