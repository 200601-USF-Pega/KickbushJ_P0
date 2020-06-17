package com.jamakick.santasWorkshop.object;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LoginInfoTest {
	
	LoginInfo info;
	
	@Before
	public void createDummyData() {
		
		info = new LoginInfo(1, "password", false);
	}
	
	@Test
	public void loginInfoShouldExist() {
		
		assertNotNull(info);
	}
	
	@Test
	public void shouldAnswerTrue() {
		
		assertTrue(true);
	}

}
