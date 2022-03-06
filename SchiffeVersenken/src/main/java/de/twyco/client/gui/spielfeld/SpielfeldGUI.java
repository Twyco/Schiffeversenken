package de.twyco.client.gui.spielfeld;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import de.twyco.client.gui.listener.SpielfeldListener;
import de.twyco.shared.spielfeld.Zustaende;

public class SpielfeldGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8048103297784987559L;
	private JLabel[][] labels = new JLabel[10][10];
	private JPanel panel1;
	
	public SpielfeldGUI(int sizeX, int sizeY) {
		super();
		setVisible(false);
		setTitle("Schiffeversenken");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTabbedPane pane = new JTabbedPane();
		panel1 = new JPanel();
		JPanel panel2 = new JPanel();	
		
		GridLayout gridlayout = new GridLayout(11, 11);
		gridlayout.setVgap(3);
		gridlayout.setHgap(3);
		MouseListener ml = new SpielfeldListener(this);
		
		panel1.add(new JLabel(""));	
		for(int i = 1; i <= 120; i++) {
			if((i%11) == 0) {
				if(i != 1) {
					JLabel l = new JLabel(i/11 + "");
					l.setHorizontalAlignment(JLabel.RIGHT);
					panel1.add(l);	
				}
			}else if(i <= 11){
				char c = (char) (64 + i);
				JLabel l = new JLabel(Character.toString(c));
				l.setHorizontalAlignment(JLabel.CENTER);
				l.setVerticalAlignment(JLabel.BOTTOM);
				panel1.add(l);
			}else {
				JLabel l = new JLabel(showImg(Zustaende.WASSER));
				StringBuilder name = new StringBuilder();
				char c = (char) (64 + i%11);
				name.append(c);
				name.append("");
				name.append(i/11);
				l.setName(name.toString());
				l.addMouseListener(ml);
				labels[Character.getNumericValue(c) - 10][(i/11)-1] = l;
				panel1.add(l);
			}
		}
		panel1.setLayout(gridlayout);
		
//		--------------------------------------------------
		
		JLabel w = new JLabel(showImg(Zustaende.WASSER));
		panel2.add(w);
		
		JLabel s = new JLabel(showImg(Zustaende.SCHIFF));
		panel2.add(s);
		
		pane.add("Eigenes Spielfeld", panel1);
		pane.add("Gegnerisches Spielfeld", panel2);
		
		this.add(pane);
		this.pack();
		setLocationRelativeTo(null);
	}
	
	public ImageIcon showImg(Zustaende z) {
		String folder = "img/";
        BufferedImage img = null;
        try {
        	if(z.equals(Zustaende.NICHTS)) {
                img = ImageIO.read(getClass().getResource(folder + "nichts.png"));
        	}else if(z.equals(Zustaende.SCHIFF)) {
                img = ImageIO.read(getClass().getResource(folder + "schiff.png"));
        	}else if(z.equals(Zustaende.TREFFER)) {
                img = ImageIO.read(getClass().getResource(folder + "treffer.png"));
        	}else if(z.equals(Zustaende.WASSER)) {
                img = ImageIO.read(getClass().getResource(folder + "wasser.png"));
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon(img);
    }

	public void changeLabel(int x, int y, Zustaende newZustaend) {
		int order = (11 * (x-1)) + y + 10;
		this.panel1.remove(120);
		this.panel1.setComponentZOrder(new JLabel("Test"), 120);
		
	}
	
}
