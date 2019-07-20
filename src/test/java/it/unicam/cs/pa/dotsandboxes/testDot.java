package it.unicam.cs.pa.dotsandboxes;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDot {
	
	@Test(expected=IllegalArgumentException.class)
	public void IllegalCreateNewDot() {
		
		new Dot(-1,6);
		
		
	}

}