package model;
public class Player {
    private String name;
    private char playerSymbol;
    private boolean isCurrentPlayer;

    public Player(String name, char playerSymbol, boolean isCurrentPlayer) {
        this.name = name;
        this.playerSymbol = playerSymbol;
        this.isCurrentPlayer = isCurrentPlayer;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public char getPlayerSymbol(){
        return this.playerSymbol;
    }
    
    public void setPlayerSymbol(char symbol){
        this.playerSymbol = symbol;
    }
    
    public boolean isCurrentPlayer(){
        return this.isCurrentPlayer;
    }
    
    public void setCurrentPlayer(boolean isCurrentPlayer){
        this.isCurrentPlayer = isCurrentPlayer;
    }

}
