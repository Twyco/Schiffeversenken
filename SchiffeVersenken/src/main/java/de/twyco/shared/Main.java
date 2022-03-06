package de.twyco.shared;

import de.twyco.client.main.SpielerClient;
import de.twyco.server.main.ServerClient;

public class Main {

	private static ServerClient serverclient;
	private static SpielerClient spielerclient;
	
	public static void main(String[] args) {
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("server")) {
				System.out.println("Starte Server Client");
				serverclient = new ServerClient();
				try {
					serverclient.start();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("Starte Player Client");
			spielerclient.start();
		}
	}
}
