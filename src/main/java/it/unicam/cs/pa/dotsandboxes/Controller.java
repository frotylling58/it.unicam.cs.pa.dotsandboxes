package it.unicam.cs.pa.dotsandboxes;

public class Controller {
/*
 * Metodi per il controller (arbitro)
 * 
 * 2. Gestire i turni OK
 * 3. Controllare se la mossa è valida OK
 * 4. Aggiornare eventualmente il punteggio TODO
 * Capire quando un box viene creato TODO
 * Gestire la visualizzazione su console TODO
 */
	private IGrid grid;
	private PlayerWithPoints player1, player2;
	private Player currentTurn;
	
	public Controller(Player player1, Player player2, GridFactory grid, int size) {
		this.grid = grid.createNewInstance(size);
		this.player1 = new PlayerWithPoints(player1);
		this.player2 = new PlayerWithPoints(player2);
		this.currentTurn = player1;
		
	}

	public PlayerWithPoints getPlayer1() {
		return player1;
	}

	public PlayerWithPoints getPlayer2() {
		return player2;
	}
	
	public boolean finished() {
		return grid.isFinished();
	}
	
	public Player getWinner() {
		if(!finished())
			return null;
		return null;
	}
	
	public void nextTurn() {
		boolean redo = false;
		do {
		try {
			redo = false;
			Line line = currentTurn.drawLine();
			grid.insertLine(line);
		} catch (IllegalArgumentException e) {
			redo = true;
			System.out.println("Incorrect position, insert again");
		}
		} while(redo);
		if(currentTurn == player1.getPlayer())
			currentTurn = player2.getPlayer();
		else
			currentTurn = player1.getPlayer();
	}
}