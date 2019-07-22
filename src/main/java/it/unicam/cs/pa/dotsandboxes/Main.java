package it.unicam.cs.pa.dotsandboxes;

import java.util.Scanner;

import it.unicam.cs.pa.dotsandboxes.manager.Controller;
import it.unicam.cs.pa.dotsandboxes.manager.ControllerManager;

/**
 * @param
 *
 */
public class Main {
	static Controller controller;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("WELCOME TO DOTS AND BOXES ! " + "\n" + "\nRegole : Specificare il nome del giocatore"
				+ "\n'interactive' se si vuole giocare verso il bot"
				+ "\ned inserire la grandezza della griglia definendo solo un numero (es. 6), "
				+ "\nmi restituisce una griglia 6x6, "
				+ "\nsuccessivamente inserire le coordinate per tracciare una linea "
				+ "\nnel seguente modo : x=(riga,colonna) y=(riga,colonna)" + "\n");

		System.out.println("Inserisci il giocatore :");

		String line = input.nextLine();

		if (line.equals("interactive"))
			controller = ControllerManager.createNewInteractiveController(scanInt());
		else
			return;

		System.out.print(controller.getGrid());
		do {
			controller.nextTurn();
			System.out.println("########");
			System.out.print(controller.getGrid());

		} while (controller.finished() == false);

		controller.getWinner();
		System.out.println("Bye bye by Mattia and Donoval");
	}

	private static int scanInt() {
		System.out.println("Insert grid dimension :");

		input = new Scanner(System.in);

		if (!input.hasNextInt()) {
			System.out.println("I want an integer type !");
			return scanInt();
		}
		int i = input.nextInt();
		// input.close();
		return i;

	}

}
