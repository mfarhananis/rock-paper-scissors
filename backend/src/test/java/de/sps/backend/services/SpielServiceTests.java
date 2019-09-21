package de.sps.backend.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import de.sps.backend.model.Ergebnis;
import de.sps.backend.model.Zeichen;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpielServiceTests {
	
	@Autowired
	private SpielService spielService;
	
	@MockBean 
	private UtilService util;
	
	@Test
	public void spielBenutzerGewinntTest1() {
		when(util.generateZeichen()).thenReturn(Zeichen.PAPIER);
		assertEquals("Benutzer - Schere schlaegt Papier", spielService.spielen(Zeichen.SCHERE).getErgebnis(), Ergebnis.GEWONNEN);
	}
	
	@Test
	public void spielBenutzerGewinntTest2() {
		when(util.generateZeichen()).thenReturn(Zeichen.SCHERE);
		assertEquals("Benutzer - Stein schlaegt Schere", spielService.spielen(Zeichen.STEIN).getErgebnis(), Ergebnis.GEWONNEN);
	}
	
	@Test
	public void spielBenutzerGewinntTest3() {
		when(util.generateZeichen()).thenReturn(Zeichen.STEIN);
		assertEquals("Benutzer - Papier schlaegt Stein", spielService.spielen(Zeichen.PAPIER).getErgebnis(), Ergebnis.GEWONNEN);
	}
	
	@Test
	public void spielRechnerVerliertTest1() {
		when(util.generateZeichen()).thenReturn(Zeichen.SCHERE);
		assertEquals("Rechner - Schere schlaegt Papier", spielService.spielen(Zeichen.PAPIER).getErgebnis(), Ergebnis.VERLOREN);
	}
	
	@Test
	public void spielRechnerVerliertTest2() {
		when(util.generateZeichen()).thenReturn(Zeichen.STEIN);
		assertEquals("Rechner - Stein schlaegt Schere", spielService.spielen(Zeichen.SCHERE).getErgebnis(), Ergebnis.VERLOREN);
	}
	
	@Test
	public void spielRechnerVerliertTest3() {
		when(util.generateZeichen()).thenReturn(Zeichen.PAPIER);
		assertEquals("Rechner - Papier schlaegt Stein", spielService.spielen(Zeichen.STEIN).getErgebnis(), Ergebnis.VERLOREN);
	}
	
	@Test
	public void spielRechnerUnentschiedenTest() {
		when(util.generateZeichen()).thenReturn(Zeichen.STEIN);
		assertEquals("Rechner - Papier schlaegt Stein", spielService.spielen(Zeichen.STEIN).getErgebnis(), Ergebnis.UNENTSCHIEDEN);
	}

}
