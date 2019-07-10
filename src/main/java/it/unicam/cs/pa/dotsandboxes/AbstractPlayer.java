package it.unicam.cs.pa.dotsandboxes;
// Questa classe ha lo scopo di definire il costruttore base per i player
public abstract class AbstractPlayer implements Player {
	protected Grid grid = null;
	public AbstractPlayer(Grid grid) {
		this.grid = grid;
	}
}
