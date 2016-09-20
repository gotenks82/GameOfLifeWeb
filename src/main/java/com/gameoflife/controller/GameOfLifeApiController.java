package com.gameoflife.controller;

import com.gameoflife.service.EvolutionService;
import com.gameoflife.wrapper.UniverseWrapper;
import com.gameoflife.evolution.ConwayEvolution;
import com.gameoflife.wrapper.EvolutionWrapper;
import com.gameoflife.model.Universe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alexpedini on 17/09/16.
 */
@RestController
public class GameOfLifeApiController {

    @Autowired
    EvolutionService evolutionService;

    @RequestMapping(value = "/evolve", method = RequestMethod.POST)
    public UniverseWrapper evolve(@RequestBody EvolutionWrapper evolutionWrapper) {
        Universe universe = new Universe(evolutionWrapper.getSizeX(), evolutionWrapper.getSizeY());
        evolutionWrapper.getAliveCells().forEach((cell) -> {
            universe.setState(cell.getX(), cell.getY(), true);
        });

        return new UniverseWrapper(evolutionService.evolve(universe));
    }

}
