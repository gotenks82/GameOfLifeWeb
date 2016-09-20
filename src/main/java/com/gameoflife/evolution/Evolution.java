package com.gameoflife.evolution;

import com.gameoflife.model.Universe;

/**
 * Created by alexpedini on 20/09/16.
 */
public interface Evolution {
    Universe evolve(Universe universe);
    boolean nextState(Universe universe, int x, int y);
}
