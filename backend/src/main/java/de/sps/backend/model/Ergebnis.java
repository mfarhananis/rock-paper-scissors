package de.sps.backend.model;

public enum Ergebnis {
	
	GEWONNEN(1),
	VERLOREN(2),
	UNENTSCHIEDEN(3);
	
	private int value;
	
	private Ergebnis(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
