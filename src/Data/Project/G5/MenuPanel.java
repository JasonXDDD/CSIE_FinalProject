package Data.Project.G5;

import javax.swing.*;

import java.awt.*;

public class MenuPanel extends JPanel {
	
	JTextField namefield;
	
	Memory memory = new Memory();
	
	JLabel name;
	JLabel background;
	JLabel title;
	JPanel enterPanel;
	JPanel titlePanel;
	
	String ID;
	
	Icon bg = new ImageIcon (getClass().getResource("bg.jpg"));
	
	public MenuPanel (Memory memory){
		super ();
		this.setLayout(new BorderLayout());
		
		this.memory = memory;
		
		namefield = new JTextField("Player");
		
		enterPanel = new JPanel();
		name = new JLabel("Enter Your ID");
		name.setFont(new Font("Buxton Sketch", Font.BOLD ,30));
		name.setForeground(Color.WHITE);
		title = new JLabel("TEMPO GAME");
		title.setFont(new Font("Buxton Sketch", Font.BOLD ,90));
		title.setForeground(Color.WHITE);
		background = new JLabel (bg);
		
		namefield.selectAll();
		namefield.setFont(new Font(null, Font.PLAIN ,22));
		namefield.setPreferredSize(new Dimension(200,30));
		
		enterPanel.setOpaque(false);
		enterPanel.setBounds(450, 200, 400, 45);
		
		enterPanel.add(name);
		enterPanel.add(namefield);
		
		titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBounds(10, 10, 500, 90);

		titlePanel.add(title);

		add (titlePanel);
		add (enterPanel);
		add (background);
	}
	
	public void savename (){
		ID = namefield.getText();
		memory.setName(ID);
	}
	
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	
}
