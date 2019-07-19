

/**
 * 
 */
package it.unicam.cs.pa.dotsandboxes;

import java.util.InputMismatchException;
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
		System.out.println("WELCOME TO DOTS AND BOXES ! "
				+ "\n"
				+ "\nRegole : inserire la grandezza della griglia definendo solo un numero (es. 6), "
				+ "\nmi restituisce una griglia 6x6, "
				+ "\npoi inserire le coordinate nel seguente modo : (riga,colonna) (riga,colonna)");
	
		System.out.println("Insert grid dimension :");
		
		Scanner input = new Scanner(System.in);
		
	/*	
		if(input.hasNextInt()) {
			try {
			input = new Scanner(System.in);
			}
			catch (InputMismatchException e) {
				throw new InputMismatchException("Voglio un intero !");
			}
		}
		else System.out.println("Voglio un intero !");
		
	*/	
		Controller controller = ControllerManager.createNewInteractiveController(input.nextInt());
		
		//input.close();
		
		System.out.print(controller.getGrid());
		do {
			controller.nextTurn();
			System.out.println("########");
			System.out.print(controller.getGrid());
			
		} while (controller.finished() == false);
			
		controller.getWinner();
		System.out.println("Bye bye by Mattia and Donoval");
	}
	
}
