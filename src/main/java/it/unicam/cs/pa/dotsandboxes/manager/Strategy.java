package it.unicam.cs.pa.dotsandboxes.manager;
/**
* @author Donoval Candolfi - Mattia Incoronato
*
*/
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;
import it.unicam.cs.pa.dotsandboxes.structure.Line;

/**
 * @param
 *
 */
public interface Strategy {
	Line suggestLine(IGrid grid);
}
