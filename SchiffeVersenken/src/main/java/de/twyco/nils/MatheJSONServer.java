package de.twyco.nils;
import java.io.*;
//import javax.json.*;
import com.fasterxml.jackson.databind.*;

public class MatheJSONServer extends Server {

    private ObjectMapper objectMapper;
    public Queue<Spieler> q;
    
    public MatheJSONServer(int port){
        super(port);
        objectMapper = new ObjectMapper();
        q = new Queue<Spieler>();
    }

    public void processNewConnection(String pClientIP, int pClientPort){
        System.out.printf("Verbindung mit %s hergestellt.%n",pClientIP);
    }

    public void processClosedConnection(String pClientIP, int pClientPort){
        System.out.printf("Verbindung mit %s beendet.%n",pClientIP);
    }
    
    public int queueLaenge(Queue<Spieler> pQ){
        int i = 0;
        Queue<Spieler> hilfsqueue = new Queue<Spieler>();;
        if(pQ.isEmpty()){
            return 0;
        }else{
            while(!pQ.isEmpty()){
                hilfsqueue.enqueue(pQ.front());
                pQ.dequeue();
                i++;
            }
            while(!hilfsqueue.isEmpty()){
                pQ.enqueue(hilfsqueue.front());
                hilfsqueue.dequeue();
            }
        }
        return i;
    }
    
    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        System.out.printf("Empfangen von %s: %s%n",pClientIP,pMessage);
        if(queueLaenge(q)<2){
            q.enqueue(new Spieler(pClientIP, pClientPort, pMessage));
        }
        if(queueLaenge(q)==2){
            Spieler Spieler1 = q.front();
            q.dequeue();
            Spieler Spieler2 = q.front();
            q.dequeue();
            q.enqueue(Spieler1);
            q.enqueue(Spieler2);
            //Fehlerbehandlung noch einbauen, aber es geht erstmal ums prinzip:
            //Spieler1 fängt an:

        }
        
        //Fragen vergleich zwischen den werten zweier felder...
        
        try {
            Kommando k = objectMapper.readValue(pMessage, Kommando.class);
            System.out.println(k);
            String json = objectMapper.writeValueAsString(k);
            System.out.printf("Sende an %s:      %s%n",pClientIP,json);
            send(pClientIP, pClientPort, json);
        }catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
            jpe.printStackTrace();
        }

    }
}
