package com.gameoflife.controller;

import com.gameoflife.service.EvolutionService;
import com.gameoflife.wrapper.UniverseWrapper;
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
    public UniverseWrapper evolve(@RequestBody UniverseWrapper universeWrapper) {
        return new UniverseWrapper(evolutionService.evolve(universeWrapper.toUniverse()));
    }

}
