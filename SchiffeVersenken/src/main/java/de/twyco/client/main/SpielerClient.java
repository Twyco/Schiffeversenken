package de.twyco.client.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import de.twyco.client.SchiffeversenkenClient;
import de.twyco.client.gui.listener.NamenEingebenListener;
import de.twyco.client.gui.nameneingeben.NamenEingebenDialog;
import de.twyco.client.gui.nameneingeben.NamenEingebenDialogData;
import de.twyco.client.gui.spielfeld.SpielfeldGUI;

public class SpielerClient {

	private static SchiffeversenkenClient client;
	private static String host = "twyco.ddns.net";
	private static int port = 4478;
	
	public void start() {
//		SpielfeldGUI gui = new SpielfeldGUI(10, 10);
//		gui.setVisible(true);
		NamenEingebenDialogData enterNameData = new NamenEingebenDialogData();
		NamenEingebenDialog dialog = new NamenEingebenDialog(enterNameData, new NamenEingebenListener(enterNameData));
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		dialog.setVisible(true);
		JoinServer(enterNameData.getTxtfieldInput().getText());
	}
	
	public static void JoinServer(String name) {
		client = new SchiffeversenkenClient(host, port);
		client.send("JoinQueue_" + name);
	}
	
	
	
}
