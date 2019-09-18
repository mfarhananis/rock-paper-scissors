package de.sps.backend.ctrl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sps")
public class SpsController {
	
	@PostMapping("/ergebnis")
	public boolean spielErgebnis() {
		return true;
	}

}
