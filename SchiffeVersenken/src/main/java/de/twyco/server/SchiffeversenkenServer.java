package de.twyco.server;

import de.twyco.server.main.ServerClient;
import de.twyco.server.main.Spieler;
import de.twyco.shared.Server;

public class SchiffeversenkenServer extends Server {
   
    public SchiffeversenkenServer(int port){
        super(port);   
    }
    
    public void send(Spieler spieler, String Message) {
    	this.send(spieler.getIp(), spieler.getPort(), Message);
    }
    
	public void processNewConnection(String pClientIP, int pClientPort){
//		Main.joinQueue(pClientIP + ":" + pClientPort, pClientIP, pClientPort);
		
    }
    
    public void processClosedConnection(String pClientIP, int pClientPort){
		ServerClient.leaveQueue(pClientIP, pClientPort);
    }
    
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
//        System.out.printf("%s sendet %s.%n",pClientIP,pMessage);
//        send(pClientIP, pClientPort, pMessage);
//        System.out.println("Send: " + pMessage + " to " + pClientIP + ":" + pClientPort);
    	String cmd = pMessage.split("_")[0];
    	String value = pMessage.split("_")[1];
    	if(cmd.equalsIgnoreCase("JoinQueue")) {
    		ServerClient.joinQueue(value, pClientIP, pClientPort);
    	}
    }
}
