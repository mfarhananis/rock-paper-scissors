package de.sps.backend.ctrl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.sps.backend.model.Ergebnis;
import de.sps.backend.model.SpielErgebnis;
import de.sps.backend.model.SpielResponse;
import de.sps.backend.model.Zeichen;
import de.sps.backend.services.SpielService;

@RunWith(SpringRunner.class)
@WebMvcTest(SpsController.class)
public class SpsControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SpielService spielService;
	
	@Test
	public void testGetRequestwithSpielerZeichen() throws Exception {
		
		SpielErgebnis ergebnis = new SpielErgebnis();
		ergebnis.setErgebnis(Ergebnis.GEWONNEN);
		ergebnis.setRechnerWahl(Zeichen.SCHERE);
		when(spielService.spielen(any(Zeichen.class))).thenReturn(ergebnis);
		
		mvc.perform(get("/sps/ergebnis/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.rechnerWahl", is(Zeichen.SCHERE.getValue())))
		.andExpect(jsonPath("$.ergebnis", is(Ergebnis.GEWONNEN.getValue())));
	}
	
	@Test
	public void testGetRequestMitIllegalargument() throws Exception {
		
		SpielErgebnis ergebnis = new SpielErgebnis();
		when(spielService.spielen(any(Zeichen.class))).thenReturn(ergebnis);
		
		mvc.perform(get("/sps/ergebnis/4").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andExpect(status().isNotAcceptable())
		.andExpect(status().reason(containsString("Nur diese werte sind erlaubt: 1: Stein, 2: Papier, 3: Schere")));
	}

}
