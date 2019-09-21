package de.sps.backend.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.sps.backend.model.Zeichen;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilServiceTests {
	
	@Autowired
	private UtilService util;
	
	@Test
	public void testRangeGenerateZeichen() {
		Zeichen rechner = util.generateZeichen();
		assertTrue("Zeichen values muss zwischen 1 und 3 sein", rechner.getValue() >= 1 && rechner.getValue() <= 3);
	}
	
	@Test
	public void testGeneratedZeichen() {
		Zeichen rechner = util.generateZeichen();
		assertTrue("Zeichen kann nur Stein, Papier oder Schere sein", 
				rechner.equals(Zeichen.STEIN) || rechner.equals(Zeichen.PAPIER) || rechner.equals(Zeichen.SCHERE));
	}

}
