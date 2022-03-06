package de.twyco.shared.spielfeld;

import java.util.HashMap;

public class Spielfeld {

	private Zustaende[][] spielfeld;
	private HashMap<Schiff, Integer> schiffe;

	public Spielfeld() {
	}
	
	public Spielfeld(int sizeX, int sizeY, HashMap<Schiff, Integer> schiffe) {
		this.spielfeld = new Zustaende[sizeX][sizeY];
		this.schiffe = schiffe;
		
	}

	public Spielfeld(int sizeX, int sizeY) {
		spielfeld = new Zustaende[sizeX][sizeY];
	}
}