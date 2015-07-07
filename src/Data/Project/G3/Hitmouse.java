package Data.Project.G3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Hitmouse extends JPanel implements ActionListener {
	private Board board;

	private Random rand;

	private int mousenum;
	private int temp = 0;
	private int score = 0;
	private int timeleft = 30;
	private int isstart;

	private JPanel mousepanel;

	private JButton start;
	private JButton back;

	private JButton mouse1;
	private JButton mouse2;
	private JButton mouse3;
	private JButton mouse4;
	private JButton mouse5;
	private JButton mouse6;
	
	
	private boolean mouse1up = false;
	private boolean mouse2up = false;
	private boolean mouse3up = false;
	private boolean mouse4up = false;
	private boolean mouse5up = false;
	private boolean mouse6up = false;

	private JLabel hitmousebg;
	private JLabel scoreboard;

	private ImageIcon startImg;
	private ImageIcon hitmousebgImg;
	private ImageIcon backImg;
	private ImageIcon mouseImg;

	private Games gamepanel;

	private AudioPlayer Sunday_Plans;
	
	private TimerTask cdt;
	private TimerTask hme;
	private Timer timer1;
	private Timer timer2;
	
	

	public Hitmouse(Board board) {
		this.board = board;
		this.setOpaque(false);
		this.setLayout(null);

		mousepanel = new JPanel();
		mousepanel.setBounds(0, 0, 1000, 700);
		mousepanel.setOpaque(false);
		mousepanel.setLayout(null);

		this.add(mousepanel, 0);

		rand = new Random();

		timer1 = new Timer();
		timer2 = new Timer();
		sethmbg();
		
		sethmbutton();

		
		board.add(this, 0);
	}

	public void sethmbutton() {
		
		
		startImg = new ImageIcon(
				Hitmouse.class.getResource("objects\\hmstart.jpg"));
		start = new JButton(startImg);
		start.setBounds(300, 265, 400, 153);
		start.addActionListener(this);
		this.add(start);

		backImg = new ImageIcon(Hitmouse.class.getResource("objects\\back.jpg"));
		back = new JButton(backImg);
		back.setBounds(870, 620, 70, 30);
		back.addActionListener(this);
		this.add(back);

		mouseImg = new ImageIcon(
				Hitmouse.class.getResource("objects\\mouse.png"));
	}

	public void setmouses() {

		scoreboard.setText("�o�� : " + score + " ~ " + "�l�Ѯɶ� : " + timeleft);

		if (mouse1up == true || mouse2up == true || mouse3up == true
				|| mouse4up == true || mouse5up == true || mouse6up == true) {
		} else {
			mousepanel.removeAll();
			mousepanel.revalidate();
			mousepanel.repaint();

			for (int i = 1; i <= 3; i++) {

				mousenum = rand.nextInt(6) + 1;
				if (mousenum != temp) {
					temp = mousenum;
					switch (mousenum) {
					case 1:
						mouse1 = new JButton(mouseImg);
						mouse1.setContentAreaFilled(false);
						mouse1.setBounds(100, 10, 200, 200);
						mouse1.addActionListener(this);
						mousepanel.add(mouse1);
						mouse1up = true;
						break;
					case 2:
						mouse2 = new JButton(mouseImg);
						mouse2.setContentAreaFilled(false);
						mouse2.setBounds(400, 10, 200, 200);
						mouse2.addActionListener(this);
						mousepanel.add(mouse2);
						mouse2up = true;
						break;
					case 3:
						mouse3 = new JButton(mouseImg);
						mouse3.setContentAreaFilled(false);
						mouse3.setBounds(700, 10, 200, 200);
						mouse3.addActionListener(this);
						mousepanel.add(mouse3);
						mouse3up = true;
						break;
					case 4:
						mouse4 = new JButton(mouseImg);
						mouse4.setContentAreaFilled(false);
						mouse4.setBounds(100, 350, 200, 200);
						mouse4.addActionListener(this);
						mousepanel.add(mouse4);
						mouse4up = true;
						break;
					case 5:
						mouse5 = new JButton(mouseImg);
						mouse5.setContentAreaFilled(false);
						mouse5.setBounds(400, 350, 200, 200);
						mouse5.addActionListener(this);
						mousepanel.add(mouse5);
						mouse5up = true;
						break;
					case 6:
						mouse6 = new JButton(mouseImg);
						mouse6.setContentAreaFilled(false);
						mouse6.setBounds(700, 350, 200, 200);
						mouse6.addActionListener(this);
						mousepanel.add(mouse6);
						mouse6up = true;
						break;
					}
				}
			}
		}

	}

	public void setscoreboard() {

		scoreboard = new JLabel("");
		scoreboard.setForeground(Color.RED);
		scoreboard.setBounds(300, 240, 500, 100);
		scoreboard.setFont(new Font(null, 1, 40));
		this.add(scoreboard, 0);

		cdt = new TimerTask(){
			public void run(){
				if(timeleft>0){
					scoreboard.setText("�o�� : " + score + " ~ " + "�l�Ѯɶ� : " + timeleft);
					timeleft--;
				}
			}
		};
		timer1.schedule(cdt, 0 ,1000);
		
		hme = new TimerTask(){
			public void run(){
				int end = JOptionPane.showConfirmDialog(null, "�ɶ���!!�O�_����?","Time's up!!!",JOptionPane.YES_NO_OPTION);
				if(end==JOptionPane.YES_OPTION){
					
				}else if(end==JOptionPane.NO_OPTION){
					back();
				}
			}
		};
		
		timer2.schedule(hme, 30000);
		
	}
	
	
	
	

	public void sethmbg() {

		board.changebg(5);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			gamestart();
			
		} else if (e.getSource() == back) {
			back();
			
		} else if (e.getSource() == mouse1) {
			score = score + 10;
			mouse1up = false;
			mousepanel.remove(mouse1);
			mouse1.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		} else if (e.getSource() == mouse2) {
			score = score + 10;
			mouse2up = false;
			mousepanel.remove(mouse2);
			mouse2.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		} else if (e.getSource() == mouse3) {
			score = score + 10;
			mouse3up = false;
			mousepanel.remove(mouse3);
			mouse3.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		} else if (e.getSource() == mouse4) {
			score = score + 10;
			mouse4up = false;
			mousepanel.remove(mouse4);
			mouse4.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		} else if (e.getSource() == mouse5) {
			score = score + 10;
			mouse5up = false;
			mousepanel.remove(mouse5);
			mouse5.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		} else if (e.getSource() == mouse6) {
			score = score + 10;
			mouse6up = false;
			mousepanel.remove(mouse6);
			mouse6.removeActionListener(this);
			mousepanel.revalidate();
			mousepanel.repaint();
			setmouses();
		}

	}

	public Board getBoard() {
		return board;
	}

	public void back() {
		timer1.cancel();
		timer2.cancel();
		
		
		this.removeAll();
		this.revalidate();
		this.repaint();

		gamepanel = new Games(board);
		gamepanel.setOpaque(false);
		gamepanel.setLayout(null);
		board.add(gamepanel, 0);
		board.changebg(board.currentbg);
		
		
		//board.stopMusic();
		//Sunday_Plans = board.getSunday_Plans();
		//Sunday_Plans.play();
		
	}

	public void gamestart() {
		this.remove(start);
		this.revalidate();
		this.repaint();

		setscoreboard();
		setmouses();

	}

}
