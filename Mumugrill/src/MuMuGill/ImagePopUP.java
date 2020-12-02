package MuMuGill;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

/*****
 * 
 * This class keep image for show when player can receive continuous perfect.
 *
 ****/
public class ImagePopUP extends Thread{

	private Image popUp = new ImageIcon(Main.class.getResource("../images/gameplay/popup.png")).getImage();
	public void screenDraw(Graphics2D g) {
		g.drawImage(popUp, 0, 0, null);	//set position image.	
	}
	
}