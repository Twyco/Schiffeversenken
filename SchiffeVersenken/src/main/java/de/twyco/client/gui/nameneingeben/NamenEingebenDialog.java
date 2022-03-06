package de.twyco.client.gui.nameneingeben;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.twyco.client.gui.listener.NamenEingebenListener;

public class NamenEingebenDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1440759297561810821L;

	public NamenEingebenDialog(NamenEingebenDialogData data, NamenEingebenListener listener) {
		super();
		data.setDialog(this);
		setVisible(false);
		setTitle("Gib deinen Namen ein");
		setModal(true);

		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		JPanel pane3 = new JPanel();
		
		JLabel lblHeader = new JLabel("Gibt deinen Namen ein:");
		data.setTxtfieldInput(new JTextField(15));
		data.getTxtfieldInput().setSize(200, 50);
		
		data.setBtnstart(new JButton("Start"));
		data.getBtnstart().setSize(50, 30);
		data.getBtnstart().addActionListener(listener);

		pane1.add(lblHeader);
		pane2.add(data.getTxtfieldInput());
		pane3.add(data.getBtnstart());
		
		JPanel outer = new JPanel(new BorderLayout());
		outer.add(pane1, BorderLayout.PAGE_START);
		outer.add(pane2, BorderLayout.CENTER);
		outer.add(pane3, BorderLayout.PAGE_END);
		
		setContentPane(outer);
		pack();
		setSize(getWidth() + 200, getHeight());
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
}
