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
		RealPlayer p1 = new RealPlayer(grid);
		Controller controller = new Controller(p1, bot, grid);
		System.out.print(grid);
		controller.nextTurn();
		System.out.println("------");
		System.out.println(grid);
		controller.nextTurn();
		System.out.println("-----");
		System.out.println(grid);
		controller.nextTurn();
		System.out.println("--------");
		System.out.println(grid);
		controller.nextTurn();
		System.out.println("--------");
		System.out.println(grid);
							
		
		


	}
	
}



