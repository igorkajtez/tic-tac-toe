package model;
public class Player {
    private String name;
    private String playerSymbol;
    private boolean isCurrentPlayer;

    public Player(String name, String playerSymbol, boolean isCurrentPlayer) {
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
    
    public String getPlayerSymbol(){
        return this.playerSymbol;
    }
    
    public void setPlayerSymbol(String symbol){
        this.playerSymbol = symbol;
    }
    
    public boolean isCurrentPlayer(){
        return this.isCurrentPlayer;
    }
    
    public void setCurrentPlayer(boolean isCurrentPlayer){
        this.isCurrentPlayer = isCurrentPlayer;
    }

}
