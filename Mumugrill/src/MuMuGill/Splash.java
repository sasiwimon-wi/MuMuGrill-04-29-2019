package MuMuGill;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Splash {
	
	private Music musicsp;
	Splash(){

		JFrame f = new JFrame();
		f.setLocation(100,100);
		f.setSize(Main.SCREEN_HEIGHT,Main.SCREEN_WIDTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//create instance of canvas for display video//
		musicsp = new Music("introMusic.mp3",false);
		musicsp.start();
		Canvas c  = new Canvas();
		//background is black//
		c.setBackground(Color.black);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(c);
		f.add(p);
		
		
		// read video file //
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:/Program Files/VideoLAN/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        //initialize//
        MediaPlayerFactory mpf = new MediaPlayerFactory();
        EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
        emp.setVideoSurface(mpf.newVideoSurface(c));
        //set full screen//
        emp.toggleFullScreen();
        //hide keyboard//
        emp.setEnableKeyInputHandling(false);
        //disable mouse//
        emp.setEnableMouseInputHandling(false);
        
        String file ="OpenLogo.avi";
        //prepare 
        emp.prepareMedia(file);
        emp.play();
        try {
			Thread.sleep(18500);
			Home dy = new Home();
	        dy.setVisible(true);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
        musicsp.close();
        f.setVisible(false);
        
	}
}
