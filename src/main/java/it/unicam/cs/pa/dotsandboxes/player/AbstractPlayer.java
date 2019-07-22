package it.unicam.cs.pa.dotsandboxes.player;

import it.unicam.cs.pa.dotsandboxes.structure.IGrid;

/**
 * @param Questa classe ha lo scopo di definire il costruttore base per i player
 *
 */
public abstract class AbstractPlayer implements Player {
	protected IGrid grid = null;

	public AbstractPlayer(IGrid grid) {
		this.grid = grid;
	}
}
