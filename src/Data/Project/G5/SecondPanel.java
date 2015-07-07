package Data.Project.G5;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class SecondPanel extends JPanel implements ListSelectionListener {
	
	String name[];
	
	JLabel background;
	JLabel title;
	JList musiclist;
	JScrollPane sp;
	
	JPanel listPanel;
	JPanel titlePanel;
	
	Icon bg = new ImageIcon (getClass().getResource("bg2.jpg"));
	
	Memory memory;
	
	Clip clip;
	File file = new File(this.getClass().getResource("/").getPath());
	File file2 = new File(this.getClass().getResource("/").getPath());
	File file3 = new File(this.getClass().getResource("/").getPath());
	AudioInputStream ais;
	
	int ctl;
	
	CountDownLatch clipDone = new CountDownLatch(1);
	
	public SecondPanel (Memory memory){
		super ();
		this.setLayout(new BorderLayout());
		
		this.memory = memory;

		titlePanel = new JPanel();
		title = new JLabel("Choose a Song You Like");
		title.setFont(new Font("Buxton Sketch", Font.BOLD ,50));
		title.setForeground(Color.WHITE);
		title.setPreferredSize(new Dimension(500,70));
		background = new JLabel (bg);
		
		titlePanel.setOpaque(false);
		titlePanel.setBounds(420, 70, 500, 100);
		
		titlePanel.add(title);
		
		name = new String[]{
				"ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ - Lovely", "ï¿½ï¿½ï¿½`ï¿½ï¿½ - ï¿½ï¿½ï¿½ï¿½","ï¿½ï¿½ï¿½ï¿½ï¿½ - ï¿½Jï¿½}ï¿½ï¿½","ï¿½iï¿½ï¿½[-Cï¿½jï¿½ï¿½","ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½Ú¤ï¿½ï¿½@ï¿½ï¿½ï¿½Aï¿½@ï¿½Ó¤H","ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½pï¿½bï¿½ï¿½ï¿½y","ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½Ê·RING","ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½Ë¤ßªï¿½ï¿½Hï¿½OÅ¥ï¿½Cï¿½q",
				"ï¿½Qï¿½pï¿½ï¿½-Å¥ï¿½ï¿½ï¿½Uï¿½Bï¿½ï¿½ï¿½nï¿½ï¿½","ï¿½Lï¿½Tï¿½ï¿½-ï¿½]ï¿½Aï¿½Ó¦b","ï¿½Lï¿½Tï¿½ï¿½-ï¿½Iï¿½ï¿½Iï¿½Ö©ï¿½","ï¿½Lï¿½Tï¿½ï¿½-ï¿½×½mï¿½Rï¿½ï¿½","ï¿½ï¿½ï¿½ï¿½-Valentine's Day","ï¿½]ï¿½Pï¿½ï¿½-ï¿½Jï¿½ï¿½","ï¿½iï¿½ï¿½[-ï¿½fï¿½Uï¿½ï¿½ï¿½Ñªï¿½","ï¿½ï¿½ï¿½Rï¿½ï¿½-ï¿½Sï¿½ï¿½ï¿½pï¿½G",
				"ï¿½ï¿½ï¿½Rï¿½ï¿½-ï¿½xï¿½x","ï¿½ï¿½ï¿½Kï¿½O-ï¿½@ï¿½Ó¤Hï¿½Qï¿½Û¤@ï¿½Ó¤H","ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½~ï¿½ï¿½","ï¿½ï¿½ï¿½Ú»y-ï¿½Rï¿½A"	
		};
		
		musiclist = new JList(name);
		musiclist.setFont(new Font("ï¿½Đ·ï¿½ï¿½ï¿½" , Font.PLAIN , 22));
		musiclist.setSelectionForeground(Color.BLUE);
		musiclist.addListSelectionListener(this);
		
		sp = new JScrollPane(musiclist);
		sp.setPreferredSize(new Dimension(640,360));
		
		listPanel = new JPanel();
		listPanel.setBounds(320, 190, 640, 365);
		listPanel.add(sp);
		listPanel.setOpaque(false);
		
		background = new JLabel (bg);
		
		add (listPanel);
		add (titlePanel);
		add (background);

		file = new File (file.getPath() + "/lovely.wav");
		file2 = new File (file2.getPath() + "/ï¿½ï¿½ï¿½ï¿½.wav");
		file3 = new File (file3.getPath() + "/ï¿½ï¿½ï¿½ï¿½ï¿½-ï¿½Jï¿½}ï¿½ï¿½.wav");
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	
	public void valueChanged(ListSelectionEvent event) {
		JList temp = (JList) event.getSource();
		if (event.getValueIsAdjusting()) {
			return; 
		}
		else if ((String) temp.getSelectedValue() == "ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ - Lovely"){
			if (ctl == 1){
				clip.stop();
				try {
	            	this.ais = AudioSystem.getAudioInputStream(file);
	            	this.clip = (Clip) AudioSystem.getClip();
	            	this.clip.open(ais);
	            	ctl = 1;
	            	this.clip.start();
	        	} catch (UnsupportedAudioFileException ex) {
	        		ex.printStackTrace();
	        	} catch (Exception ex) {
	            	ex.printStackTrace();
	        	}
				memory.setSong((String) temp.getSelectedValue());
			}
			else {
				try {
					this.ais = AudioSystem.getAudioInputStream(file);
					this.clip = (Clip) AudioSystem.getClip();
					this.clip.open(ais);
					ctl = 1;
					this.clip.start();
				} catch (UnsupportedAudioFileException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				memory.setSong((String) temp.getSelectedValue());
			}
		}else if ((String) temp.getSelectedValue() == "ï¿½ï¿½ï¿½`ï¿½ï¿½ - ï¿½ï¿½ï¿½ï¿½"){
			if (ctl == 1){
				clip.stop();
				try {
	            	this.ais = AudioSystem.getAudioInputStream(file2);
	            	this.clip = (Clip) AudioSystem.getClip();
	            	this.clip.open(ais);
	            	ctl = 1;
	            	this.clip.start();
	        	} catch (UnsupportedAudioFileException ex) {
	        		ex.printStackTrace();
	        	} catch (Exception ex) {
	            	ex.printStackTrace();
	        	}
				memory.setSong((String) temp.getSelectedValue());
			}
			else {
				try {
	            	this.ais = AudioSystem.getAudioInputStream(file2);
	            	this.clip = (Clip) AudioSystem.getClip();
	            	this.clip.open(ais);
	            	ctl = 1;
	            	this.clip.start();
	        	} catch (UnsupportedAudioFileException ex) {
	        		ex.printStackTrace();
	        	} catch (Exception ex) {
	            	ex.printStackTrace();
	        	}
				memory.setSong((String) temp.getSelectedValue());
			}
		}else if ((String) temp.getSelectedValue() == "ï¿½ï¿½ï¿½ï¿½ï¿½ - ï¿½Jï¿½}ï¿½ï¿½"){
			if (ctl == 1){
				clip.stop();
				try {
	            	this.ais = AudioSystem.getAudioInputStream(file3);
	            	this.clip = (Clip) AudioSystem.getClip();
	            	this.clip.open(ais);
	            	ctl = 1;
	            	this.clip.start();
	        	} catch (UnsupportedAudioFileException ex) {
	        		ex.printStackTrace();
	        	} catch (Exception ex) {
	            	ex.printStackTrace();
	        	}
				memory.setSong((String) temp.getSelectedValue());
			}
			else {
				try {
	            	this.ais = AudioSystem.getAudioInputStream(file3);
	            	this.clip = (Clip) AudioSystem.getClip();
	            	this.clip.open(ais);
	            	ctl = 1;
	            	this.clip.start();
	        	} catch (UnsupportedAudioFileException ex) {
	        		ex.printStackTrace();
	        	} catch (Exception ex) {
	            	ex.printStackTrace();
	        	}
				memory.setSong((String) temp.getSelectedValue());
			}
		}
	}
	
}
