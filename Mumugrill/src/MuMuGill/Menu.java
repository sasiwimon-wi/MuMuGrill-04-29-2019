package MuMuGill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.Thread.State;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	//BG menu
	private Image Background = new ImageIcon(Main.class.getResource("../images/Select/song_bg.jpg")).getImage();
	
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Select/startGamePlayButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/Select/startGamePlayButtonEntered.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/Select/bottonNextLeft_entered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Select/bottonNextLeft_basic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/Select/bottonNextRight_entered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Select/bottonNextRight_basic.png"));
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	private int mouseX, mouseY;
	
	//ARRAY TRACK
	ArrayList<Track> trackList = new ArrayList<Track>();
	//ATT TRACK
	private Music selectedMusic;
	private Image titleImage;
	private Image selectedImage;
	private Image charImage;
	private int nowSelected = 0;
	private boolean ifgamestart = false;
	
	//Menu loop game
	public Menu() {
		this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Game");
//		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		trackList.add(new Track("song1_name.png","song1_pic.png","game1Backgrounds.jpg","song1_character.png","song1_yakiniku-intro.mp3","song1_yakiniku.mp3","Yakiniku-sweet16"));
		trackList.add(new Track("song2_name.png","song2_pic.png","game2Backgrounds.jpg","song2_character.png","song2_magic-intro.mp3","song2_magic.mp3","Magic-Coco&Nanahira"));
		trackList.add(new Track("song3_name.png","song3_pic.png","game3Backgrounds.jpg","song3_character.png","song3_nightglow-intro.mp3","song3_nightglow.mp3","Nightglow-Tanya Chua"));
		trackList.add(new Track("song4_name.png","song4_pic.png","game4Backgrounds.jpg","song4_character.png","song4_hitorigoto-intro.mp3","song4_hitorigoto.mp3","Hitorigoto-ClariS"));
		selectTrack(0);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);//ź�ͺ
		exitButton.setContentAreaFilled(false);//ź�����ѧ
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		leftButton.setBounds(140, 310, 134, 142);
		leftButton.setBorderPainted(false);//ź�ͺ
		leftButton.setContentAreaFilled(false);//ź�����ѧ
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setBounds(1080, 310, 134, 142);
		rightButton.setBorderPainted(false);//ź�ͺ
		rightButton.setContentAreaFilled(false);//ź�����ѧ
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				selectRight();
				
			}
		});
		add(rightButton);
		
		startButton.setBounds(1100, 475, 152, 154);
		startButton.setBorderPainted(false);//ź�ͺ
		startButton.setContentAreaFilled(false);//ź�����ѧ
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"easy");
				
				
			}
			
		});
		add(startButton);
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {//�Ѻ���x,y �ҡ˹�Ҩ�
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {//set ����˹� frame ����ҡ
			@Override
			public void mouseDragged(MouseEvent e) {//������ҡ
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y);
			}
		});
		add(menuBar);
	}
    
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//�Ҵ���ҧ�������
		screenGraphic = screenImage.getGraphics();//��Ң�Ҵ�����ҡ����ҿ�Ԥ���
		screenDraw(screenGraphic);//��ͧ���ҿ�Ԥ���е�ǡѹ������Ҿ�С�оԺ
		//g.drawImage(introBackground, 0, 0, null);
		//this.repaint();
		
		//screenGraphic.drawImage(introBackground, 0, 0, null);Ẻ��������
		//this.repaint();
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);//��Ҥ�ҡ�ҿ�Ԥ�����Ҵ�����Ҵ�ٻ��������
		g.drawImage(selectedImage,0,0,null);
		g.drawImage(titleImage,0,0,null);
		g.drawImage(charImage,0,0,null);
		paintComponents(g);
		this.repaint();
		//g.drawImage(screenImage, 0, 0, null);
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/Select/"+trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/Select/"+trackList.get(nowSelected).getStartImage())).getImage();
		charImage = new ImageIcon(Main.class.getResource("../images/Select/"+trackList.get(nowSelected).getCharImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	
	public void gameStart(int nowselected,String difficulty) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		Game game = new Game(trackList.get(nowSelected).getGameImage(),trackList.get(nowSelected).getGameMusic(),trackList.get(nowSelected).getTitleName());
		game.setVisible(true);
		setVisible(false);

		
	}
}
