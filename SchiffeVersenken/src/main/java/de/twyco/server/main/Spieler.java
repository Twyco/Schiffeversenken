package de.twyco.server.main;

import de.twyco.shared.spielfeld.Spielfeld;

public class Spieler {

	private String name;
	private String ip;
	private int port;
	private Spielfeld spielfeld;
	
	public Spieler(String name, String ip, int port, Spielfeld spielfeld) {
		this.setName(name);
		this.ip = ip;
		this.port = port;
		this.spielfeld = spielfeld;
	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
