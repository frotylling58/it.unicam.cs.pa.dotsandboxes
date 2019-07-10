package it.unicam.cs.pa.dotsandboxes;

import java.util.Vector;


//prova
public class Bot implements Player {
	private int nomeGiocatore;
	private int bot = nomeGiocatore;
	
	
	public class infoGiocatore {
		public int playerId = Id;
		public int destination = Vector;
	}
	
	@Override
	public void makeMove(Id playerId, Vector destination) {
        
		
		//assertPlayersTurn(playerId);
      //  assertIsValidMove(playerId, destination);
        Griglia.makeMove(playerId, destination);
       // setNextPlayersTurn();
		
		
		
		
		//definire spostamenti usando Strategy

	}	
}

