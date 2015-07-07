package Data.Project.G3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Games extends JPanel implements ActionListener{
	private Board board;
	private Menu menupanel;
	
	private JLabel choosetitle;
		
	private ImageIcon choosetitleImg;
	
	private JButton game1;
	private JButton game2;
	private JButton game3;
	private JButton game4;
	
	private JButton back;
	
	private ImageIcon game1Img;
	private ImageIcon game2Img;
	private ImageIcon game3Img;
	private ImageIcon game4Img;
	
	private ImageIcon backImg;
	
	public Games(Board board){
		this.board = board;
		
		choosetitleImg = new ImageIcon(Games.class.getResource("objects\\choosetitle.png"));
		choosetitle = new JLabel(choosetitleImg);
		choosetitle.setBounds(100, 15, 800, 177);
		this.add(choosetitle);
		
		game1Img = new ImageIcon(Games.class.getResource("objects\\guess.jpg"));
		game1 = new JButton(game1Img);
		game1.setBounds(150,450,200,200);
		game1.addActionListener(this);
		this.add(game1);
		
		game2Img = new ImageIcon(Games.class.getResource("objects\\maze.jpeg"));
		game2 = new JButton(game2Img);
		game2.setBounds(400,450,200,200);
		game2.addActionListener(this);
		this.add(game2);
		
		game3Img = new ImageIcon(Games.class.getResource("objects\\hitmouse.png"));
		game3 = new JButton(game3Img);
		game3.setContentAreaFilled(false);
		game3.setBounds(650,450,200,200);
		game3.addActionListener(this);
		this.add(game3);
		
		
		game4Img = new ImageIcon(Games.class.getResource("objects\\car.png"));
		game4 = new JButton(game4Img);
		game4.setBounds(400,225,200,200);
		game4.addActionListener(this);
		this.add(game4);
		
		backImg = new ImageIcon(Games.class.getResource("objects\\back.jpg"));
		back = new JButton(backImg);
		back.setBounds(870,620,70,30);
		back.addActionListener(this);
		this.add(back);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==game1){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Guess guess = new Guess(board);
			
		}else if(e.getSource()==game2){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Maze maze = new Maze(board);
			
		}else if(e.getSource()==game3){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Hitmouse hitmouse = new Hitmouse(board);
			
		}else if(e.getSource()==game4){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			Car_main carmainpanel = new Car_main(board);
			
		}else if(e.getSource()==back){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			setMenu();
			
		}
		
	}


	private void setMenu() {
		menupanel = new Menu(board);
		menupanel.setOpaque(false);
		menupanel.setLayout(null);
		
		board.add(menupanel,0);
		
	}
	
	
}
