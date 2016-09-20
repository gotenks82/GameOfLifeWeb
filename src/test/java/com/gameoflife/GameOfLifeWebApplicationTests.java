package com.gameoflife;

import com.gameoflife.wrapper.CellWrapper;
import com.gameoflife.wrapper.EvolutionWrapper;
import com.gameoflife.wrapper.UniverseWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameOfLifeWebApplicationTests {

	@Test
	public void evolveUniverse() {
		TestRestTemplate rest = new TestRestTemplate();

		EvolutionWrapper request = new EvolutionWrapper();
		request.setSizeX(10);
		request.setSizeY(15);
		List<CellWrapper> aliveCells = new ArrayList<CellWrapper>();
		aliveCells.add(new CellWrapper(1,2));
		aliveCells.add(new CellWrapper(2,2));
		aliveCells.add(new CellWrapper(3,2));
		request.setAliveCells(aliveCells);

		UniverseWrapper response = rest.postForObject("http://localhost:8080/evolve",request, UniverseWrapper.class);

		assertEquals(10, response.getSizeX());
		assertEquals(15, response.getSizeY());
		assertEquals(3, response.getAliveCells().size());
		for (CellWrapper cellWrapper : response.getAliveCells()) {
			assertEquals(2, cellWrapper.getX());
		}
	}

}
