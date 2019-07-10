package model;

public class Tile implements ITile{
    private String text;
    private double width;
    private double height;

    public Tile() {
        this.text = "";
        this.height = 100;
        this.width = 100;
    }

    @Override
    public String getSymbol() {
        return this.text;
    }
    
    @Override
    public void setSymbol(String symbol) {
        this.text = symbol;
    }

    @Override
    public void setTileWidth(double width) {
        this.width = width;
    }

    @Override
    public void setTileHeight(double height) {
        this.height = height;
    }

    
    
    
    

}
