package de.twyco.client.gui.warten;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class WartenAufSpielerDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7151053102923034269L;
	private JProgressBar prBar;

	public WartenAufSpielerDialog() {
		super();
		setVisible(false);
		setTitle("Warten auf weiteren Spieler");
		setModal(false);
		
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		
		JLabel lblHeader = new JLabel("Warten auf weiteren Spieler...");
		prBar = new JProgressBar();
		prBar.setSize(300, 200);
		prBar.setIndeterminate(true);
		
		pane1.add(lblHeader);
		pane2.add(prBar);
		
		JPanel outer = new JPanel(new BorderLayout());
		outer.add(pane1, BorderLayout.PAGE_START);
		outer.add(pane2, BorderLayout.CENTER);

		setContentPane(outer);
		pack();
		setSize(getWidth() + 200, getHeight());
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
