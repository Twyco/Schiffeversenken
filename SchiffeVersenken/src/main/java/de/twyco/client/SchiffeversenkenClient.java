package de.twyco.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import de.twyco.client.gui.spielfeld.SpielfeldGUI;
import de.twyco.client.gui.warten.WartenAufSpielerDialog;
import de.twyco.shared.Client;

public class SchiffeversenkenClient extends Client{

	private boolean debug = true;
	private WartenAufSpielerDialog wartendialog;
	
	public SchiffeversenkenClient(String pIPAdresse, int pPortNr) {
		super(pIPAdresse, pPortNr);
		wartendialog = new WartenAufSpielerDialog();
		wartendialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void processMessage(String pMessage) {
		if(debug) {
			System.out.println(pMessage);
		}

		String cmd = null;
		String value = null;
		try {
	    	cmd = pMessage.split("_")[0];
	    	value = pMessage.split("_")[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cmd.equalsIgnoreCase("WartenAufSpieler")) {
			boolean warten = Boolean.parseBoolean(value);
			wartendialog.setVisible(warten);
		}else if(cmd.equalsIgnoreCase("Spiel")) {
			if(value.equalsIgnoreCase("Start")) {
				SpielfeldGUI spielfeldGUI = new SpielfeldGUI(10, 10); //TODO VOM SERVER BEKOMMEN
				spielfeldGUI.setVisible(true);
			}
		}
	}
	
	

}
