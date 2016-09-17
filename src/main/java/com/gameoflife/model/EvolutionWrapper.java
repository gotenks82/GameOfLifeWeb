package com.gameoflife.model;

import java.util.List;

/**
 * Created by alexpedini on 17/09/16.
 */
public class EvolutionWrapper {

    int sizeX; // sizes of the universe
    int sizeY; // sizes of the universe

    List<CellWrapper> aliveCells;

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public List<CellWrapper> getAliveCells() {
        return aliveCells;
    }

    public void setAliveCells(List<CellWrapper> aliveCells) {
        this.aliveCells = aliveCells;
    }
}
