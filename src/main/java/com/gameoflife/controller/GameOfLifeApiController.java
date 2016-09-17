package com.gameoflife.controller;

import com.gameoflife.model.UniverseWrapper;
import com.gameoflife.model.Evolution;
import com.gameoflife.model.EvolutionWrapper;
import com.gameoflife.model.Universe;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alexpedini on 17/09/16.
 */
@RestController
public class GameOfLifeApiController {

    @RequestMapping(value = "/evolve", method = RequestMethod.POST)
    public UniverseWrapper evolve(@RequestBody EvolutionWrapper evolutionWrapper) {
        Universe universe = new Universe(evolutionWrapper.getSizeX(), evolutionWrapper.getSizeY());
        evolutionWrapper.getAliveCells().forEach((cell) -> {
            universe.setState(cell.getX(), cell.getY(), true);
        });

        return new UniverseWrapper(Evolution.evolve(universe));
    }

}
