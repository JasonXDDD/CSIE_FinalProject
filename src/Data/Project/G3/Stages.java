package Data.Project.G3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Stages extends JPanel implements KeyListener, ActionListener {
	private int stagenum;
	private Board board;
	private int numcar;

	private JLabel ground;
	private JLabel wall_left;
	private JLabel wall_right;
	private JLabel wall_top;
	private JLabel wall_bottom;
	private JLabel endzone;

	private Rectangle left;
	private Rectangle right;
	private Rectangle top;
	private Rectangle bottom;
	private Rectangle end;

	private ImageIcon maincar;
	private ImageIcon car1a;
	private ImageIcon car1b;
	private ImageIcon car2a;
	private ImageIcon car2b;
	private ImageIcon car3a;
	private ImageIcon car3b;
	private ImageIcon car4a;
	private ImageIcon car4b;
	private ImageIcon car5a;
	private ImageIcon car5b;
	private ImageIcon resetImg;
	private ImageIcon backImg;

	private CARS cars[];
	private JButton reset;
	private JButton back;

	public Stages(int stagenum, Board board) {
		this.board = board;
		this.stagenum = stagenum;
		this.setOpaque(false);
		this.setLayout(null);

		setstageboard();
		setCars();

		board.add(this, 0);

	}

	public void setstageboard() {
		left = new Rectangle(265, 50, 10, 470);
		right = new Rectangle(725, 50, 10, 470);
		top = new Rectangle(265, 50, 470, 10);
		bottom = new Rectangle(265, 510, 470, 10);
		end = new Rectangle(725, 210, 150, 75);

		maincar = new ImageIcon(
				Stages.class.getResource("objects\\maincar.png"));
		car1a = new ImageIcon(Stages.class.getResource("objects\\car1a.png"));
		car1b = new ImageIcon(Stages.class.getResource("objects\\car1b.png"));
		car2a = new ImageIcon(Stages.class.getResource("objects\\car2a.png"));
		car2b = new ImageIcon(Stages.class.getResource("objects\\car2b.png"));
		car3a = new ImageIcon(Stages.class.getResource("objects\\car3a.png"));
		car3b = new ImageIcon(Stages.class.getResource("objects\\car3b.png"));
		car4a = new ImageIcon(Stages.class.getResource("objects\\car4a.png"));
		car4b = new ImageIcon(Stages.class.getResource("objects\\car4b.png"));
		car5a = new ImageIcon(Stages.class.getResource("objects\\car5a.png"));
		car5b = new ImageIcon(Stages.class.getResource("objects\\car5b.png"));

		endzone = new JLabel("         出口");
		endzone.setOpaque(true);
		endzone.setForeground(Color.RED);
		endzone.setFont(new Font(null, 1, 32));
		endzone.setBackground(Color.YELLOW);
		endzone.setBounds(650, 210, 150, 75);
		this.add(endzone);

		ground = new JLabel();
		ground.setOpaque(true);
		ground.setBackground(Color.GRAY);
		ground.setBounds(275, 60, 450, 450);
		this.add(ground);

		wall_left = new JLabel();
		wall_left.setOpaque(true);
		wall_left.setBackground(Color.BLUE);
		wall_left.setBounds(left);
		this.add(wall_left);

		wall_right = new JLabel();
		wall_right.setOpaque(true);
		wall_right.setBackground(Color.BLUE);
		wall_right.setBounds(right);
		this.add(wall_right);

		wall_top = new JLabel();
		wall_top.setOpaque(true);
		wall_top.setBackground(Color.BLUE);
		wall_top.setBounds(top);
		this.add(wall_top);

		wall_bottom = new JLabel();
		wall_bottom.setOpaque(true);
		wall_bottom.setBackground(Color.BLUE);
		wall_bottom.setBounds(bottom);
		this.add(wall_bottom);

		backImg = new ImageIcon(Stages.class.getResource("objects\\back.jpg"));
		back = new JButton(backImg);
		back.setBounds(870, 620, 70, 30);
		back.addActionListener(this);
		this.add(back);

		resetImg = new ImageIcon(Stages.class.getResource("objects\\reset.png"));
		reset = new JButton(resetImg);
		reset.setContentAreaFilled(false);
		reset.setBounds(450, 550, 100, 100);
		reset.addActionListener(this);
		this.add(reset);
	}

	public void setCleared() {
		switch (stagenum) {
		case 1:
			board.clear1 = true;
			break;
		case 2:
			board.clear2 = true;
			break;
		case 3:
			board.clear3 = true;
			break;
		case 4:
			board.clear4 = true;
			break;
		case 5:
			board.clear5 = true;
			break;
		case 6:
			board.clear6 = true;
			break;
		case 7:
			board.clear7 = true;
			break;
		case 8:
			board.clear8 = true;
			break;
		case 9:
			board.clear9 = true;
			break;
		case 10:
			board.clear10 = true;
			break;
		case 11:
			board.clear11 = true;
			break;
		case 12:
			board.clear12 = true;
			break;
		case 13:
			board.clear13 = true;
			break;
		case 14:
			board.clear14 = true;
			break;
		case 15:
			board.clear15 = true;
			break;
		}
	}

	public void setCars() {
		cars = new CARS[15];

		switch (stagenum) {
		case 1:
			stage1();
			break;
		case 2:
			stage2();
			break;
		case 3:
			stage3();
			break;
		case 4:
			stage4();
			break;
		case 5:
			stage5();
			break;
		case 6:
			stage6();
			break;
		case 7:
			stage7();
			break;
		case 8:
			stage8();
			break;
		case 9:
			stage9();
			break;
		case 10:
			stage10();
			break;
		case 11:
			stage11();
			break;
		case 12:
			stage12();
			break;
		case 13:
			stage13();
			break;
		case 14:
			stage14();
			break;
		case 15:
			stage15();
			break;
		}
	}

	public void stage1() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car5a, 275, 60, 225, 75, this, false);
		cars[2] = new CARS(2, car5b, 425, 135, 75, 225, this, true);
		cars[3] = new CARS(3, car2a, 275, 285, 75, 150, this, true);
		cars[4] = new CARS(4, car5a, 275, 435, 225, 75, this, false);
		cars[5] = new CARS(5, car5b, 650, 60, 75, 225, this, true);
		cars[6] = new CARS(6, car4b, 575, 285, 150, 75, this, false);
		cars[7] = new CARS(7, car3a, 575, 360, 75, 150, this, true);
		numcar = 7;
	}

	public void stage2() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3a, 425, 135, 75, 150, this, true);
		cars[2] = new CARS(2, car5b, 500, 135, 75, 225, this, true);
		cars[3] = new CARS(3, car5b, 575, 135, 75, 225, this, true);
		cars[4] = new CARS(4, car4b, 275, 285, 150, 75, this, false);
		cars[5] = new CARS(5, car2a, 425, 285, 75, 150, this, true);
		cars[6] = new CARS(6, car1a, 350, 360, 75, 150, this, true);
		cars[7] = new CARS(7, car3b, 425, 435, 150, 75, this, false);
		numcar = 7;
	}

	public void stage3() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3a, 275, 60, 75, 150, this, true);
		cars[2] = new CARS(2, car2b, 350, 60, 150, 75, this, false);
		cars[3] = new CARS(3, car2b, 500, 60, 150, 75, this, false);
		cars[4] = new CARS(4, car4a, 425, 135, 75, 150, this, true);
		cars[5] = new CARS(5, car5b, 500, 210, 75, 225, this, true);
		cars[6] = new CARS(6, car5b, 575, 210, 75, 225, this, true);
		cars[7] = new CARS(7, car5a, 275, 360, 225, 75, this, false);
		numcar = 7;
	}

	public void stage4() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3b, 275, 285, 150, 75, this, false);
		cars[2] = new CARS(2, car4a, 650, 135, 75, 150, this, true);
		cars[3] = new CARS(3, car2b, 425, 360, 150, 75, this, false);
		cars[4] = new CARS(4, car4b, 425, 435, 150, 75, this, false);
		cars[5] = new CARS(5, car1a, 350, 360, 75, 150, this, true);
		cars[6] = new CARS(6, car5b, 500, 135, 75, 225, this, true);
		cars[7] = new CARS(7, car5b, 575, 135, 75, 225, this, true);

		numcar = 7;
	}

	public void stage5() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car5a, 650, 135, 75, 225, this, false);
		cars[2] = new CARS(2, car1a, 350, 285, 75, 150, this, true);
		cars[3] = new CARS(3, car3b, 425, 360, 150, 75, this, false);
		cars[4] = new CARS(4, car4b, 575, 60, 150, 75, this, false);
		cars[5] = new CARS(5, car2a, 575, 360, 75, 150, this, true);
		cars[6] = new CARS(6, car5b, 650, 135, 75, 225, this, true);
		cars[7] = new CARS(7, car5b, 425, 60, 75, 225, this, true);

		numcar = 7;
	}

	public void stage6() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car4a, 350, 285, 75, 150, this, true);
		cars[2] = new CARS(2, car2a, 575, 135, 75, 150, this, true);
		cars[3] = new CARS(3, car1a, 575, 285, 75, 150, this, true);
		cars[4] = new CARS(4, car1b, 425, 360, 150, 75, this, false);
		cars[5] = new CARS(5, car3b, 575, 60, 150, 75, this, false);
		cars[6] = new CARS(6, car5b, 425, 60, 75, 225, this, true);
		cars[7] = new CARS(7, car5b, 500, 60, 75, 225, this, true);

		numcar = 7;
	}

	public void stage7() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car1a, 275, 60, 75, 150, this, true);
		cars[2] = new CARS(2, car2a, 500, 60, 75, 150, this, true);
		cars[3] = new CARS(3, car3a, 500, 210, 75, 150, this, true);
		cars[4] = new CARS(4, car5a, 275, 285, 225, 75, this, false);
		cars[5] = new CARS(5, car4a, 350, 360, 75, 150, this, true);
		cars[6] = new CARS(6, car1b, 425, 360, 150, 75, this, false);
		cars[7] = new CARS(7, car2b, 425, 435, 150, 75, this, false);
		cars[8] = new CARS(8, car5b, 650, 210, 75, 225, this, true);
		numcar = 8;
	}

	public void stage8() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car5a, 350, 135, 225, 75, this, false);
		cars[2] = new CARS(2, car5a, 275, 360, 225, 75, this, false);
		cars[3] = new CARS(3, car5b, 500, 210, 75, 225, this, true);
		cars[4] = new CARS(4, car1a, 425, 210, 75, 150, this, true);
		cars[5] = new CARS(5, car2a, 650, 135, 75, 150, this, true);
		cars[6] = new CARS(6, car3a, 650, 360, 75, 150, this, true);
		cars[7] = new CARS(7, car1b, 575, 285, 150, 75, this, false);
		numcar = 7;
	}

	public void stage9() {
		cars[0] = new CARS(0, maincar, 350, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car5a, 275, 60, 225, 75, this, false);
		cars[2] = new CARS(2, car5a, 275, 435, 225, 75, this, false);
		cars[3] = new CARS(3, car5b, 275, 135, 75, 225, this, true);
		cars[4] = new CARS(4, car5b, 500, 60, 75, 225, this, true);
		cars[5] = new CARS(5, car5b, 650, 210, 75, 225, this, true);
		cars[6] = new CARS(6, car1a, 425, 285, 75, 150, this, true);
		cars[7] = new CARS(7, car2a, 575, 360, 75, 150, this, true);
		cars[8] = new CARS(8, car1b, 350, 135, 150, 75, this, false);
		cars[9] = new CARS(9, car2b, 575, 135, 150, 75, this, false);
		cars[10] = new CARS(10, car3b, 500, 285, 150, 75, this, false);
		numcar = 10;
	}

	public void stage10() {
		cars[0] = new CARS(0, maincar, 425, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car2a, 275, 60, 75, 150, this, true);
		cars[2] = new CARS(2, car5a, 350, 60, 225, 75, this, false);
		cars[3] = new CARS(3, car5a, 350, 135, 225, 75, this, false);
		cars[4] = new CARS(4, car5b, 350, 210, 75, 225, this, true);
		cars[5] = new CARS(5, car3b, 425, 285, 150, 75, this, false);
		cars[6] = new CARS(6, car5b, 575, 135, 75, 225, this, true);
		cars[7] = new CARS(7, car3b, 575, 360, 150, 75, this, false);
		cars[8] = new CARS(8, car4a, 500, 360, 75, 150, this, true);
		cars[9] = new CARS(9, car5a, 275, 435, 225, 75, this, false);
		numcar = 9;
	}

	public void stage11() {
		cars[0] = new CARS(0, maincar, 350, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car4a, 275, 135, 75, 150, this, true);
		cars[2] = new CARS(2, car2a, 500, 135, 75, 150, this, true);
		cars[3] = new CARS(3, car5b, 575, 135, 75, 225, this, true);
		cars[4] = new CARS(4, car1a, 650, 135, 75, 150, this, true);
		cars[5] = new CARS(5, car3b, 275, 285, 150, 75, this, false);
		cars[6] = new CARS(6, car2b, 425, 285, 150, 75, this, false);
		cars[7] = new CARS(7, car3a, 350, 360, 75, 150, this, true);
		cars[8] = new CARS(8, car4a, 425, 360, 75, 150, this, true);
		cars[9] = new CARS(9, car5a, 500, 360, 225, 75, this, false);
		cars[10] = new CARS(10, car1b, 500, 435, 150, 75, this, false);
		numcar = 10;

	}

	public void stage12() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car2a, 275, 60, 75, 150, this, true);
		cars[2] = new CARS(2, car3b, 425, 60, 150, 75, this, false);
		cars[3] = new CARS(3, car5a, 350, 135, 225, 75, this, false);
		cars[4] = new CARS(4, car2a, 575, 135, 75, 150, this, true);
		cars[5] = new CARS(5, car1a, 650, 135, 75, 150, this, true);
		cars[6] = new CARS(6, car5b, 500, 210, 75, 225, this, true);
		cars[7] = new CARS(7, car3a, 575, 285, 75, 150, this, true);
		cars[8] = new CARS(8, car4a, 650, 285, 75, 150, this, true);
		cars[9] = new CARS(9, car3a, 350, 360, 75, 150, this, true);
		cars[10] = new CARS(10, car5a, 425, 435, 225, 75, this, false);
		cars[11] = new CARS(11, car1b, 275, 285, 150, 75, this, false);
		numcar = 11;
	}

	public void stage13() {
		cars[0] = new CARS(0, maincar, 425, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3b, 350, 60, 150, 75, this, false);
		cars[2] = new CARS(2, car1b, 350, 135, 150, 75, this, false);
		cars[3] = new CARS(3, car4b, 425, 285, 150, 75, this, false);
		cars[4] = new CARS(4, car3b, 275, 435, 150, 75, this, false);
		cars[5] = new CARS(5, car2b, 500, 435, 150, 75, this, false);
		cars[6] = new CARS(6, car5b, 350, 210, 75, 225, this, true);
		cars[7] = new CARS(7, car4a, 425, 360, 75, 150, this, true);
		cars[8] = new CARS(8, car2a, 500, 60, 75, 150, this, true);
		cars[9] = new CARS(9, car5b, 575, 135, 75, 225, this, true);
		cars[10] = new CARS(10, car1a, 650, 285, 75, 150, this, true);
		numcar = 10;
	}

	public void stage14() {
		cars[0] = new CARS(0, maincar, 350, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3b, 275, 60, 150, 75, this, false);
		cars[2] = new CARS(2, car1b, 500, 135, 150, 75, this, false);
		cars[3] = new CARS(3, car4b, 275, 285, 150, 75, this, false);
		cars[4] = new CARS(4, car3b, 275, 360, 150, 75, this, false);
		cars[5] = new CARS(5, car2b, 275, 435, 150, 75, this, false);
		cars[6] = new CARS(6, car2b, 425, 435, 150, 75, this, false);
		cars[7] = new CARS(7, car4a, 275, 135, 75, 150, this, true);
		cars[8] = new CARS(8, car2a, 425, 60, 75, 150, this, true);
		cars[9] = new CARS(9, car4a, 500, 210, 75, 150, this, true);
		cars[10] = new CARS(10, car1a, 575, 210, 75, 150, this, true);
		cars[11] = new CARS(11, car3a, 650, 210, 75, 150, this, true);
		cars[12] = new CARS(12, car1a, 650, 60, 75, 150, this, true);
		cars[13] = new CARS(13, car3a, 575, 360, 75, 150, this, true);
		numcar = 13;
	}

	public void stage15() {
		cars[0] = new CARS(0, maincar, 275, 210, 150, 75, this, false);
		cars[1] = new CARS(1, car3b, 275, 60, 150, 75, this, false);
		cars[2] = new CARS(2, car1b, 425, 60, 150, 75, this, false);
		cars[3] = new CARS(3, car5a, 275, 285, 225, 75, this, false);
		cars[4] = new CARS(4, car3b, 575, 360, 150, 75, this, false);
		cars[5] = new CARS(5, car2a, 425, 135, 75, 150, this, true);
		cars[6] = new CARS(6, car5b, 500, 210, 75, 225, this, true);
		cars[7] = new CARS(7, car4a, 575, 60, 75, 150, this, true);
		cars[8] = new CARS(8, car2a, 650, 60, 75, 150, this, true);
		cars[9] = new CARS(9, car3a, 575, 210, 75, 150, this, true);
		cars[10] = new CARS(10, car1a, 650, 210, 75, 150, this, true);
		numcar = 10;
	}

	public void back() {
		this.removeAll();
		this.revalidate();
		this.repaint();

		Car_main carmainpanel = new Car_main(board);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			back();
		} else if (e.getSource() == reset) {
			for (int i = 0; i <= numcar; i++) {
				this.remove(cars[i]);
			}
			this.revalidate();
			this.repaint();

			setCars();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		CARS selected_car = (CARS) e.getSource();
		selected_car.rect.setLocation(selected_car.getBounds().x,
				selected_car.getBounds().y);
		// **************************************************************************************
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			if (selected_car.vertical == true) {
				selected_car.y = selected_car.y + 75;
				selected_car.setLocation(selected_car.x, selected_car.y);
				selected_car.rect.setLocation(selected_car.x, selected_car.y);

				for (int i = 0; i <= numcar; i++) {
					if (selected_car.rect.intersects(cars[i].rect)
							&& (selected_car.num != i)) {
						selected_car.y = selected_car.y - 75;
						selected_car
								.setLocation(selected_car.x, selected_car.y);
						selected_car.rect.setLocation(selected_car.x,
								selected_car.y);
					}
				}
				if (selected_car.rect.intersects(bottom)) {
					selected_car.y = selected_car.y - 75;
					selected_car.setLocation(selected_car.x, selected_car.y);
					selected_car.rect.setLocation(selected_car.x,
							selected_car.y);
				}
			}

		}
		// **************************************************************************************

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (selected_car.vertical == true) {
				selected_car.y = selected_car.y - 75;
				selected_car.setLocation(selected_car.x, selected_car.y);
				selected_car.rect.setLocation(selected_car.x, selected_car.y);

				for (int i = 0; i <= numcar; i++) {
					if (selected_car.rect.intersects(cars[i].rect)
							&& (selected_car.num != i)) {
						selected_car.y = selected_car.y + 75;
						selected_car
								.setLocation(selected_car.x, selected_car.y);
						selected_car.rect.setLocation(selected_car.x,
								selected_car.y);
					}
				}
				if (selected_car.rect.intersects(top)) {
					selected_car.y = selected_car.y + 75;
					selected_car.setLocation(selected_car.x, selected_car.y);
					selected_car.rect.setLocation(selected_car.x,
							selected_car.y);
				}
			}

		}

		// **************************************************************************************

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (selected_car.vertical == false) {
				selected_car.x = selected_car.x - 75;
				selected_car.setLocation(selected_car.x, selected_car.y);
				selected_car.rect.setLocation(selected_car.x, selected_car.y);

				for (int i = 0; i <= numcar; i++) {
					if (selected_car.rect.intersects(cars[i].rect)
							&& (selected_car.num != i)) {
						selected_car.x = selected_car.x + 75;
						selected_car
								.setLocation(selected_car.x, selected_car.y);
						selected_car.rect.setLocation(selected_car.x,
								selected_car.y);
					}
				}
				if (selected_car.rect.intersects(left)) {
					selected_car.x = selected_car.x + 75;
					selected_car.setLocation(selected_car.x, selected_car.y);
					selected_car.rect.setLocation(selected_car.x,
							selected_car.y);
				}
			}

		}
		// **************************************************************************************

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (selected_car.vertical == false) {
				selected_car.x = selected_car.x + 75;
				selected_car.setLocation(selected_car.x, selected_car.y);
				selected_car.rect.setLocation(selected_car.x, selected_car.y);

				for (int i = 0; i <= numcar; i++) {
					if (selected_car.rect.intersects(cars[i].rect)
							&& (selected_car.num != i)) {
						selected_car.x = selected_car.x - 75;
						selected_car
								.setLocation(selected_car.x, selected_car.y);
						selected_car.rect.setLocation(selected_car.x,
								selected_car.y);
					}
				}

				if (selected_car.rect.intersects(right)) {
					if (selected_car.rect.intersects(end)) {
						int confirm = JOptionPane.showConfirmDialog(null,
								"成功~~!", "", JOptionPane.CLOSED_OPTION);

						setCleared();
						back();

					} else {
						selected_car.x = selected_car.x - 75;
						selected_car
								.setLocation(selected_car.x, selected_car.y);
						selected_car.rect.setLocation(selected_car.x,
								selected_car.y);
					}

				}
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
