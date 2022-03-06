package de.twyco.server.main;

import de.twyco.server.SchiffeversenkenServer;
import de.twyco.shared.spielfeld.Schiff;

@SuppressWarnings("unused")
public class Spiel extends Thread{

	private SchiffeversenkenServer server;
	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler spieleramzug;
	
	public Spiel(SchiffeversenkenServer server,Spieler spieler1, Spieler spieler2) {
		this.server = server;
		this.setSpieler1(spieler1);
		this.setSpieler2(spieler2);
		this.setSpieleramzug(spieler1);
	}
	
	@Override
	public void run() {
		super.run();
		spielStart();
	}
	
	private void spielStart() {
		int sizeX = ServerClient.getSize()[0];
		int sizey = ServerClient.getSize()[1]; //TODO AN CLIENT SENDEN
		server.send(spieler1, "Spiel_Start");
		server.send(spieler2, "Spiel_Start");
		schiffeSetzen(spieler1);
		schiffeSetzen(spieler2);
		spieleramzug = spieler1;
	}
	
	private void schiffeSetzen(Spieler spieler) {
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				String ip = spieler.getIp();
//				int port = spieler.getPort();
//				for (Schiff schiff : spieler.getSpielfeld().getschiffVorgabe().keySet()) {
//		            Integer count = spieler.getSpielfeld().getschiffVorgabe().get(schiff);
//		            server.send(ip, port, "Du musst " + count + " " + schiff.getName() + " setzen!");
//		        }
//				
//				while(spieler.getSpielfeld().getSchiffe().size() != spieler.getSpielfeld().getSchiffanzahl()) {
//					server.send(ip, port, "Du musst noch " + (spieler.getSpielfeld().getSchiffanzahl() - spieler.getSpielfeld().getSchiffe().size()) + " Schiffe setzen!");
//					try {
//						Thread.sleep(10000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
	}

	public Spieler getSpieler1() {
		return spieler1;
	}

	public void setSpieler1(Spieler spieler1) {
		this.spieler1 = spieler1;
	}

	public Spieler getSpieler2() {
		return spieler2;
	}

	public void setSpieler2(Spieler spieler2) {
		this.spieler2 = spieler2;
	}

	public Spieler getSpieleramzug() {
		return spieleramzug;
	}

	public void setSpieleramzug(Spieler spieleramzug) {
		this.spieleramzug = spieleramzug;
	}
}
