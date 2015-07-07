package Data.Project.G5;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GamePanel extends JPanel implements KeyListener{
	protected static final int UPDATE_RATE = 50;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date dt = new Date();
	String dts = sdf.format(dt);
	
	JLabel background = new JLabel (new ImageIcon (getClass().getResource("bg2.png")));
	JLabel uppic = new JLabel (new ImageIcon (getClass().getResource("clickup.png")));
	JLabel downpic = new JLabel (new ImageIcon (getClass().getResource("clickdown.png")));
	JLabel rightpic = new JLabel (new ImageIcon (getClass().getResource("clickright.png")));
	JLabel leftpic = new JLabel (new ImageIcon (getClass().getResource("clickleft.png")));
	JLabel uppic1 = new JLabel (new ImageIcon (getClass().getResource("up.png")));
	JLabel downpic1 = new JLabel (new ImageIcon (getClass().getResource("down.png")));
	JLabel rightpic1 = new JLabel (new ImageIcon (getClass().getResource("right.png")));
	JLabel leftpic1 = new JLabel (new ImageIcon (getClass().getResource("left.png")));
	JLabel unuppic1 = new JLabel (new ImageIcon (getClass().getResource("un_up.png")));
	JLabel undownpic1 = new JLabel (new ImageIcon (getClass().getResource("un_down.png")));
	JLabel unrightpic1 = new JLabel (new ImageIcon (getClass().getResource("un_right.png")));
	JLabel unleftpic1 = new JLabel (new ImageIcon (getClass().getResource("un_left.png")));

	JLabel string;
	JLabel scoreLabel;
	
	JPanel strPanel;
	JPanel scorePanel;
	
	JPanel uppicPanel;
	JPanel downpicPanel;
	JPanel rightpicPanel;
	JPanel leftpicPanel;
	
	JPanel downPanel;
	JPanel playPanel;
	JPanel runPanel;
	
	Play play;
	
	Memory memory;
	
	GridBagConstraints gbc;
	
	Clip clip;
	File file = new File(this.getClass().getResource("/").getPath());
	File file2 = new File(this.getClass().getResource("/").getPath());
	File file3 = new File(this.getClass().getResource("/").getPath());
	File finish = new File(this.getClass().getResource("/").getPath());
	File ready = new File(this.getClass().getResource("/").getPath());
	File go = new File(this.getClass().getResource("/").getPath());
	AudioInputStream ais;
	
	Thread gameThread;
	Thread timeThread;
	
	int xup=629,xdown=532,xleft=435,xright=726,width=96;
	int yup=0,ydown=0,yleft=0,yright=0;
	
	int speed,second,min,sec,tempmin,tempsec,stime;
	
	int keydrop,keydrop2;
	int keydropnumb;
	
	int score = 0;
	int scoreup,scoredown,scoreleft,scoreright;
	
	boolean run = false;
	
	public GamePanel (Memory memory){
		super ();
		this.setLayout (new BorderLayout());
		this.memory = memory;
		memory.setTime(dts);
		
		file = new File (file.getPath() + "/lovely.wav");
		file2 = new File (file2.getPath() + "/����.wav");
		file3 = new File (file3.getPath() + "/�����-�J�}��.wav");
		finish = new File (finish.getPath() + "/SB_game end.wav");
		ready = new File (ready.getPath() + "/voice_r.wav");
		go = new File (go.getPath() + "/voice_s.wav");
				
		play = new Play();
		
		playPanel = new JPanel();
		playPanel.setBackground(Color.GRAY);
		playPanel.setLayout(new BorderLayout());
		playPanel.setBounds(435, 0, 387, 720);
		playPanel.add(play);
		
		gbc = new GridBagConstraints();		
		downPanel = new JPanel();
		downPanel.setLayout(new GridBagLayout());
		
		gbc.insets = new Insets(1,1,1,1);
		gbc.gridx = 0;
		downPanel.add(unleftpic1, gbc);
		gbc.gridx = 1;
		downPanel.add(undownpic1, gbc);
		gbc.gridx = 2;		
		downPanel.add(unuppic1, gbc);
		gbc.gridx = 3;
		downPanel.add(unrightpic1, gbc);
		downPanel.setBounds(435 , 593, 387, 96);
		downPanel.setOpaque(false);
		
		uppicPanel = new JPanel();
   	 	uppicPanel.setOpaque(false);
   	 	uppicPanel.setBounds(xup, -100, width, width);
		uppicPanel.add(uppic1);
		downpicPanel = new JPanel();
		downpicPanel.setOpaque(false);
		downpicPanel.setBounds(xdown, -100, width, width);
		downpicPanel.add(downpic1);
		rightpicPanel = new JPanel();
		rightpicPanel.setOpaque(false);
		rightpicPanel.setBounds(xright, -100, width, width);
		rightpicPanel.add(rightpic1);
		leftpicPanel = new JPanel();
		leftpicPanel.setOpaque(false);
		leftpicPanel.setBounds(xleft, -100, width, width);
		leftpicPanel.add(leftpic1);
		
		add(leftpicPanel);
		add(rightpicPanel);
		add(downpicPanel);
		add(uppicPanel);
		
		
		string = new JLabel();
		strPanel = new JPanel();
		strPanel.add(string);
		strPanel.setBounds(10, 650, 300, 40);
		strPanel.setBackground(Color.BLACK);
				
		scoreLabel = new JLabel();
		scoreLabel.setText("Score  "+String.valueOf(memory.getScore()));
		scoreLabel.setFont(new Font("Buxton Sketch" , Font.PLAIN , 80));
		scoreLabel.setForeground(Color.WHITE);
		scorePanel = new JPanel();
		scorePanel.add(scoreLabel);
		scorePanel.setBounds(10, 10, 400, 100);
		scorePanel.setOpaque(false);
		
		this.setOpaque(false);
		
		add (scorePanel);
		add (strPanel);
		add (downPanel);
		add (playPanel);
		add (background);
				
		play.gameStart();
	}

	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
	
	public void setRun(boolean run){
		this.run = run;
		play.gameStart();
		
		System.out.println (this.run);
	}
	
	public void playmusic(){
		if (memory.getSong() == "������ - Lovely"){
			min=4;
			sec=30;
			tempmin=4;
			tempsec=30;
			speed = 30;
			stime = 24;
			try {
            	ais = AudioSystem.getAudioInputStream(file);
            	clip = (Clip) AudioSystem.getClip();
            	clip.open(ais);
            	clip.start();
        	} catch (UnsupportedAudioFileException ex) {
        		ex.printStackTrace();
        	} catch (Exception ex) {
            	ex.printStackTrace();
        	}
		}else if (memory.getSong() == "���`�� - ����"){
			min=3;
			sec=53;
			tempmin=3;
			tempsec=53;
			speed = 25;
			stime = 28;
			try {
            	ais = AudioSystem.getAudioInputStream(file2);
            	clip = (Clip) AudioSystem.getClip();
            	clip.open(ais);
            	clip.start();
        	} catch (UnsupportedAudioFileException ex) {
        		ex.printStackTrace();
        	} catch (Exception ex) {
            	ex.printStackTrace();
        	}
		}else if (memory.getSong() == "����� - �J�}��"){
			min=3;
			sec=30;
			tempmin=3;
			tempsec=30;
			speed = 20;
			stime = 20;
			try {
            	ais = AudioSystem.getAudioInputStream(file3);
            	clip = (Clip) AudioSystem.getClip();
            	clip.open(ais);
            	clip.start();
        	} catch (UnsupportedAudioFileException ex) {
        		ex.printStackTrace();
        	} catch (Exception ex) {
            	ex.printStackTrace();
        	}
		}		
	}
	

	public void keyctl(int key){
		System.out.println(score);
		switch (key){
		case 1:
			scoreleft = yleft;
			downPanel.remove(unleftpic1);
			gbc.gridx = 0;
			downPanel.add(leftpic,gbc);
			downPanel.updateUI();
			scoreCalculate();
			break;
		case 2:
			scoredown = ydown;
			downPanel.remove(undownpic1);
			gbc.gridx = 1;
			downPanel.add(downpic,gbc);
			downPanel.updateUI();
			scoreCalculate();
			break;
		case 3:
			scoreup = yup;
			downPanel.remove(unuppic1);
			gbc.gridx = 2;
			downPanel.add(uppic,gbc);
			downPanel.updateUI();
			scoreCalculate();
			break;
		case 4:
			scoreright = yright;
			downPanel.remove(unrightpic1);
			gbc.gridx = 3;
			downPanel.add(rightpic,gbc);
			downPanel.updateUI();
			scoreCalculate();
			break;
		case 5:
			downPanel.remove(leftpic);
			gbc.gridx = 0;
			downPanel.add(unleftpic1,gbc);
			downPanel.updateUI();
			break;
		case 6:
			downPanel.remove(downpic);
			gbc.gridx = 1;
			downPanel.add(undownpic1,gbc);
			downPanel.updateUI();
			break;
		case 7:
			downPanel.remove(uppic);
			gbc.gridx = 2;
			downPanel.add(unuppic1,gbc);
			downPanel.updateUI();
			break;
		case 8:
			downPanel.remove(rightpic);
			gbc.gridx = 3;
			downPanel.add(unrightpic1,gbc);
			downPanel.updateUI();
			break;
		}
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
		Date dt = new Date();
		String dts = sdf.format(dt);
		memory.setTime(dts);
		
		score = 0;
		memory.setScore(score);
		scoreLabel.setText("Score  "+String.valueOf(memory.getScore()));
		
   	 	uppicPanel.setBounds(xup, -100, width, width);
		downpicPanel.setBounds(xdown, -100, width, width);
		rightpicPanel.setBounds(xright, -100, width, width);
		leftpicPanel.setBounds(xleft, -100, width, width);
		play.repaint();
	}
	
	class Play extends JPanel{
		
		Container con;
		
		public Play(){
			super ();
			this.setOpaque(false);
		}
		
		public void gameStart() {
			
			keydrop = 1;
			
				gameThread = new Thread() {
					public void run() {
						while (run) {
							gameUpdate();
						
							repaint();
							
					        downPanel.repaint();
						
							try {
								Thread.sleep(1000 / UPDATE_RATE);
							}catch (InterruptedException ex) {
								
							}
						}
					}
				};
				timeThread = new Thread() {
					Clip clip1;
					public void run() {
						while (run) {
							if (second == stime-5){
								try {
					            	ais = AudioSystem.getAudioInputStream(ready);
					            	clip1 = (Clip) AudioSystem.getClip();
					            	clip1.open(ais);
					            	clip1.start();
					        	} catch (UnsupportedAudioFileException ex) {
					        		ex.printStackTrace();
					        	} catch (Exception ex) {
					            	ex.printStackTrace();
					        	}
							}else if (second == stime-2){
								try {
					            	ais = AudioSystem.getAudioInputStream(go);
					            	clip1 = (Clip) AudioSystem.getClip();
					            	clip1.open(ais);
					            	clip1.start();
					        	} catch (UnsupportedAudioFileException ex) {
					        		ex.printStackTrace();
					        	} catch (Exception ex) {
					            	ex.printStackTrace();
					        	}
							}else if (second == stime){
								gameThread.start();
							}
							
							if(tempmin==0&&tempsec==0){
								second--;
								string.setText(String.format(memory.getSong()+"      %02d  :  %02d / "+ min+"  :  "+sec, tempmin, tempsec));
								con = getRootPane();
								
								clip.stop();
								run = false;
								
								try {
					            	ais = AudioSystem.getAudioInputStream(finish);
					            	clip1 = (Clip) AudioSystem.getClip();
					            	clip1.open(ais);
					            	clip1.start();
					        	} catch (UnsupportedAudioFileException ex) {
					        		ex.printStackTrace();
					        	} catch (Exception ex) {
					            	ex.printStackTrace();
					        	}
								
								
								String title = "--Warning--";
								String message = "Thank You For Playing !";
								int type = JOptionPane.INFORMATION_MESSAGE;
								
								JOptionPane.showMessageDialog(con, message, title, type);
								
							}
							else if(tempsec==0){
								tempmin--;
								tempsec=59;
							}
							string.setText(String.format(memory.getSong()+"      %02d  :  %02d / "+ min+"  :  "+sec, tempmin, tempsec));
							string.setFont(new Font("�s�ө���" , Font.PLAIN , 18));
							string.setForeground(Color.WHITE);
							tempsec--;
			                second++;
			                
			                try {
			                    Thread.sleep(1000);
			                } catch (InterruptedException ex) {
			                }
						}
					}
				};
				timeThread.start();
		}
		
		public void gameUpdate() {
			if(keydropnumb==1){
				moveOneStep(keydrop);
			}
			else{
				moveOneStep(keydrop);
				moveOneStep(keydrop2);
			}
		}
		public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         
	         if(yup<=40||yup>=750){
	        	 uppicPanel.setBounds(xup, -100, width, width);
	         }else{
	        	 uppicPanel.setBounds(xup, yup, width, width);
	         }
	         if(ydown<=40||ydown>=750){
	        	 downpicPanel.setBounds(xup, -100, width, width);
	         }else{
	        	 downpicPanel.setBounds(xdown, ydown, width, width);
	         }
	         if(yright<=40||yright>=750){
	        	 rightpicPanel.setBounds(xup, -100, width, width);
	         }else{
	        	 rightpicPanel.setBounds(xright, yright, width, width);
	         }
	         if(yleft<=40||yleft>=750){
	        	 leftpicPanel.setBounds(xup, -100, width, width);
	         }else{
	        	 leftpicPanel.setBounds(xleft, yleft, width, width);
	         }
	    }
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
	
	public void scoreCalculate(){
		if(Math.abs(scoreup-593)<=15){
			score = score + 20;
			scoreup = 0;
		}
		else if(Math.abs(scoreup-593)<=25){
			score = score + 10;
			scoreup = 0;
		}
		else{
			scoreup = 0;
		}
		if(Math.abs(scoredown-593)<=15){
			score = score + 20;
			scoredown = 0;
		}
		else if(Math.abs(scoredown-593)<=25){
			score = score + 10;
			scoredown = 0;
		}
		else{
			scoredown = 0;
		}
		if(Math.abs(scoreleft-593)<=15){
			score = score + 20;
			scoreleft = 0;
		}
		else if(Math.abs(scoreleft-593)<=25){
			score = score + 10;
			scoreleft = 0;
		}
		else{
			scoreleft = 0;
		}
		if(Math.abs(scoreright-593)<=15){
			score = score + 20;
			scoreright = 0;
		}
		else if(Math.abs(scoreright-593)<=25){
			score = score + 10;
			scoreright = 0;
		}
		else{
			scoreright = 0;
		}
		memory.setScore(score);
		scoreLabel.setText("Score  "+String.valueOf(memory.getScore()));
	}
	
	public void moveOneStep(int keydrop) {
		Random rand = new Random();
		switch(keydrop){
			case 1:{
				yup += speed;
				if(yup>750){
					yup=0;
					this.keydrop = rand.nextInt(4)+1;
					this.keydrop2 = rand.nextInt(4)+1;
					this.keydropnumb = rand.nextInt(2)+1;
				}
				break;
			}
			case 2:{
				ydown += speed;
				if(ydown>750){
					ydown=0;
					this.keydrop = rand.nextInt(4)+1;
					this.keydrop2 = rand.nextInt(4)+1;
					this.keydropnumb = rand.nextInt(2)+1;
				}
				break;
			}
			case 3:{
				yright += speed;
				if(yright>750){
					yright=0;
					this.keydrop = rand.nextInt(4)+1;
					this.keydrop2 = rand.nextInt(4)+1;
					this.keydropnumb = rand.nextInt(2)+1;
				}
				break;
			}
			case 4:{
				yleft += speed;
				if(yleft>750){
					yleft=0;
					this.keydrop = rand.nextInt(4)+1;
					this.keydrop2 = rand.nextInt(4)+1;
					this.keydropnumb = rand.nextInt(2)+1;
				}
				break;
			}
		}
	}
}
