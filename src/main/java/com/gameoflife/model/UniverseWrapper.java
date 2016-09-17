package com.gameoflife.model;

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

    public List<CellWrapper> getAliveCells() {
        return aliveCells;
    }
}
