package it.unicam.cs.pa.dotsandboxes;



import org.junit.Test;

public class testDot {
	
	@Test(expected=IllegalArgumentException.class)
	public void IllegalCreateNewDot() {
		
		new Dot(-1,6);
		
		
	}

}