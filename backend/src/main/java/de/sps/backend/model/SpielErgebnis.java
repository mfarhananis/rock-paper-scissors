package de.sps.backend.model;

public class SpielErgebnis {
	
	private Zeichen rechnerWahl;
	private Ergebnis ergebnis;
	
	public SpielErgebnis() {
		
	}
	
	public Zeichen getRechnerWahl() {
		return rechnerWahl;
	}
	public void setRechnerWahl(Zeichen rechnerWahl) {
		this.rechnerWahl = rechnerWahl;
	}
	public Ergebnis getErgebnis() {
		return ergebnis;
	}
	public void setErgebnis(Ergebnis ergebnis) {
		this.ergebnis = ergebnis;
	}

}
