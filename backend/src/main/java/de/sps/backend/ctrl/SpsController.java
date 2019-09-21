package de.sps.backend.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.sps.backend.model.SpielErgebnis;
import de.sps.backend.model.SpielResponse;
import de.sps.backend.model.Zeichen;
import de.sps.backend.services.SpielService;

@RestController
@RequestMapping("/sps")
public class SpsController {
	
	@Autowired
	private SpielService spielService;
	
	@GetMapping(value="/ergebnis/{spielerZeichen}", produces=MediaType.APPLICATION_JSON_VALUE)
	public SpielResponse spielErgebnis(@PathVariable int spielerZeichen) {
		try {
			SpielResponse response = new SpielResponse();
			SpielErgebnis ergebnis = spielService.spielen(Zeichen.fromValue(spielerZeichen));
			
			response.setRechnerWahl(ergebnis.getRechnerWahl().getValue());
			response.setErgebnis(ergebnis.getErgebnis().getValue());
			return response;
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, 
					"Nur diese werte sind erlaubt: 1: Stein, 2: Papier, 3: Schere");
		}
	}

}
