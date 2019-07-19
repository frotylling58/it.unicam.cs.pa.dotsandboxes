package it.unicam.cs.pa.dotsandboxes;

public class ControllerManager {

	
	static Strategy dumb = new DumbStrategy();
	
	
	public static Controller createNewInteractiveController(int n)
	{
		Grid grid = new Grid(n);
		
		Bot bot = new Bot(grid, dumb);
		//Bot bot2 = new Bot(grid, dumb);
		RealPlayer p1 = new RealPlayer(grid);
		
		return new Controller(bot, p1, new Grid(n));
	}
	
	
	
}
