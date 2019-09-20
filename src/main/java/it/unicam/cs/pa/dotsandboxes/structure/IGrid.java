package it.unicam.cs.pa.dotsandboxes.structure;

/**
 * @param si occupa di definire i metodi per cui deve essere creata la Grid ,
 *           l'interfaccia passa i parametri alla classe Grid
 * @author Donoval Candolfi - Mattia Incoronato
 */
public interface IGrid {

	public void insertLine(Line line) throws IllegalArgumentException;

	public boolean isFinished();

	public int getSize();

	public void addBoxCreatedListener(BoxCreatedListener listener);

	public Dot[][] getGrid();
}
