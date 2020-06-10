package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ChildTest {
	
	private Child child1;
	private Child child2;
	private Child child3;
	private Child child4;
	
	private String child1ToString;
	private String child2ToString;
	private String child3ToString;
	private String child4ToString;
			
			
			
	@Before
	public void createDummyData() {
		child1 = new Child("Jake Kickbush", true);
		child2 = new Child("Jake Kickbush", 23, true);
		child3 = new Child(0, "Jake Kickbush", true);
		child4 = new Child(0, "Jake Kickbush", 23, true);
		
		child1ToString = "Child [childID=0, childName=Jake Kickbush, childAge=0, naughty=true]";
		child2ToString = "Child [childID=0, childName=Jake Kickbush, childAge=23, naughty=true]";
		child3ToString = "Child [childID=0, childName=Jake Kickbush, childAge=0, naughty=true]";
		child4ToString = "Child [childID=0, childName=Jake Kickbush, childAge=23, naughty=true]";

	}
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
		
	}
	
	
	@Test
	public void childShouldExist() {
		
		
		assertNotNull(child1);
	}
	
	@Test
	public void child1ConstructorCreatesProperToString() {
		
		assertEquals(child1.toString(), child1ToString);
	}
	
	@Test
	public void child2ConstructorCreatesProperToString() {
		
		assertEquals(child2.toString(), child2ToString);
	}
	
	@Test
	public void child3ConstructorCreatesProperToString() {
		
		assertEquals(child3.toString(), child3ToString);
	}
	
	@Test
	public void child4ConstructorCreatesProperToString() {
		
		assertEquals(child4.toString(), child4ToString);
	}

}
