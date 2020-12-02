package MuMuGill;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class Note extends Thread{
	
	private Image noteImage ;
	private Image noteCountMumuImage = new ImageIcon(Main.class.getResource("../images/gameplay/notes/frame_ping1.png")).getImage();
	private Image noteCountPerfect = new ImageIcon(Main.class.getResource("../images/gameplay/notes/frame_ping2.png")).getImage();
	//private ImageIcon noteBesicImage = new ImageIcon(Main.class.getResource("../image/gameMumu/noteBasicMumu.png"));
	
	//private JButton noteBesicButton = new JButton( noteBesicImage);
	
	private int x, y, width, height,x1,y1,score=400;
	private int noteType;
	private boolean proceeded = true;
	
	
	public int getScore() {
	/****
	 * 
	 * @return Points of this note.
	 ****/
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getWidth() {

		return width;
	}
	public int getXnote() {
		return x;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(int x,int y,int width,int height,int noteType) {
		/*******
		 * set position for built note
		 */

		this.x = x;
		this.y = y;	
		this.x1 = x;
		this.y1 = y;	
		this.height = height;
		this.width = width;

		this.noteType = noteType;
		/****
		 * set image like this that make random image of note.
		 */
		this.noteImage =  new ImageIcon(Main.class.getResource("../images/gameplay/notes/ping"+String.valueOf(noteType) +".png")).getImage();
	}
	public void screenDraw(Graphics2D g) {
		//if(noteType == 1) {
		g.drawImage(noteImage, x-50, y-50,null);
		if(width <= 180) {
			g.drawImage(noteCountPerfect, x1, y1, width, height, null);
		}
		else {
			g.drawImage(noteCountMumuImage, x1, y1, width, height, null);
		}
		//}
		/*
		else if(noteType.equals("long")) {
			g.drawImage(noteBesicMumuImage, x-50, y-50, null);
			g.drawImage(noteCountMumuImage, x1, y1, width, height, null);
			g.drawImage(noteBesicMumuImage, x+50, y+50, null);
			
		}*/
	}

	public void drop() {
		if(height >= 100) {
			
			x1 = x-(width/2);
			y1 = y-(height/2);	
			/***
			 * update height value and width value
			 */
			height -= Main.NOTE_SPEED;
			width -= Main.NOTE_SPEED;
		}
		else {
			/****
			 * if height < 100 delete this note
			 */
			height = 0;
			width = 0 ;	
			
		}
		if(width == 0) {
			noteImage = new ImageIcon(Main.class.getResource("../images/gameplay/notes/pinggrill"+ String.valueOf(noteType) +".png")).getImage();
			//noteCountMumuImage = new ImageIcon(Main.class.getResource("../image/gameMumu/mouseBasic.png")).getImage();
			
			System.out.println("Miss");
			this.score = 0;
			
			try {
				this.x -=  Main.NOTE_SPEED;
				this.y -= Main.NOTE_SPEED;
				this.x1 -=  Main.NOTE_SPEED;
				this.y1 -= Main.NOTE_SPEED;
	
				Thread.sleep(500);	
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			this.x = -100;
			this.y = -100;
			this.x1 = -100;
			this.y1 = 100;

			close();
		}
	}
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public boolean chackCollision(int x, int y) {
		/****
		 *check position when mouse clicked that the position is in the range of note position.
		 */
		if (this.x-100 <= x && this.x+100 >= x ) {
			if (this.y-100 <= y&& this.y+100 >= y ) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public int judge() {
		/****
		 *check width of note when mouse clicked and return points of this note..
		 */
			if(width >= 180) {
				System.out.println("Bad");
				close();
			}
			else if(width >= 150 ) {
				System.out.println("Nice");
				close();
			}
			else if(width >= 120) {
				System.out.println("Great");
				close();
			}
			else if(width >= 100) {
				System.out.println("Perfect");
				close();
			}
			
		
			this.x = -100;
			this.y = -100;
			this.x1 = -100;
			this.y1 = -100;
			if(width >= 180) {
				score = 50;
				return 50;
			}
			else if(width >= 150 ) {
				score = 100;
				return 100;
			}
			else if(width >= 120) {
				score = 200;
				return 200;
			}
			else if(width >= 100) {
				score = 300;
				return 300;
			}
			
			close();
			return 0;
		
		//System.out.println("janeMiss");
	}
}
