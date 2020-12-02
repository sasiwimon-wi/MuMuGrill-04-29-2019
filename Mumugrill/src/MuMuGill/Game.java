package MuMuGill;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MuMuGill.CircleClickListener;

public class Game extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	
	
	private Image Background;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/gameplay/backEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/gameplay/backBasic.png"));
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private Music musicSelected;
	
	public static Gameplay gameplay;
	
	public Game(String background,String music,String titlename) {
		
		this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		addMouseListener(new CircleClickListener());
		gameplay = new Gameplay(titlename,music);
		gameplay.start();
		setFocusable(true);
		Background = new ImageIcon(Main.class.getResource("../images/Select/"+background)).getImage();
		setUndecorated(true);
		setTitle("Menu");
//		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
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
		
		backButton.setBounds(1220, 670, 50, 50);
		backButton.setBorderPainted(false);//ź�ͺ
		backButton.setContentAreaFilled(false);//ź�����ѧ
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				Menu menu = new Menu();
				menu.setVisible(true);
				gameplay.close();
				setVisible(false);
			}
		});
		add(backButton);
		
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
		screenDraw((Graphics2D)screenGraphic);//��ͧ���ҿ�Ԥ���е�ǡѹ������Ҿ�С�оԺ
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);//��Ҥ�ҡ�ҿ�Ԥ�����Ҵ�����Ҵ�ٻ��������
		gameplay.screenDraw(g);
		paintComponents(g);
		this.repaint();
		//g.drawImage(screenImage, 0, 0, null);
	}

}
