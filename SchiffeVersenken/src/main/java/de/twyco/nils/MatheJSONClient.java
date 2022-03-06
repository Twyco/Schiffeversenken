package de.twyco.nils;
import java.io.*;
//import javax.json.*;
import com.fasterxml.jackson.databind.*;

public class MatheJSONClient extends Client {
    
    private ObjectMapper objectMapper; 
    
    public MatheJSONClient(String serverIp, int serverPort){
        super(serverIp,serverPort);
        objectMapper = new ObjectMapper();
    }
    
    public void processMessage(String pMessage){
        try {
            Kommando k = objectMapper.readValue(pMessage, Kommando.class);
            System.out.println(k);
        }catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }
    //hier müssen noch regeln etc. abgefragt werden
    public void spielfeld(Spielfeld s){ 
        try {
            Kommando k = new Kommando("Spielfeld",s);
            String json = objectMapper.writeValueAsString(k);
            send(json);
        }catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }
    
    public void gegnerfeld(Spielfeld g){
        try {
            Kommando k = new Kommando("Spielfeld",g);
            String json = objectMapper.writeValueAsString(k);
            send(json);
        }catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }
}
