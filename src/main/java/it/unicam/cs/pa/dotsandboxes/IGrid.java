package it.unicam.cs.pa.dotsandboxes;

public interface IGrid {

	public void insertLine(Line line) throws IllegalArgumentException;
	
	public boolean isFinished();
	
	public int getSize();
	
}
