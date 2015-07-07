package Data.Project.G3;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Maze extends JPanel implements ActionListener, MouseMotionListener {

	private Board board;

	private Games gamepanel;
	private Robot mousecontrol;

	private JButton startblock;
	private JLabel startblocka;
	private JLabel b1;
	private JLabel b2;
	private JLabel b3;
	private JLabel b4;
	private JLabel b5;
	private JLabel b6;
	private JLabel b7;
	private JLabel b8;
	private JLabel b9;
	private JLabel b10;
	private JLabel b11;
	private JLabel b12;
	private JLabel b13;
	private JLabel b14;
	private JLabel b15;
	private JLabel b16;
	private JLabel b17;
	private JLabel endblock;
	private JLabel door;
	private JLabel key;
	private JLabel joke;
	private boolean dooropen = false;
	private boolean joked = false;

	private ImageIcon startblockImg;

	private ImageIcon b1Img;
	private ImageIcon b2Img;
	private ImageIcon b3Img;
	private ImageIcon b8Img;
	private ImageIcon b9Img;
	private ImageIcon b10Img;
	private ImageIcon bsImg;
	private ImageIcon doorImg;
	private ImageIcon keyImg;
	private ImageIcon endblockImg;
	private ImageIcon jokeImg;

	private int mx, my;
	private int again;

	private AudioPlayer Sunday_Plans;

	private AudioPlayer Sioux_Falls;

	public Maze(Board board) {
		this.board = board;
		this.setOpaque(false);
		this.setLayout(null);
		
		board.changebg(7);
		setStart();

		board.add(this, 0);
	}

	public void setStart() {
		startblock = new JButton();
		startblockImg = new ImageIcon(
				Maze.class.getResource("objects\\startblock.png"));
		startblock = new JButton(startblockImg);
		startblock.setBounds(0, 0, 75, 75);
		startblock.setContentAreaFilled(false);
		startblock.addActionListener(this);
		this.add(startblock);

	}

	public void setMap() {

		startblockImg = new ImageIcon(
				Maze.class.getResource("objects\\startblock.png"));
		startblocka = new JLabel(startblockImg);
		startblocka.setBounds(0, 0, 75, 75);

		this.add(startblocka);

		b1Img = new ImageIcon(Maze.class.getResource("objects\\block1.jpg"));
		b1 = new JLabel(b1Img);
		b1.setBounds(0, 75, 500, 100);
		this.add(b1);

		b2Img = new ImageIcon(Maze.class.getResource("objects\\block2.jpg"));
		b2 = new JLabel(b2Img);
		b2.setBounds(575, 0, 100, 350);
		this.add(b2);

		b3Img = new ImageIcon(Maze.class.getResource("objects\\block3.jpg"));
		b3 = new JLabel(b3Img);
		b3.setBounds(75, 250, 575, 100);
		this.add(b3);

		bsImg = new ImageIcon(Maze.class.getResource("objects\\blocksmall.jpg"));
		b4 = new JLabel(bsImg);
		b4.setBounds(25, 250, 100, 15);
		this.add(b4);

		b5 = new JLabel(bsImg);
		b5.setBounds(0, 280, 100, 15);
		this.add(b5);

		b6 = new JLabel(bsImg);
		b6.setBounds(25, 310, 100, 15);
		this.add(b6);

		b7 = new JLabel(bsImg);
		b7.setBounds(0, 340, 100, 15);
		this.add(b7);

		b8Img = new ImageIcon(Maze.class.getResource("objects\\block8.jpg"));
		b8 = new JLabel(b8Img);
		b8.setBounds(60, 400, 615, 100);
		this.add(b8);

		b9Img = new ImageIcon(Maze.class.getResource("objects\\block8.jpg"));
		b9 = new JLabel(b9Img);
		b9.setBounds(0, 550, 650, 85);
		this.add(b9);

		doorImg = new ImageIcon(Maze.class.getResource("objects\\door.jpg"));
		door = new JLabel(doorImg);
		door.setBounds(625, 350, 50, 50);
		this.add(door);

		keyImg = new ImageIcon(Maze.class.getResource("objects\\key.png"));
		key = new JLabel(keyImg);
		key.setBounds(0, 635, 113, 45);
		this.add(key);

		b10Img = new ImageIcon(Maze.class.getResource("objects\\xxx.jpg"));
		b10 = new JLabel(b10Img);
		b10.setBounds(675, 400, 100, 300);
		this.add(b10);

		b11 = new JLabel(b10Img);
		b11.setBounds(725, 100, 100, 300);
		this.add(b11);

		b12 = new JLabel(b10Img);
		b12.setBounds(675, 0, 325, 50);
		this.add(b12);

		b13 = new JLabel(b10Img);
		b13.setBounds(865, 50, 25, 300);
		this.add(b13);

		b14 = new JLabel(b10Img);
		b14.setBounds(825, 375, 125, 25);
		this.add(b14);

		b15 = new JLabel(b10Img);
		b15.setBounds(925, 75, 25, 300);
		this.add(b15);

		b16 = new JLabel(b10Img);
		b16.setBounds(925, 400, 25, 250);
		this.add(b16);

		b17 = new JLabel(b10Img);
		b17.setBounds(850, 450, 25, 250);
		this.add(b17);

		endblockImg = new ImageIcon(
				Maze.class.getResource("objects\\endblock.png"));
		endblock = new JLabel(endblockImg);
		endblock.setBounds(775, 600, 75, 75);
		this.add(endblock);
	}

	public void failed() {
		again = JOptionPane.showConfirmDialog(null, "?A??F?I?b??@???H", "Warning",
				JOptionPane.YES_NO_OPTION);

		dooropen = false;
		joked = false;
		if (again == JOptionPane.YES_OPTION) {
			this.removeAll();
			this.revalidate();
			this.repaint();
			removeMouseMotionListener(this);

			setStart();

		} else if (again == JOptionPane.NO_OPTION) {
			back();
		}
	}

	public void cleared() {
		again = JOptionPane.showConfirmDialog(null, "你成功了！在玩一次？",
				"Congratulations!!!", JOptionPane.YES_NO_OPTION);

		if (again == JOptionPane.YES_OPTION) {
			this.removeAll();
			this.revalidate();
			this.repaint();
			removeMouseMotionListener(this);

			setStart();

		} else if (again == JOptionPane.NO_OPTION) {
			back();
		}
	}

	public void back() {
		this.removeAll();
		this.revalidate();
		this.repaint();
		removeMouseMotionListener(this);
		
		board.changebg(board.currentbg);
		gamepanel = new Games(board);
		gamepanel.setOpaque(false);
		gamepanel.setLayout(null);

		board.stopMusic();
		Sunday_Plans = board.getSunday_Plans();
		Sunday_Plans.play();

		board.add(gamepanel, 0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startblock) {
			addMouseMotionListener(this);
			this.remove(startblock);
			this.revalidate();
			this.repaint();
			setMap();
		}
	}

	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		if (mx == 0 || my == 0 || mx == 993 || my == 670) {
			failed();
		} else if (mx >= 0 && my >= 75 && mx <= 500 && my <= 175) {
			failed();
		} else if (mx >= 575 && my >= 0 && mx <= 675 && my <= 350) {
			failed();
		} else if (mx >= 125 && my >= 250 && mx <= 575 && my <= 350) {
			failed();
		} else if (mx >= 25 && my >= 250 && mx <= 125 && my <= 265) {
			failed();
		} else if (mx >= 0 && my >= 280 && mx <= 100 && my <= 295) {
			failed();
		} else if (mx >= 25 && my >= 310 && mx <= 125 && my <= 325) {
			failed();
		} else if (mx >= 0 && my >= 340 && mx <= 100 && my <= 355) {
			failed();
		} else if (mx >= 60 && my >= 400 && mx <= 675 && my <= 500) {
			failed();
		} else if (mx >= 0 && my >= 550 && mx <= 650 && my <= 635) {
			failed();
		} else if (mx >= 625 && my >= 350 && mx <= 675 && my <= 400) {
			if (dooropen == false) {
				failed();
			} else if (dooropen = true) {
				this.remove(door);
				this.revalidate();
				this.repaint();
			}
		} else if (mx >= 0 && my >= 645 && mx <= 113 && my <= 700) {
			this.remove(key);
			this.revalidate();
			this.repaint();
			dooropen = true;
		} else if (mx >= 675 && my >= 400 && mx <= 775 && my <= 700) {
			failed();
		} else if (mx >= 725 && my >= 100 && mx <= 825 && my <= 400) {
			failed();
		} else if (mx >= 675 && my >= 0 && mx <= 1000 && my <= 50) {
			failed();
		} else if (mx >= 865 && my >= 50 && mx <= 890 && my <= 350) {
			failed();
		} else if (mx >= 825 && my >= 375 && mx <= 950 && my <= 400) {
			failed();
		} else if (mx >= 925 && my >= 75 && mx <= 950 && my <= 375) {
			failed();
		} else if (mx >= 925 && my >= 400 && mx <= 950 && my <= 650) {
			failed();
		} else if (mx >= 850 && my >= 450 && mx <= 875 && my <= 700) {
			failed();
		} else if (mx >= 775 && my >= 600 && mx <= 850 && my <= 675) {
			this.remove(endblock);
			this.remove(startblocka);
			this.revalidate();
			this.repaint();

			board.stopMusic();
			Sioux_Falls = board.getSioux_Falls();
			Sioux_Falls.play();

			jokeImg = new ImageIcon(Maze.class.getResource("objects\\joke.jpg"));
			joke = new JLabel(jokeImg);
			joke.setBounds(775, 600, 75, 75);
			this.add(joke);

			endblockImg = new ImageIcon(
					Maze.class.getResource("objects\\endblock.png"));
			endblock = new JLabel(endblockImg);
			endblock.setBounds(0, 0, 75, 75);
			this.add(endblock);

			joked = true;

		} else if (joked == true) {
			if (mx >= 0 && my >= 0 && mx <= 75 && my <= 75) {
				cleared();
			}
		}
	}

	public void mouseDragged(MouseEvent e) {

	}
}
