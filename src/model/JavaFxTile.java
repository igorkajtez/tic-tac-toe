package model;

import javafx.scene.control.Button;

public class JavaFxTile extends Button implements ITile{

    public JavaFxTile() {
        setSymbol("");
        setTileHeight(100);
        setTileWidth(100);
    }

    @Override
    public String getSymbol() {
        return this.getText();
    }

    @Override
    public void setSymbol(String symbol) {
        this.setText(symbol);
    }

    @Override
    public void setTileWidth(double width) {
        this.setPrefWidth(width);
    }

    @Override
    public void setTileHeight(double height) {
        this.setPrefHeight(height);
    }

}
