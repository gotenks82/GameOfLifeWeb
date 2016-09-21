package com.gameoflife.wrapper;

import com.gameoflife.model.Universe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpedini on 17/09/16.
 */
public class UniverseWrapper {

    private int sizeX;
    private int sizeY;
    private List<CellWrapper> aliveCells;

    public UniverseWrapper() {

    }

    public UniverseWrapper(Universe universe) {
        this.sizeX = universe.getSizeX();
        this.sizeY = universe.getSizeY();
        this.aliveCells = new ArrayList<CellWrapper>();
        for (int i=0; i < sizeX; i++) {
            for (int j=0; j < sizeY; j++) {
                if (universe.getState(i,j)) {
                    aliveCells.add(new CellWrapper(i,j));
                }
            }
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setAliveCells(List<CellWrapper> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public List<CellWrapper> getAliveCells() {
        return aliveCells;
    }

    public Universe toUniverse() {
        Universe universe = new Universe(sizeX, sizeY);
        aliveCells.forEach((cell) -> universe.setState(cell.getX(), cell.getY(), true));

        return universe;
    }
}
