package com.gameoflife.model;

import javafx.scene.control.Cell;

/**
 * Created by alexpedini on 17/09/16.
 */
public class CellWrapper {
    private int x;
    private int y;

    public CellWrapper() {

    }

    public CellWrapper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
