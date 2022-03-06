package de.twyco.shared.spielfeld;

public class Schiff {

	private Koordinate[] koordinate;
	private int laenge;
	private int leben;
	private boolean istGesetzt;
	private String name;

	public Schiff() {
		this.istGesetzt = false;
	}

	public Schiff(String name, Koordinate[] koordinate) {
		this.name = name;
		this.istGesetzt = false;
		this.koordinate = koordinate;
		this.laenge = koordinate.length;
		this.leben = koordinate.length;
	}

	public Schiff(String name, int laenge) {
		this.name = name;
		this.istGesetzt = false;
		this.laenge = laenge;
		this.leben = laenge;
	}

	public Koordinate[] getKoordinate() {
		return this.koordinate;
	}

	public void setKoordinate(Koordinate[] koordinate) {
		this.istGesetzt = true;
		this.koordinate = koordinate;
	}
	
	public boolean istGesetzt() {
		return this.istGesetzt;
	}
	
	public int getLaenge() {
		return this.laenge;
	}
	
	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}
	
	public int getLeben() {
		return this.leben;
	}
	
	public void setLeben(int leben) {
		this.leben = leben;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
