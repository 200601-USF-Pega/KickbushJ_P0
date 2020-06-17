package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ElfTest {
	
	Elf elf;
	
	@Before
	public void createDummyData() {
	
		elf = new Elf(1, "Mr Elf", 22, "Toymaker",
				2, 105);
	}
	
	@Test
	public void elfShouldExist() {
		
		assertNotNull(elf);
		
	}
	
	
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
		
	}

}
