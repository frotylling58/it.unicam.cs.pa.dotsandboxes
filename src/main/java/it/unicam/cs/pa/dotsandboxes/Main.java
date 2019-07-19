

/**
 * 
 */
package it.unicam.cs.pa.dotsandboxes;

import java.util.Scanner;

/**
 * @author Utente
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("insert grid dimension");
		
		Scanner in = new Scanner(System.in);

		Controller controller = ControllerManager.createNewInteractiveController(in.nextInt());
		
		//in.close();
		
		System.out.print(controller.getGrid());
		do {
			controller.nextTurn();
			System.out.println("------");
			System.out.print(controller.getGrid());
			
		} while (controller.finished() == false);
			
		controller.getWinner();
		System.out.println("Bye bye by Mattia and Donoval");
	}
	
}
