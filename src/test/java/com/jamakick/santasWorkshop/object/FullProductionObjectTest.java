package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FullProductionObjectTest {

	FullProductionObject obj;
	
	
	@Before
	public void createDummyData() {
		
		obj = new FullProductionObject(1, "Firetruck", "Red",
				(float) 3.5, "Alex Wright", true, "Mr Elf",
				"Toymaker", 2, 178);
	}
	
	@Test
	public void objShouldExist() {
		
		assertNotNull(obj);
	}
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
	}
	
}
