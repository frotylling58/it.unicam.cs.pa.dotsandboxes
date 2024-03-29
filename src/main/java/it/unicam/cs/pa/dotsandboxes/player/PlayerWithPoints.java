package it.unicam.cs.pa.dotsandboxes.player;

/**
 * @param Oggetto per tenere traccia dei punti dei giocatori
 * @author Donoval Candolfi - Mattia Incoronato
 */
public class PlayerWithPoints {

	private int points = 0;
	private Player player = null;

	public PlayerWithPoints(Player p) {
		this.player = p;
	}

	public int getPoints() {
		return points;
	}

	public void addPoint() {
		this.points++;
	}

	public Player getPlayer() {
		return player;
	}
}
