package de.sps.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sps.backend.model.Ergebnis;
import de.sps.backend.model.SpielErgebnis;
import de.sps.backend.model.Zeichen;

@Service
public class SpsSpielService implements SpielService {
	
	@Autowired
	private UtilService util; 

	@Override
	public SpielErgebnis spielen(Zeichen spieler) {
		
		SpielErgebnis ergebnis = new SpielErgebnis();
		Zeichen rechner = util.generateZeichen();
		ergebnis.setRechnerWahl(rechner);
		
		if (spieler.equals(rechner)) {
			ergebnis.setErgebnis(Ergebnis.UNENTSCHIEDEN);
		} else {
		
			if ((spieler.equals(Zeichen.STEIN) && rechner.equals(Zeichen.SCHERE))
					|| (spieler.equals(Zeichen.SCHERE) && rechner.equals(Zeichen.PAPIER))
					|| (spieler.equals(Zeichen.PAPIER) && rechner.equals(Zeichen.STEIN))) {
				ergebnis.setErgebnis(Ergebnis.GEWONNEN);
			} else {
				ergebnis.setErgebnis(Ergebnis.VERLOREN);
			}
		}
		
		return ergebnis;
	}

}
