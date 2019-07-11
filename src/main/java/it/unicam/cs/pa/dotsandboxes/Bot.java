package it.unicam.cs.pa.dotsandboxes;

abstract class Bot  implements Player {
	//private Strategy strategy = null;
	
	protected Grid grid;
	
	public Bot() {
		//super(grid);
		
	}

	public void setGrid(Grid grid)
	{
		this.grid = grid;
	}
	
	@Override
	public Line drawLine() {
		return null;
	}

}
