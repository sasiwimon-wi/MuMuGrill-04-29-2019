package MuMuGill;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import MuMuGill.Beat;
import MuMuGill.Main;
import MuMuGill.Music;
import MuMuGill.Note;

public class Gameplay extends Thread{
	
//	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image scoreEffactMiss = new ImageIcon(Main.class.getResource("../images/gameplay/msgMiss.png"))
			.getImage();
	private Image scoreEffactBad = new ImageIcon(Main.class.getResource("../images/gameplay/msgBad.png")).getImage();
	private Image scoreEffactGood = new ImageIcon(Main.class.getResource("../images/gameplay/msgGood.png")).getImage();
	private Image scoreEffactNice = new ImageIcon(Main.class.getResource("../images/gameplay/msgNice.png")).getImage();
	private Image scoreEffactPerfect = new ImageIcon(Main.class.getResource("../images/gameplay/msgPerfect.png")).getImage();
	
	private Image scoreRangeS = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_s.png"))
			.getImage();
	private Image scoreRangeA = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_a.png"))
			.getImage();
	private Image scoreRangeB = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_b.png"))
			.getImage();
	private Image scoreRangeC = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_c.png"))
			.getImage();
	private Image scoreRangeD = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_d.png"))
			.getImage();
	private Image scoreRangeF = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore_f.png"))
			.getImage();
	
	
	private Image gameScoreBackground = new ImageIcon(Main.class.getResource("../images/gameplay/score/highscore.png"))
			.getImage();

	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	private State state;
	private boolean isGameOver = false;
	
	
    
	private int countPerfect;
	private int scoreForEffect = 1;
	private int score = 0;
	
	private int highestScore;
	private int scoreGrade;
	private Water water = new Water();
	private int score_w = 400,life=1000;//for water
	
	
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	ArrayList<Water> waterList = new ArrayList<Water>();
	
    public State getState() {
        return state;
    }
	
	public Gameplay(String titleName, String musicTitle) {
		this.titleName = titleName;
		//this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		gameMusic.start(); // start music while select track//
		
		
	}
	
	
	
	
	public void screenDraw(Graphics2D g) {
		
	    
		//g.drawImage(gameInfoImage, 0, 660, null);
		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			note.screenDraw(g);
			if(note.getScore() == 0) {//if score = 0 is miss
				life -= 1;
				water.decrease(life);//change picture
				System.out.println("life : "+life);
			}
		}
		
		if (scoreForEffect == 50) {
			g.drawImage(scoreEffactBad, 0, 0, null);
			
		}
		else if(scoreForEffect == 100) {
			g.drawImage(scoreEffactGood, 0, 0, null);
			
		}
		else if(scoreForEffect == 200) {
			g.drawImage(scoreEffactNice, 0, 0, null);
			
		}
		else if(scoreForEffect == 300) {
			g.drawImage(scoreEffactPerfect, 0, 0,null);
			
		}
		else if(scoreForEffect == 0) {
			g.drawImage(scoreEffactMiss, 0, 0,null);
		
		}
		if(life < 705) {
			this.isGameOver = true;
		}
		water.screenDraw(g);
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		
		
		g.drawString(titleName, 20, 55);
		
