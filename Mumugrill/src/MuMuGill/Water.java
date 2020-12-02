package MuMuGill;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import MuMuGill.Main;

public class Water extends Thread{
	private Image glass = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton1.png")).getImage();
	private Image glass1 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton1.png")).getImage();
	private Image glass2 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton2.png")).getImage();
	private Image glass3 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton3.png")).getImage();
	private Image glass4 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton4.png")).getImage();
	private Image glass5 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton5.png")).getImage();
	private Image glass6 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton6.png")).getImage();
	private Image glass7 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton7.png")).getImage();
	private Image glass8 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton8.png")).getImage();
	private Image glass9 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton9.png")).getImage();
	private Image glass10 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton10.png")).getImage();
	private Image glass11 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton11.png")).getImage();
	private Image glass12 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton12.png")).getImage();
	private Image glass13 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton13.png")).getImage();
	private Image glass14 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton14.png")).getImage();
	private Image glass15 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton15.png")).getImage();
	private Image glass16 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton16.png")).getImage();
	private Image glass17 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton17.png")).getImage();
	private Image glass18 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton18.png")).getImage();
	private Image glass19 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton19.png")).getImage();
	private Image glass20 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton20.png")).getImage();
	private Image glass21 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton21.png")).getImage();
	private Image glass22 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton22.png")).getImage();
	private Image glass22_1 = new ImageIcon(Main.class.getResource("../images/gameplay/glass/glassButton22_1.png")).getImage();
	
	private int x, y, width, height;
	private boolean proceeded = true;
	private boolean isCollision = false;
	
	public Water() {
		this.x = 860;
		this.y = 400;
		this.width = 300;
		this.height = 300;
		
				
	}
	
//	public int getLife() {
//		return life;
//	}
//
//	public void setLife(int life) {
//		this.life = life;
//	}

	public Image getGlass() {
		return glass;
	}

	public void setGlass(Image glass) {
		this.glass = glass;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public boolean isProceeded() {
		return proceeded;
	}

	public void setProceeded(boolean proceeded) {
		this.proceeded = proceeded;
	}

	public boolean isCollision() {
		return isCollision;
	}

	public void setCollision(boolean isCollision) {
		this.isCollision = isCollision;
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(glass,x,y,width,height,null);
//		try {
//				Thread.sleep(100);	
//			}catch(Exception e) {
//				System.err.println(e.getMessage());
//			}
	}
	
	public void decrease(int li) {
		int life = li;
		if(life == 990) {
			glass = glass1;
		}
		else if(life == 980) {
			glass = glass2;
		}
		else if(life == 970) {
			glass = glass3;
		}
		else if(life == 955) {
			glass = glass4;
		}
		//*******************
		else if(life == 945) {
			glass = glass5;
		}
		else if(life == 935) {
			glass = glass6;
		}
		else if(life == 920) {
			glass = glass7;
		}
		else if(life == 905) {
			glass = glass8;
		}
		//*********************
		else if(life == 890) {
			glass = glass9;
		}
		else if(life == 880) {
			glass = glass10;
		}
		else if(life == 870) {
			glass = glass11;
		}
		else if(life == 860) {
			glass = glass12;
		}
		//*********************
		else if(life == 845) {
			glass = glass13;
		}
		else if(life == 835) {
			glass = glass14;
		}
		else if(life == 825) {
			glass = glass15;
		}
		else if(life == 815) {
			glass = glass16;
		}
		//********************
		else if(life == 800) {
			glass = glass17;
		}
		else if(life == 790) {
			glass = glass18;
		}
		else if(life == 780) {
			glass = glass19;
		}
		else if(life == 770) {
			glass = glass20;
		}
		//*********************
		else if(life == 730) {
			glass = glass21;
		}
		else if(life == 715) {
			glass = glass22;
		}
		else if(life == 705) {
			glass = glass22_1;
		}
//		try {
//		Thread.sleep(505);	
//	}catch(Exception e) {
//		System.err.println(e.getMessage());
//	}
	}

}
