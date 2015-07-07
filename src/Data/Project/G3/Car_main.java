package Data.Project.G3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class Car_main extends JPanel implements ActionListener{
	
	private Board board;
	private Games gamepanel;
	private Random rand;
	
	private JLabel topic;
	private JLabel topoc1;
	
	private JButton stage1;
	private JButton stage2;
	private JButton stage3;
	private JButton stage4;
	private JButton stage5;
	private JButton stage6;
	private JButton stage7;
	private JButton stage8;
	private JButton stage9;
	private JButton stage10;
	private JButton stage11;
	private JButton stage12;
	private JButton stage13;
	private JButton stage14;
	private JButton stage15;
	private JButton back;
	
	private ImageIcon backImg;
	private Font font;
	
	public Car_main(Board board){
		this.board = board;
		this.setOpaque(false);
		this.setLayout(null);
		
		
		setPanel();
		
		board.add(this,0);
	}
	
	public void setPanel(){
		
		board.changebg(6);
		
		topic = new JLabel("�w��Ө�u�}�X�������v!!");
		topic.setForeground(Color.BLACK);
		topic.setBackground(Color.GRAY);
		topic.setOpaque(true);
		topic.setBounds(140,50,750,100);
		topic.setFont(new Font(null, 1, 60));
		this.add(topic);
		
		setButton();
		
	}
	
	
	public void setButton(){
		font = new Font(null,1,60);
		
		backImg = new ImageIcon(Car_main.class.getResource("objects\\back.jpg"));
		back = new JButton(backImg);
		back.setBounds(870,620,70,30);
		back.addActionListener(this);
		this.add(back);
		
		stage1 = new JButton("1");
		stage1.setBounds(150,200,100,100);
		stage1.addActionListener(this);
		stage1.setFont(font);
		if(board.clear1){
			stage1.setBackground(Color.green);
		}
		this.add(stage1);
		
		stage2 = new JButton("2");
		stage2.setBounds(300,200,100,100);
		stage2.addActionListener(this);
		stage2.setFont(font);
		if(board.clear2){
			stage2.setBackground(Color.green);
		}
		this.add(stage2);
		
		stage3 = new JButton("3");
		stage3.setBounds(450,200,100,100);
		stage3.addActionListener(this);
		stage3.setFont(font);
		if(board.clear3){
			stage3.setBackground(Color.green);
		}
		this.add(stage3);
		
		stage4 = new JButton("4");
		stage4.setBounds(600,200,100,100);
		stage4.addActionListener(this);
		stage4.setFont(font);
		if(board.clear4){
			stage4.setBackground(Color.green);
		}
		this.add(stage4);
		
		stage5 = new JButton("5");
		stage5.setBounds(750,200,100,100);
		stage5.addActionListener(this);
		stage5.setFont(font);
		if(board.clear5){
			stage5.setBackground(Color.green);
		}
		this.add(stage5);
		
		stage6 = new JButton("6");
		stage6.setBounds(150,350,100,100);
		stage6.addActionListener(this);
		stage6.setFont(font);
		if(board.clear6){
			stage6.setBackground(Color.green);
		}
		this.add(stage6);
		
		stage7 = new JButton("7");
		stage7.setBounds(300,350,100,100);
		stage7.addActionListener(this);
		stage7.setFont(font);
		if(board.clear7){
			stage7.setBackground(Color.green);
		}
		this.add(stage7);
		
		stage8 = new JButton("8");
		stage8.setBounds(450,350,100,100);
		stage8.addActionListener(this);
		stage8.setFont(font);
		if(board.clear8){
			stage8.setBackground(Color.green);
		}
		this.add(stage8);
		
		stage9 = new JButton("9");
		stage9.setBounds(600,350,100,100);
		stage9.addActionListener(this);
		stage9.setFont(font);
		if(board.clear9){
			stage9.setBackground(Color.green);
		}
		this.add(stage9);
		
		stage10 = new JButton("10");
		stage10.setBounds(750,350,100,100);
		stage10.addActionListener(this);
		stage10.setFont(font);
		if(board.clear10){
			stage10.setBackground(Color.green);
		}
		this.add(stage10);
		
		stage11 = new JButton("11");
		stage11.setBounds(150,500,100,100);
		stage11.addActionListener(this);
		stage11.setFont(font);
		if(board.clear11){
			stage11.setBackground(Color.green);
		}
		this.add(stage11);
		
		stage12 = new JButton("12");
		stage12.setBounds(300,500,100,100);
		stage12.addActionListener(this);
		stage12.setFont(font);
		if(board.clear12){
			stage12.setBackground(Color.green);
		}
		this.add(stage12);
		
		stage13 = new JButton("13");
		stage13.setBounds(450,500,100,100);
		stage13.addActionListener(this);
		stage13.setFont(font);
		if(board.clear13){
			stage13.setBackground(Color.green);
		}
		this.add(stage13);
		
		stage14 = new JButton("14");
		stage14.setBounds(600,500,100,100);
		stage14.addActionListener(this);
		stage14.setFont(font);
		if(board.clear14){
			stage14.setBackground(Color.green);
		}
		this.add(stage14);
		
		stage15 = new JButton("15");
		stage15.setBounds(750,500,100,100);
		stage15.addActionListener(this);
		stage15.setFont(font);
		if(board.clear15){
			stage15.setBackground(Color.green);
		}
		this.add(stage15);
	}
	
	public void back(){
		this.removeAll();
		this.revalidate();
		this.repaint();
		Random rand = new Random();
		
		gamepanel = new Games(board);
		gamepanel.setOpaque(false);
		gamepanel.setLayout(null);
		
		board.add(gamepanel, 0);
		board.changebg(board.currentbg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			back();
		}else if(e.getSource() == stage1){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage1 = new Stages(1,board);
		}else if(e.getSource() == stage2){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage2 = new Stages(2,board);
		}else if(e.getSource() == stage3){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage3 = new Stages(3,board);
		}else if(e.getSource() == stage4){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage4 = new Stages(4,board);
		}else if(e.getSource() == stage5){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage5 = new Stages(5,board);
		}else if(e.getSource() == stage6){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage6 = new Stages(6,board);
		}else if(e.getSource() == stage7){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage7 = new Stages(7,board);
		}else if(e.getSource() == stage8){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage8 = new Stages(8,board);
		}else if(e.getSource() == stage9){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage9 = new Stages(9,board);
		}else if(e.getSource() == stage10){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage10 = new Stages(10,board);
		}else if(e.getSource() == stage11){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage11 = new Stages(11,board);
		}else if(e.getSource() == stage12){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage12 = new Stages(12,board);
		}else if(e.getSource() == stage13){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage13 = new Stages(13,board);
		}else if(e.getSource() == stage14){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage14 = new Stages(14,board);
		}else if(e.getSource() == stage15){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Stages stage15 = new Stages(15,board);
		}
		
	};
}
