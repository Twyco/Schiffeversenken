package de.twyco.nils;

public class Spieler
{
    String clientIP;
    int clientPort;
    String message; 
    
    public Spieler(String pClientIP, int pClientPort, String pMessage){
        clientIP = pClientIP;
        clientPort = pClientPort;
        message = pMessage;
    }
    
    public String getClientIP(){
        return clientIP;
    }
    
    public int getClientPort(){
        return clientPort;
    }
    
    public String getMessage(){
        return message;
    }
}
