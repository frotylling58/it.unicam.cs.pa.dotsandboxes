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
		
		
		Bot bot = new DumbStrategy();
		RealPlayer p1 = new RealPlayer();
		Controller controller = new Controller(p1, bot, Utils::createNewGrid, 4);
	//	System.out.print(grid);
		controller.nextTurn();
		System.out.println("------");
	//	System.out.println(grid);
		controller.nextTurn();
		System.out.println("-----");
	//	System.out.println(grid);
		controller.nextTurn();
		System.out.println("--------");
	//	System.out.println(grid);
		controller.nextTurn();
		System.out.println("--------");
	//	System.out.println(grid);

	}
	
}



