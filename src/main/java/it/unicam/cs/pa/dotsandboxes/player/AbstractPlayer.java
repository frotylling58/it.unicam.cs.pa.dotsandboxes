package it.unicam.cs.pa.dotsandboxes.player;
/**
* @author Donoval Candolfi - Mattia Incoronato
*
*/
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;

/**
 * @param Questa classe ha lo scopo di definire il costruttore base per i player
 * @author Donoval Candolfi - Mattia Incoronato	
 */
public abstract class AbstractPlayer implements Player {
	protected IGrid grid = null;

	public AbstractPlayer(IGrid grid) {
		this.grid = grid;
	}
}
