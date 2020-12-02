package MuMuGill;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
/******
 * this class for manage music.
 *****/
public class Music extends Thread{
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	/****
	 * @param name : this value is name of the song to be played.
	 * @param isLoop : this value for close or open music.
	 ****/
	public Music(String name, boolean isLoop) {//��� isLoop ��������Ҩ�����ŧ��� run �� loop �������
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());//����ŧ������
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*****
	 * getTime method is get time of music.
	 * this method make for check time to drop note.
	 ****/
	public int getTime() {
		if(player == null) {
			return 0;
		}
		return player.getPosition();
	}
	
	/*******
	 * close method for close music.
	 */
	public void close() {
		this.isLoop = false;
		player.close();
		this.interrupt();
	}
	
	/*****
	 * run method for open music.
	 ****/
	@Override
	public void run() {//��� isLoop �� false ����蹤�������
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);//�� obj �������� run �ա�ͺ
			}while(isLoop);//��ǹ������ isLoop �繨�ԧ
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
