package model;
public class Combo {
    private ITile[] tiles;

    public Combo(ITile... tiles) {
        this.tiles = tiles;
    }
    
    public boolean isComplete(){
        if(tiles[0].getSymbol().isEmpty()){
            return false;
        }
        
        return tiles[0].getSymbol().equals(tiles[1].getSymbol()) && 
               tiles[0].getSymbol().equals(tiles[2].getSymbol());
    }
    
    

}
