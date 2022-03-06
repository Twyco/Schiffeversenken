package de.twyco.client.main;

public class Spiel {

	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler spieleramzug;
	
	public Spiel(){
		//while(true){
			//SERVER sendet alle schiffe an Client(ohen koordinate)
			//CLient antwortet mit Schiff Objekt mit koordinate
			 
		//}
		//while(true){
			spieleramzug = spieler1;
			//SERVER sendet an spieler schussanfrage
			//CLIENT antwortet mit Objekt Koordinate
			//SPIEL überprüft auf treffer (evt nochmaldran)
			spieleramzug = spieler2;
			//SERVER sendet an spieler schussanfrage
			//CLIENT antwortet mit Objekt Koordinate
		//}
	}
	
}
