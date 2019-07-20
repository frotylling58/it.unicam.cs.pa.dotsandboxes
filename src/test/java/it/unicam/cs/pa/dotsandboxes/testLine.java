package it.unicam.cs.pa.dotsandboxes;


import org.junit.Test;

public class testLine {
	
	@Test(expected=IllegalArgumentException.class)
	public void IllegalLineCreation() {
		
	Dot d1 = new Dot(1,1);
	
		new Line(d1, d1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void IllegalLineCheckDistance() {
		
	Dot d1 = new Dot(1,1);
	Dot d2 = new Dot(1,2);
		new Line(d1, d2);
		
	}

}