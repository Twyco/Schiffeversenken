package de.twyco.client.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.twyco.client.gui.nameneingeben.NamenEingebenDialogData;

public class NamenEingebenListener implements ActionListener{

	private NamenEingebenDialogData data;

	public NamenEingebenListener(NamenEingebenDialogData data) {
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(data.getBtnstart())) {
			String name = data.getTxtfieldInput().getText();
			if(name.length() >= 3 && name.length() <= 16) { //JOIN SERVER
				data.getDialog().setVisible(false);
			}else {
				if(name.length() > 3) {
					JOptionPane.showMessageDialog(data.getDialog(), "Dein Name darf maximal 16 Zeichen enthalten",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(data.getDialog(), "Dein Name muss mindestens 3 Zeichen enthalten",
							"Error", JOptionPane.ERROR_MESSAGE);	
				}
			}
		}
	}

}
