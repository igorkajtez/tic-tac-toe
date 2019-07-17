package model;
public class Combo {
    private String[] tiles;

    public Combo(String... tiles) {
        this.tiles = tiles;
    }
    
    public boolean isComplete(){
        if(tiles[0].isEmpty()){
            return false;
        }
        
        return tiles[0].equals(tiles[1]) && 
               tiles[0].equals(tiles[2]);
    }

}
