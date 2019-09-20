package it.unicam.cs.pa.dotsandboxes.structure;
/**
* @author Donoval Candolfi - Mattia Incoronato
*
*/
import org.junit.Test;

import it.unicam.cs.pa.dotsandboxes.structure.Dot;
import it.unicam.cs.pa.dotsandboxes.structure.Line;

public class testLine {

	@Test(expected = IllegalArgumentException.class)
	public void IllegalLineCreation() {

		Dot d1 = new Dot(1, 1);
		new Line(d1, d1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalLineCheckDistance() {

		Dot d1 = new Dot(1, 1);
		Dot d2 = new Dot(1, 2);
		new Line(d1, d2);

	}

}
