package de.twyco.nils;
/**
 * Beschreiben Sie hier die Klasse Test.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Test {
    
    private static MatheJSONServer server;
    
    public static MatheJSONClient test(){
          if(server==null)
              server = new MatheJSONServer(2412);
          return new MatheJSONClient("127.0.0.1",2412);
    }
}
