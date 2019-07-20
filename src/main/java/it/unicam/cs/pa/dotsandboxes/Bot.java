package it.unicam.cs.pa.dotsandboxes;

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
