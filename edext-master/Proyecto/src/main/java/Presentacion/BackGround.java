package Presentacion;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackGround extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BackGround() {
		
		
	}
	
	public void paintComponent(Graphics g) {  
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui1.png"));  
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
	}
	
}
