package com.fgonzalesv;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
		assertFalse(CryptoManager.stringInBounds("TEST SHOULD FAIL BECAUSE ~ IS OUTSIDE THE RANGE"));
		assertFalse(CryptoManager.stringInBounds("This test should fail because of lowercase letters"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("WKLV#LV#DQRWKHU#WHVW",CryptoManager.encryptCaesar("THIS IS ANOTHER TEST", 3));
		assertEquals("RFGQ^RCQR^QFMSJB^QSAACCB", CryptoManager.encryptCaesar("THIS TEST SHOULD SUCCEED", 190));
		assertEquals("DAHHK\\SKNH@", CryptoManager.encryptCaesar("HELLO WORLD", 444));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptCaesar("WKLV#LV#DQRWKHU#WHVW", 3));
		//assertEquals("THIS TEST SHOULD SUCCEED", CryptoManager.decryptCaesar("RFGQ^RCQR^QFMSJB^QSAACCB", 190));
		//assertEquals("HELLO WORLD", CryptoManager.decryptCaesar("DAHHK\\SKNH@", 444));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.encryptBellaso("THIS IS ANOTHER TEST", "CMSC203"));
		assertEquals("PR%UKP6K_\\VF=4V", CryptoManager.encryptBellaso("MERRY CHRISTMAS", "CMSC203"));
		assertEquals("ZF&ZJX4US][EE2 ", CryptoManager.encryptBellaso("MERRY CHRISTMAS", "MATH181")); 
		                                                                                      
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptBellaso("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.decryptBellaso("PR%UKP6K_\\VF=4V", "CMSC203"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.decryptBellaso("ZF&ZJX4US][EE2 ", "MATH181")); 

	}

}
