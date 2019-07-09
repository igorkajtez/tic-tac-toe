package model;
public class Combo {
    private Tile[] tiles;

    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }
    
    public boolean isComplete(){
        if(tiles[0].getText().isEmpty()){
            return false;
        }
        
        return tiles[0].getText().equals(tiles[1].getText()) && 
               tiles[0].getText().equals(tiles[2].getText());
    }
    
    

}
