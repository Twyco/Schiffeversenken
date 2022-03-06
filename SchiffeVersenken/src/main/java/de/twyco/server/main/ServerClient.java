package de.twyco.server.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.twyco.server.SchiffeversenkenServer;
import de.twyco.shared.spielfeld.Schiff;
import de.twyco.shared.spielfeld.Spielfeld;

public class ServerClient {

	private static SchiffeversenkenServer server;
	private static List<Spieler> queue;
	private static HashMap<Schiff, Integer> schiffe;
	private static int sizeX = 10;
	private static int sizeY = 10;
	
	public void start() throws InterruptedException {
		server = new SchiffeversenkenServer(4478);
		queue = new ArrayList<>();
		schiffe = new HashMap<>();
		Schiff schlachtschiff = new Schiff("Schlachtschiff", 5);
		Schiff kreuzer = new Schiff("Kreuzer", 4);
		Schiff zerstoerer = new Schiff("Zerstoerer", 3);
		Schiff uboot = new Schiff("U-boot", 2);
		
		
		schiffe.put(schlachtschiff, 1);
		schiffe.put(kreuzer, 2);
		schiffe.put(zerstoerer, 3);
		schiffe.put(uboot, 4);
		while(true) {
			if(queue.size() >= 2) {
				System.out.println("\nStarte Spiel");
				Spiel spiel = new Spiel(server, queue.get(0), queue.get(1));
				spiel.start();
				queue.remove(0);
				queue.remove(0);
				System.out.println("Queuesize: " + queue.size());
				System.out.println(spiel.getSpieler1().getIp() + "  " + spiel.getSpieler1().getPort());
				server.send(spiel.getSpieler1().getIp(), spiel.getSpieler1().getPort(), "WartenAufSpieler_false");
				server.send(spiel.getSpieler2().getIp(), spiel.getSpieler2().getPort(), "WartenAufSpieler_false");
			}
			Thread.sleep(1000);
		}
	}
	
	public static void joinQueue(String name, String ip, int port) {
		Spieler spieler;
		Spielfeld spielfeld = new Spielfeld(sizeX, sizeY, schiffe);
		spieler = new Spieler(name, ip, port, spielfeld);
		queue.add(spieler);
		System.out.println(name + " ist dem Spiel beigetreten");
		System.out.println("Queuesize: " + queue.size());
		server.send(ip, port, "WartenAufSpieler_true");
	}
	
	public static void leaveQueue(String ip, int port) {
		for(Spieler spieler : queue) {
			if(spieler.getIp().equals(ip) && spieler.getPort() == port) {
				queue.remove(spieler);
				System .out.println(spieler.getName() + " hat das Spiel verlassen");
				System.out.println("Queuesize: " + queue.size());
				break;
			}
		}
	}
	
	public static int[] getSize() {
		return new int[] {sizeX, sizeY};
		
	}
}
