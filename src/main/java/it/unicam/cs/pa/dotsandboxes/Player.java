package it.unicam.cs.pa.dotsandboxes;

public abstract class Player {
	protected int points = 0;
	public abstract void drawLine(Line line); 

	public int getPoints() {
		return this.points;
	}
	public void addPoint() {
		this.points++;
	}
}
