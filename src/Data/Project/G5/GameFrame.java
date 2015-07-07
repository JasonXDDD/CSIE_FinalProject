package Data.Project.G5;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame implements ActionListener , KeyListener{
	
	CardLayout card;
	
	private volatile int check;
	
	int height,width;
	
	int count;
	
	Memory memory[] = new Memory[50];
	
	MenuPanel menuPanel;
	SecondPanel secondPanel;
	GamePanel gamePanel;
	RankPanel rankPanel;
	
	JPanel mainPanel;
	private JPanel buttonPanel;
	
	JButton ctl,exit,rank,back;
	
	public GameFrame(int height,int width){
		super ("--- Tempo Game ---");
		
		this.height = height;
		this.width = width;
		
		card = new CardLayout();
		
		mainPanel = new JPanel ();
		
		mainPanel.setLayout(card);
		
		memory[0] = new Memory();
		
		menuPanel = new MenuPanel(memory[count]);
		secondPanel = new SecondPanel(memory[count]);
		gamePanel = new GamePanel(memory[count]);
		rankPanel = new RankPanel(memory,count);
		
		mainPanel.add(menuPanel , "one");
		mainPanel.add(secondPanel , "two");
		mainPanel.add(gamePanel , "three");
		mainPanel.add(rankPanel , "four");
		
		buttonPanel = new JPanel();
		
		ctl = new JButton ("- Play -");
		ctl.addActionListener(this);
				
		exit = new JButton ("- Exit -");
		exit.addActionListener(this);
		
		rank = new JButton ("- Rank -");
		rank.addActionListener(this);
		
		back = new JButton ("- Back -");
		back.addActionListener(this);
		
		buttonPanel.add(ctl);
		buttonPanel.add(rank);
		buttonPanel.add(exit);
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(width/2-50, height/2-50, 80, 100);
		
		gamePanel.setFocusable(true);
		gamePanel.addKeyListener(this);
		
		add (buttonPanel);
		add (mainPanel);
		
		System.out.println (count);
	}
	
	public void menu (){
		if (check == 0){
			buttonPanel.removeAll();
			buttonPanel.setBounds(width-200, height-80, 200, 50);
			card.next(mainPanel);
			ctl.setText("- Play -");
			buttonPanel.add(back);
			buttonPanel.add(ctl);
			menuPanel.savename();
			check = 1;
			secondPanel.musiclist.clearSelection();
			gamePanel.setSecond (0);
		}
		else if (check == 1)	{
			if (memory[count].getSong() == null){
				Container con = getContentPane();
				
				String title = "--Warning--";
				String message = "Please Choice a Music Before Playing!";
				int type = JOptionPane.WARNING_MESSAGE;
				
				JOptionPane.showMessageDialog(con, message, title, type);
			}
			else {
				card.next(mainPanel);
				secondPanel.clip.stop();
				buttonPanel.removeAll();
				buttonPanel.setBounds(width-200, height-80, 190, 50);
				ctl.setText("- Stop -");
				buttonPanel.add(ctl);
				buttonPanel.add(exit);
				check = 2;
				gamePanel.playmusic();
				gamePanel.setRun(true);
			}
		}
		else if (check == 2 ){
			ctl.setText("- Resume -");
			gamePanel.clip.stop();
			gamePanel.setRun(false);
			check = 3;
		}
		else if (check == 3){
			ctl.setText("- Stop -");
			gamePanel.clip.start();
			gamePanel.setRun(true);
			check = 2;
		}
	}
	
	public void changePanel (){
		card.next(mainPanel);
		buttonPanel.removeAll();
		ctl.setText("- Play -");
		buttonPanel.add(ctl);
		buttonPanel.add(rank);
		buttonPanel.add(exit);
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(width/2-50, height/2-50, 80, 100);
		count++;
		memory[count] = new Memory();
		menuPanel.setMemory(memory[count]);
		secondPanel.setMemory(memory[count]);
		gamePanel.setMemory(memory[count]);
		rankPanel.setMemory(memory,count);
		check = 0 ;
		System.out.println (count+" "+memory[count-1].name+" "+memory[count-1].song+" "+memory[count-1].score);
	}
	
	public void exitPerform (){
		if (check == 4){
			this.changePanel();
		}
		else if (check == 0){
			this.dispose();
		}
		else {
			card.next(mainPanel);
			rankPanel.updateUI();
			buttonPanel.removeAll();
			buttonPanel.add(exit);
			gamePanel.clip.stop();
			gamePanel.setRun(false);
			check = 4;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
    	case KeyEvent.VK_LEFT:
    		System.out.println ("left");
    		gamePanel.keyctl(1);
    		break;
    	case KeyEvent.VK_DOWN:
    		System.out.println ("down");
    		gamePanel.keyctl(2);
    		break;
    	case KeyEvent.VK_UP:
    		System.out.println ("UP");
    		gamePanel.keyctl(3);
    		break;
    	case KeyEvent.VK_RIGHT:
    		System.out.println ("right");
    		gamePanel.keyctl(4);
    		break;
    	case KeyEvent.VK_A:
    		System.out.println ("left");
    		gamePanel.keyctl(1);
    		break;
    	case KeyEvent.VK_S:
    		System.out.println ("down");
    		gamePanel.keyctl(2);
    		break;
    	case KeyEvent.VK_W:
    		System.out.println ("UP");
    		gamePanel.keyctl(3);
    		break;
    	case KeyEvent.VK_D:
    		System.out.println ("right");
    		gamePanel.keyctl(4);
    		break;
        }
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
    	case KeyEvent.VK_LEFT:
    		System.out.println ("left");
    		gamePanel.keyctl(5);
    		break;
    	case KeyEvent.VK_DOWN:
    		System.out.println ("down");
    		gamePanel.keyctl(6);
    		break;
    	case KeyEvent.VK_UP:
    		System.out.println ("UP");
    		gamePanel.keyctl(7);
    		break;
    	case KeyEvent.VK_RIGHT:
    		System.out.println ("right");
    		gamePanel.keyctl(8);
    		break;
    	case KeyEvent.VK_A:
    		System.out.println ("left");
    		gamePanel.keyctl(5);
    		break;
    	case KeyEvent.VK_S:
    		System.out.println ("down");
    		gamePanel.keyctl(6);
    		break;
    	case KeyEvent.VK_W:
    		System.out.println ("UP");
    		gamePanel.keyctl(7);
    		break;
    	case KeyEvent.VK_D:
    		System.out.println ("right");
    		gamePanel.keyctl(8);
    		break;
        }
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ctl){
			this.menu();
		}
		else if (e.getSource() == exit){
			exitPerform();
		}
		else if (e.getSource() == rank){
			if (count!=0){
				card.show(mainPanel, "four");
				rankPanel.setMemory(memory,count-1);
				buttonPanel.removeAll();
				buttonPanel.setBounds(width-200, height-80, 190, 50);
				buttonPanel.add(exit);
				check = 4;
				count--;
			}
		}
		else if (e.getSource() == back){
			if (secondPanel.clip != null){
				secondPanel.clip.stop();
				System.out.printf ("test");
			}
			check = 0;
			card.previous(mainPanel);
			buttonPanel.removeAll();
			ctl.setText("- Play -");
			buttonPanel.add(ctl);
			buttonPanel.add(rank);
			buttonPanel.add(exit);
			buttonPanel.setOpaque(false);
			buttonPanel.setBounds(width/2-50, height/2-50, 80, 100);
		}
	}
	
}
