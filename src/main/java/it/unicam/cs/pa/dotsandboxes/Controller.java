package it.unicam.cs.pa.dotsandboxes;

public class Controller {
	
	private IGrid grid;
	private PlayerWithPoints player1, player2;
	private PlayerWithPoints currentTurn;
	
	public Controller(Player player1, Player player2, IGrid grid) {
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

	public IGrid getGrid() {
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
	
	public void getWinner() {
		if(finished() == true) {
			if(player1.getPoints() > player2.getPoints())
				System.out.println("Player 1 won the game");
			else
				System.out.println("Player 2 won the game");
		}
			
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