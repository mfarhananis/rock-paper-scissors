package de.sps.backend.services;

import org.springframework.stereotype.Service;

import de.sps.backend.model.Zeichen;

@Service
public class UtilService {
	
	public Zeichen generateZeichen() {
		return Zeichen.fromValue(((int)(3.0 * Math.random())) + 1);
	}

}
