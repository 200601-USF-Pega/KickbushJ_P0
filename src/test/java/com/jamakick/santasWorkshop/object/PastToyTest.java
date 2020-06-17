package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PastToyTest {
	
	PastToy toy;
	
	@Before
	public void createDummyData() {
		
		toy = new PastToy(1, "Firetruck", "Red",
				(float) 3.5, 2, 12, 2012, true);
	}
	
	
	@Test
	public void pastToyShouldExist() {
		
		assertNotNull(toy);
	}
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
		
	}

}
