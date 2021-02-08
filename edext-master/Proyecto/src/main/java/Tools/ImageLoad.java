package Tools;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLoad extends JLabel {
	private BufferedImage img = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 10;
	int height = 10;
	public ImageLoad(String imgPath) {
		Dimension dim = new Dimension(width, height);

		try {
			img = ImageIO.read(getClass().getResource(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMinimumSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);
		Image dimg = img.getScaledInstance(width,height,
		   Image.SCALE_SMOOTH);
		ImageIcon programIcon = new ImageIcon(dimg);
				//new I(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/errorIcon.png")));
		this.setIcon(programIcon);		
	}
}
