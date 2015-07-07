package Data.Project.G3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Menu extends JPanel implements ActionListener {
	private Board board;

	private Games gamespanel;
	private Option optionpanel;

	private ImageIcon backgroundImg;
	private ImageIcon startImg;
	private ImageIcon optionImg;
	private ImageIcon titleImg;

	private JLabel background;
	private JLabel title;
	private JLabel textarea;

	private JButton Start;
	private JButton Option;

	public Menu(Board board) {

		setMenu();

		this.board = board;

	}

	public void setMenu() {

		titleImg = new ImageIcon(Main.class.getResource("objects\\title.png"));
		title = new JLabel(titleImg);
		title.setBounds(170, 100, 663, 177);
		this.add(title);

		Start = new JButton();
		Start.setBounds(250, 350, 500, 80);
		startImg = new ImageIcon(Main.class.getResource("objects\\start.jpg"));
		Start.setIcon(startImg);
		Start.addActionListener(this);
		this.add(Start);

		Option = new JButton();
		Option.setBounds(250, 450, 500, 80);
		optionImg = new ImageIcon(Main.class.getResource("objects\\option.jpg"));
		Option.setIcon(optionImg);
		Option.addActionListener(this);
		this.add(Option);

		textarea = new JLabel("Coding By TKU-CSIE-1B-G03");
		textarea.setBounds(800, 650, 300, 15);
		this.add(textarea);

	}

	private void setGames(Board board) {
		gamespanel = new Games(board);
		gamespanel.setOpaque(false);
		gamespanel.setLayout(null);

		board.add(gamespanel, 0);
	}

	private void setOption(Board board) {
		optionpanel = new Option(board);
		optionpanel.setOpaque(false);
		optionpanel.setLayout(null);

		board.add(optionpanel, 0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Start) {
			this.removeAll();
			this.revalidate();
			this.repaint();
			setGames(board);
		} else if (e.getSource() == Option) {
			this.removeAll();
			this.revalidate();
			this.repaint();
			setOption(board);
		}

	}

}
