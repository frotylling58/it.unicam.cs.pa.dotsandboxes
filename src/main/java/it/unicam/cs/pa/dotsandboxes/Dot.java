package it.unicam.cs.pa.dotsandboxes;



///la classe dot ha la responsabilità di definire i punti che verranno utlizzati sulla griglia

public class Dot {

	private final int x;
	private final int y;
	
	public Dot(int x , int y) throws IllegalArgumentException {
		if(x<0 || y<0) throw new IllegalArgumentException("Tutte e due le coordinate devono essere positive");
		this.x = x;
		this.y = y;
	}
	
		
	// Getters and Setters
	public int getX() {
		return x;
	}
	
	
	public int getY() {
		return y;
	}
	
	// Stampa le coordinate dei punti
	@Override
	public String toString() {
		return String.format("(%d,%d)",x,y);
		
	}
	// Controlla se l'elemento Ã¨ un istanza di Dot
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Dot)) {
			return false;
		}
		Dot dot = (Dot)obj;
		return this.x == dot.x && this.y == dot.y;
		
	}
	public int hashCode()
	{
		return 0;
		
	}
	
	public static double distance(Dot d1, Dot d2)
	{
		return Math.sqrt(Math.pow(d1.getX()-d2.getX(),2)+ Math.pow(d1.getY()-d2.getY(),2));
	}
}
