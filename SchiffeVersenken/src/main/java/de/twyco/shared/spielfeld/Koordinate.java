package de.twyco.shared.spielfeld;

public class Koordinate {
	
	private int x;
	private int y;

	public Koordinate() {
	}

	public Koordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	private void setY(int y) {
		this.y = y;
	}
}
