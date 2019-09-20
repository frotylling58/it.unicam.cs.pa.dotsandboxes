package it.unicam.cs.pa.dotsandboxes.structure;
/**
* @author Donoval Candolfi - Mattia Incoronato
*
*/
import org.junit.Test;

import it.unicam.cs.pa.dotsandboxes.structure.Dot;

public class testDot {

	@Test(expected = IllegalArgumentException.class)
	public void IllegalCreateNewDot() {

		new Dot(-1, 6);

	}
}
