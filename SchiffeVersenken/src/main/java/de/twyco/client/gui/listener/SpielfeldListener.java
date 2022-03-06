package de.twyco.client.gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.twyco.client.gui.spielfeld.SpielfeldGUI;

public class SpielfeldListener implements MouseListener{

	private SpielfeldGUI gui;
	
	public SpielfeldListener(SpielfeldGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() instanceof JLabel) {
//			System.out.println(e.getComponent().getName());
			char c = e.getComponent().getName().charAt(0);
			int posX = Character.getNumericValue(c) - 9;
			int posY = Integer.parseInt(e.getComponent().getName().substring(1));
//			System.out.println(posX + " " + posY);
			gui.changeLabel(posX, posY, null);
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
