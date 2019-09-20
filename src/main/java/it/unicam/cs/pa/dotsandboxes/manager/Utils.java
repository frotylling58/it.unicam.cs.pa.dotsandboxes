package it.unicam.cs.pa.dotsandboxes.manager;
/**
* @author Donoval Candolfi - Mattia Incoronato
*
*/
import it.unicam.cs.pa.dotsandboxes.structure.Grid;
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;

/**
 * @param
 *
 */
public final class Utils {

	protected static IGrid createNewGrid(int size) {
		return new Grid(size);
	}
}
