package de.twyco.nils;

public class Kommando {

    private String kommando;
    //Objekte verschicken nicht selber parsen
    private Object data;

    public Kommando(){}

    public Kommando(String pKommando, Object pData){
        kommando = pKommando;
        data = pData;
    }

    public String getKommando(){ return kommando; }

    public void setKommando(String pKommando) { kommando = pKommando; }

    public Object getData(){ return data; }

    public void setData(Object pData) { data = pData; }

}
