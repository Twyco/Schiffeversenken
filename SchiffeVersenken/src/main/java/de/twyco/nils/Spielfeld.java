package de.twyco.nils;

public class Spielfeld {

    public static final int WASSER = 0;
    public static final int SCHIFF = 1;
    public static final int KEIN_TREFFER = 2;
    public static final int TREFFER = 3;

    private int[][] feld;

    public Spielfeld(){
        feld = new int[10][10];
    }

    public void set(int x, int y, int status){
        feld[x][y] = status;   
    }

    public int get(int x, int y){
        return feld[x][y];   
    }

    public int[][] getFeld(){ return feld; }

    public void setFeld(int[][] pFeld){ feld = pFeld; }
}
