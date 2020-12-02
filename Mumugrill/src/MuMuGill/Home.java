package MuMuGill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	//IMG EXIT
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	// IMG START
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/main/button/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/main/button/startButtonEntered.png"));
	private ImageIcon StartButtonPressedImage = new ImageIcon(Main.class.getResource("../images/main/button/startButtonPressed.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/main/button/exitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/main/button/exitButtonEntered.png"));
	private ImageIcon quitButtonPressedImage = new ImageIcon(Main.class.getResource("../images/main/button/exitButtonBasic.png"));
	private ImageIcon creditButtonBasicImage = new ImageIcon(Main.class.getResource("../images/main/button/creditButtonBasic.png"));
	private ImageIcon creditButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/main/button/creditButtonEntered.png"));
	private ImageIcon creditButtonPressedImage = new ImageIcon(Main.class.getResource("../images/main/button/creditButtonBasic.png"));
	//IMG SelectBG
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/main/homeBackground.jpg")).getImage();
	private Image giflogoBackground = new ImageIcon(Main.class.getResource("../images/main/logo.gif")).getImage();
	private Image logointroBackground = new ImageIcon(Main.class.getResource("../images/main/logoBG.png")).getImage();
	//Menu bar
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//BTT main
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton creditButton = new JButton(creditButtonBasicImage);

	private int mouseX, mouseY;
	
	public static Game game;
	
	public Home() {
		
		this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setTitle("Dynamic Beat");
//		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		Music introMusic = new Music("songintro.mp3",true);
		introMusic.start();
		
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
		
		startButton.setBounds(480, 430, 343, 101);
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
				startButton.setIcon(StartButtonPressedImage);
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					
					Thread.sleep(500);
					Menu menu = new Menu();
					menu.setVisible(true);
					
				} catch(InterruptedException ex) {
					
					ex.printStackTrace();
				}
				setVisible(false);
				introMusic.close();
				
				
			}
		});
		add(startButton);
		
		quitButton.setBounds(480, 520, 343, 101);
		quitButton.setBorderPainted(false);//ź�ͺ
		quitButton.setContentAreaFilled(false);//ź�����ѧ
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
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
		add(quitButton);
		
		creditButton.setBounds(480, 605, 343, 101);
		creditButton.setBorderPainted(false);//ź�ͺ
		creditButton.setContentAreaFilled(false);//ź�����ѧ
		creditButton.setFocusPainted(false);
		creditButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				creditButton.setIcon(creditButtonEnteredImage);
				creditButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				creditButton.setIcon(creditButtonBasicImage);
				creditButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				startButton.setIcon(creditButtonPressedImage);
				validate();
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				Credit credit = new Credit();
				try {
					
					Thread.sleep(1000);
					
				} catch(InterruptedException ex) {
					
					ex.printStackTrace();
				}
				setVisible(false);
				credit.setVisible(true);
				introMusic.close();
				
				
			}
		});
		add(creditButton);
		
		
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
		g.drawImage(introBackground, 0, 0, null);//��Ҥ�ҡ�ҿ�Ԥ�����Ҵ�����Ҵ�ٻ��������
		g.drawImage(giflogoBackground, 0, 0, this);
		paintComponents(g);
		this.repaint();
		//g.drawImage(screenImage, 0, 0, null);
	}

}
