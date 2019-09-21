package de.sps.backend.model;

public enum Zeichen {
	STEIN(1),
	PAPIER(2),
	SCHERE(3);
	
	private int value;
	
	private Zeichen(int value) {
		this.value = value;
	}
	
	public static Zeichen fromValue(int value) {
		for (Zeichen z: values()) {
			if (value == z.getValue()) {
				return z;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public int getValue() {
		return value;
	}
}
