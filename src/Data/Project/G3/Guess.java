package Data.Project.G3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Guess extends JPanel {
	private Board board;

	private int totalA = 0;
	private int totalB = 0;
	private int x = 0;
	private String title = "Welcome!";
	private int a1, b1, c1;
	private int start;
	private int usera2, userb2, userc2;
	private int wrong, again;
	private String a2, b2, c2, q;
	private JTextArea show;
	private int guesstimes = 1;

	private Games gamepanel;
	
	private AudioPlayer Sunday_Plans;
	private AudioPlayer Giant_Leap;

	public Guess(Board board) {

		this.board = board;
		this.setOpaque(false);
		this.setLayout(null);
		
		board.stopMusic();
		Giant_Leap = board.getGiant_Leap();
		Giant_Leap.play();
		
		
		showPath();

		board.add(this, 0);
		try {
			playguess();
		} catch (NumberFormatException e1) {

		} finally {
			back();
		}

	}

	public void playguess() {
		start = JOptionPane.showConfirmDialog(null, "�w��Ӫ��q�Ʀr�I", title,
				JOptionPane.YES_NO_OPTION);
		if (start == JOptionPane.NO_OPTION) {
			x = 1;
		}

		a1 = (int) (Math.random() * 9 + 1);

		do {
			b1 = (int) (Math.random() * 9 + 1);
		} while (a1 == b1);

		do {
			c1 = (int) (Math.random() * 9 + 1);
		} while (c1 == b1 || c1 == a1);

		while (x != 1) {
			do {

				a2 = JOptionPane.showInputDialog("�вq�Ĥ@���");
				b2 = JOptionPane.showInputDialog("�вq�ĤG���");
				c2 = JOptionPane.showInputDialog("�вq�ĤT���");
				q = a2 + b2 + c2;
				show.setText(show.getText() + "Guess " + guesstimes + " : " + q
						+ "\n");
				guesstimes++;
				usera2 = Integer.parseInt(a2);
				userb2 = Integer.parseInt(b2);
				userc2 = Integer.parseInt(c2);
				if (usera2 == a1) {
					totalA = totalA + 1;
				} else if (usera2 == b1 || usera2 == c1) {
					totalB = totalB + 1;
				}
				if (userb2 == b1) {
					totalA = totalA + 1;
				} else if (userb2 == a1 || userb2 == c1) {
					totalB = totalB + 1;
				}
				if (userc2 == c1) {
					totalA = totalA + 1;
				} else if (userc2 == a1 || userc2 == b1) {
					totalB = totalB + 1;
				}

				if (totalA != 3) {
					wrong = JOptionPane.showConfirmDialog(null,
							"�i���S�q��!\nResult " + totalA + "A" + totalB
									+ "B\n�аݭn�~���?", title,
							JOptionPane.YES_NO_OPTION);
					if (wrong == JOptionPane.NO_OPTION) {
						x = 1;
						break;
					}
				}
				if (totalA == 3) {
					again = JOptionPane.showConfirmDialog(null, "�q���F�I�A���@���H",
							title, JOptionPane.YES_NO_OPTION);
					if (again == JOptionPane.NO_OPTION) {
						x = 1;
						break;
					} else if (again == JOptionPane.YES_OPTION) {
						show.setText(null);
						guesstimes = 1;
					}
				}
				totalA = 0;
				totalB = 0;
			} while (totalA != 3);

			break;

		}
	}

	public void showPath() {
		show = new JTextArea();
		show.setBounds(300, 100, 400, 500);
		show.setEditable(false);

		this.add(show);
	}

	public void back() {
		this.removeAll();
		this.revalidate();
		this.repaint();
		board.stopMusic();
		
		gamepanel = new Games(board);
		gamepanel.setOpaque(false);
		gamepanel.setLayout(null);
		
		board.add(gamepanel, 0);
		Sunday_Plans = board.getSunday_Plans();
		Sunday_Plans.play();
	}
}
