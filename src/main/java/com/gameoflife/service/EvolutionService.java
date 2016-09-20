package com.gameoflife.service;

import com.gameoflife.evolution.ConwayEvolution;
import com.gameoflife.evolution.Evolution;
import com.gameoflife.model.Universe;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexpedini on 20/09/16.
 */
@Service
public class EvolutionService {

    private Map<String,Evolution> evolutionImplementations;

    @PostConstruct
    private void init(){
        evolutionImplementations = new HashMap<>();
        evolutionImplementations.put("conway", new ConwayEvolution());
    }

    public Universe evolve(Universe universe) {
        return evolve(universe, "conway");
    }

    public Universe evolve(Universe universe, String implementation) {
        if (evolutionImplementations.containsKey(implementation)) {
            return evolutionImplementations.get(implementation).evolve(universe);
        }
        return null;
    }

}
