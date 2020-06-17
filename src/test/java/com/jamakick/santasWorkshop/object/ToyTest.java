package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ToyTest {
	
	Toy toy;
	
	@Before
	public void createDummyData() {
		
		toy = new Toy(1, "Firetruck", "Red",
				(float) 3.5, 2, 12);
	}
	
	
	@Test
	public void toyShouldExist() {
		
		assertNotNull(toy);
	}
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
		
	}

}
