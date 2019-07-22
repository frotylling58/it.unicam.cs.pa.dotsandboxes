package it.unicam.cs.pa.dotsandboxes.manager;

import it.unicam.cs.pa.dotsandboxes.player.Bot;
import it.unicam.cs.pa.dotsandboxes.player.RealPlayer;
import it.unicam.cs.pa.dotsandboxes.structure.GridFactory;
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;

/**
 * @param
 *
 */
public class ControllerManager {

	static Strategy dumb = new DumbStrategy();

	static GridFactory gridFactory = Utils::createNewGrid;

	public static Controller createNewInteractiveController(int n) {
		IGrid grid = gridFactory.createNewInstance(n);

		Bot bot = new Bot(grid, dumb);
		RealPlayer p1 = new RealPlayer(grid);

		return new Controller(bot, p1, grid);
	}

	/*
	 * public static Controller createNewRandomController(int n) { IGrid grid =
	 * gridFactory.createNewInstance(n);
	 * 
	 * Bot bot = new Bot(grid, dumb); Bot bot2 = new Bot(grid, dumb);
	 * 
	 * return new Controller(bot, bot2, grid); }
	 */
}
