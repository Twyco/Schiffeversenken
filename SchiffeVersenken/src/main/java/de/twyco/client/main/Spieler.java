package de.twyco.client.main;

import de.twyco.client.SchiffeversenkenClient;
import de.twyco.shared.spielfeld.Spielfeld;

public class Spieler {

	private SchiffeversenkenClient client;
	private Spielfeld spielfeld;	
	
	public Spieler(SchiffeversenkenClient client, Spielfeld spielfeld) {
		this.client = client;
		this.spielfeld = spielfeld;
	}
	
}
