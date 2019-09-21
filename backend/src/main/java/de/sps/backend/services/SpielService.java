package de.sps.backend.services;

import de.sps.backend.model.SpielErgebnis;
import de.sps.backend.model.Zeichen;

public interface SpielService {
	public SpielErgebnis spielen(Zeichen spieler);
}
