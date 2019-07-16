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
	private Grid grid;
	private PlayerWithPoints player1, player2;
	private PlayerWithPoints currentTurn;
	
	public Controller(Player player1, Player player2, Grid grid) {
		this.grid = grid;
		this.player1 = new PlayerWithPoints(player1);
		this.player2 = new PlayerWithPoints(player2);
		this.currentTurn = this.player1;
		this.grid.addBoxCreatedListener(new BoxCreatedListener() {
			
			@Override
			public void onBoxCreated() {
			   currentTurn.addPoint();
			}
		} );
		
	}

	public Grid getGrid() {
		return grid;
	}

	public PlayerWithPoints getPlayer1() {
		return player1;
	}

	public PlayerWithPoints getPlayer2() {
		return player2;
	}
	
	public boolean finished() {
		for(int row = 0; row<grid.getSize(); row++) {
			for(int col = 0; col<grid.getSize(); col++) {
				if(grid.getGrid()[row][col] == null)
					return false;
			}
			
		}
		return true;
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
			Line line = currentTurn.getPlayer().drawLine();
			grid.insertLine(line);
		} catch (IllegalArgumentException e) {
			redo = true;
			System.out.println("Incorrect position, insert again");
		}
		} while(redo);
		if(currentTurn == player1)
			currentTurn = player2;
		else
			currentTurn = player1;
	}
}