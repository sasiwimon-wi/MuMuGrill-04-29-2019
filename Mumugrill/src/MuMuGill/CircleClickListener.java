package MuMuGill;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/******
 * 
 * This class for give position when mouse clicked.
 *
 *****/
public class CircleClickListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getID() == MouseEvent.MOUSE_PRESSED) {
			//System.out.println(e.getX() + ", "+ e.getY());
			Game.gameplay.pressMouse(e.getX(),e.getY());
			//give position to pressMouse method in gameplay value of class game.
		}
		
	}


	

}
