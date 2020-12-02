package MuMuGill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Credit extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	private Image Backgroundcredit = new ImageIcon(Main.class.getResource("../images/main/credit/credit.jpg")).getImage();
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon backButtonHomeImage = new ImageIcon(Main.class.getResource("../images/main/credit/bottonHome_basic.png"));
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton backButton = new JButton(backButtonHomeImage);
	
	private int mouseX, mouseY;
	
	Credit(){
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		Music introMusic = new Music("introMusic.mp3",true);
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
		
		backButton.setBounds(1050, 600, 200, 125);
		backButton.setBorderPainted(false);//ź�ͺ
		backButton.setContentAreaFilled(false);//ź�����ѧ
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//����������������ⴹ
				backButton.setIcon(backButtonHomeImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//���������͹������͡
				backButton.setIcon(backButtonHomeImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {//����ͤ�ԡ
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				Home home = new Home();
				home.setVisible(true);
				introMusic.close();
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
		screenDraw(screenGraphic);//��ͧ���ҿ�Ԥ���е�ǡѹ������Ҿ�С�оԺ
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(Backgroundcredit, 0, 0, null);//��Ҥ�ҡ�ҿ�Ԥ�����Ҵ�����Ҵ�ٻ��������
		paintComponents(g);
		this.repaint();
	}

}
