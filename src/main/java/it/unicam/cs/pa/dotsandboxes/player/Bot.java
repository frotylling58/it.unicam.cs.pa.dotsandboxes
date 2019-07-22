package it.unicam.cs.pa.dotsandboxes.player;

import it.unicam.cs.pa.dotsandboxes.manager.Strategy;
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;
import it.unicam.cs.pa.dotsandboxes.structure.Line;

/**
 * @param
 *
 */
public class Bot extends AbstractPlayer {
	private Strategy strategy = null;

	public Bot(IGrid grid, Strategy strategy) {
		super(grid);
		this.strategy = strategy;
	}

	@Override
	public Line drawLine() {
		return strategy.suggestLine(grid);
	}

}
