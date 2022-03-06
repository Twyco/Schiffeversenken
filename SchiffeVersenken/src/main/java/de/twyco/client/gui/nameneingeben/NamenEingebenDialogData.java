package de.twyco.client.gui.nameneingeben;

import javax.swing.JButton;
import javax.swing.JTextField;

public class NamenEingebenDialogData {
	
	private NamenEingebenDialog dialog;
	private JButton btnstart;
	private JTextField txtfieldInput;

	public NamenEingebenDialogData() {
	}

	public JButton getBtnstart() {
		return btnstart;
	}

	public void setBtnstart(JButton btnstart) {
		this.btnstart = btnstart;
	}

	public JTextField getTxtfieldInput() {
		return txtfieldInput;
	}

	public void setTxtfieldInput(JTextField txtfieldInput) {
		this.txtfieldInput = txtfieldInput;
	}

	public NamenEingebenDialog getDialog() {
		return dialog;
	}

	public void setDialog(NamenEingebenDialog dialog) {
		this.dialog = dialog;
	}
}