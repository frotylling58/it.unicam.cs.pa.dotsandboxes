package it.unicam.cs.pa.dotsandboxes;
// Ogetto per tenere traccia dei punti dei giocatori
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
