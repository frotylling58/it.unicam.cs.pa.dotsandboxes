package it.unicam.cs.pa.dotsandboxes.structure;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unicam.cs.pa.dotsandboxes.structure.Grid;

public class testGrid {

	@Test()
	public void testCreateGrid() {

		Grid grid = new Grid(3);
		assertEquals(3, grid.getSize());
	}

	public void testIsFinished() {
		assertFalse(new Grid(4).isFinished());
	}
}