		if (this.countPerfect%2 == 0 && this.countPerfect != 0) {
			ImagePopUP imagePop = new ImagePopUP();
			imagePop.screenDraw(g);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
		g.drawString(intToString(score, 8), 800, 710);
		
		
		if(isGameOver) {
			g.drawImage(gameScoreBackground, 0, 0, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
			g.drawString(intToString(score, 8), 550, 580);
			gameMusic.close();
			scoreGrade = (score*100)/highestScore;
			if(scoreGrade >= 98) {
				g.drawImage(scoreRangeS, 0, 0, null);
			}
			else if (scoreGrade >= 80) {
				g.drawImage(scoreRangeA, 0, 0, null);
			}
			else if (scoreGrade >= 65) {
				g.drawImage(scoreRangeB, 0, 0, null);
			}
			else if (scoreGrade >= 40) {
				g.drawImage(scoreRangeC, 0, 0, null);
			}
			else if (scoreGrade >= 25) {
				g.drawImage(scoreRangeD, 0, 0, null);
			}
			else {
				g.drawImage(scoreRangeF, 0, 0, null);
			}
		}
		
	} //end screen drawing
	
	 public static String intToString(int number, int stringLength) {
	      int numberOfDigits = String.valueOf(number).length();
	      int numberOfLeadingZeroes = stringLength - numberOfDigits;
	      StringBuilder sb = new StringBuilder();
	      if (numberOfLeadingZeroes > 0) {
	         for (int i = 0; i < numberOfLeadingZeroes; i++) {
	            sb.append("0");
	         }
	      }
	      sb.append(number);
	      return sb.toString();
	   }

	public void pressMouse(int mX ,int mY) {
		judge(mX,mY);
		new Music("../music/drum/drumSmall2.mp3", false).start();
	}
	public void releaseMouse(int mX,int mY) {
	}
	@Override
	public void run() {
		dropNotes();
		
	}
	public void close() {
		gameMusic.close();
		//this.interrupt();
	}

	
	
	//NOTES WILL DROP MEDTHOD
	public void dropNotes() {
		Beat[] beats = null;
		Random random = new Random();
		//each music
		if(titleName.equals("Yakiniku-sweet16")) {
			
			Random rand = new Random();
			int startTime = 4400 - Main.REACH_TIME * 1000;
			int gap = 125,pat=0,count=0;
			beats = new Beat[540];
			beats[0] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime,random.nextInt(3)+1, false);
			for(int i=1;i<540;i++) {
				if(i <= 530) {
					beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, false);
					if(i >= 300) {
						pat += 4;
					}
					else if(i >= 200) {
						pat += 3;
					}
					else if(i >= 190){
						pat += 2;
					}else {
						pat += 4;
					}
				}
				else {
					beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, true);
				}
				
				
			}
	}
	else if(titleName.equals("Magic-Coco&Nanahira")) {
		Random rand = new Random();
		int startTime = 4000 - Main.REACH_TIME * 1000;
		int gap = 125,pat=0,count=0;
		beats = new Beat[590];
		beats[0] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime,random.nextInt(3)+1, false);
		for(int i=1;i<590;i++) {
			if(i <= 580) {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, false);
				pat += 4;
			}
			else {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, true);
			}
			
			
			
		}
	}
	else if(titleName.equals("Nightglow-Tanya Chua")) {
		Random rand = new Random();
		int startTime = 4000 - Main.REACH_TIME * 1000;
		int gap = 125,pat=0,count=0;
		beats = new Beat[310];
		beats[0] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime,random.nextInt(3)+1, false);
		for(int i=1;i<310;i++) {
			if(i <= 300) {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, false);
				if(i >= 250) {
					pat += 3;
				}
				else if(i >= 160) {
					pat += 4;
				}
				else {
					pat += 5;
				}
			}
			else {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, true);
			}
			
		}

	}  //end select song when  click start
		
		
	else if(titleName.equals("Hitorigoto-ClariS")) {
		Random rand = new Random();
		int startTime = 4000 - Main.REACH_TIME * 1000;
		int gap = 125,pat=0,count=0;
		beats = new Beat[180];
		beats[0] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime,random.nextInt(3)+1, false);
		for(int i=1;i<180;i++) {
			if(i <= 170) {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, false);
				pat += 4;
			}
			else {
				beats[i] = new Beat(rand.nextInt(600)+50,rand.nextInt(600)+70,startTime + gap * (12 + pat),random.nextInt(3)+1, true);
			}
			
			
		}
		
	}//end note each music
	
	int i = 0;
	
	//game over
	this.highestScore = (beats.length-1)*300;
	
	while(i < beats.length && !isInterrupted()) {
		boolean dropped = false;
		
		if(beats[i].getisGameOver()) {
			try {
				Thread.sleep(1500);
				this.isGameOver = beats[i].getisGameOver();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		if(!beats[i].getisGameOver()) {
			if(beats[i].getTime() <= gameMusic.getTime()) {
				scoreForEffect = 1;
				Note note = new Note(beats[i].getX(),beats[i].getY(),300,300,beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;

				
			}
		}	
		if(!dropped) {
			try {
				Thread.sleep(5);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
} // end drop note 
	
	
	// judge when click miss perfect good bad method
	public void judge(int input,int inputY) {
		for(int i = 0; i< noteList.size();i++) {
			Note note = noteList.get(i);
			
			if(note.chackCollision(input, inputY)) 
			{
				scoreForEffect = note.judge();
				
				//effect score if perfect more than 2 times
				if (scoreForEffect == 300) {
					this.countPerfect++;
				}
				else if (scoreForEffect <= 300 ){
					this.countPerfect = 0;
				}//end 2 time effect
				
				score += note.judge();
				break;
			}
		}
	}
	
	
	

}
