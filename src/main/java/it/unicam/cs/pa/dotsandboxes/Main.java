/**
 * 
 */
package it.unicam.cs.pa.dotsandboxes;

/**
 * @author Utente
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grid grid = new Grid(4);
		Strategy dumb = new DumbStrategy();
		Bot bot = new Bot(grid, dumb);
		Bot bot2 = new Bot(grid, dumb);
		RealPlayer p1 = new RealPlayer(grid);
		Controller controller = new Controller(bot, bot2, grid);
		System.out.print(grid);
		do {
			controller.nextTurn();
			System.out.print(grid);
			System.out.println("------");
		} while (controller.finished() == false);
			
		controller.getWinner();
		System.out.println("Bye bye by Mattia and Donoval");
	}
	
}
