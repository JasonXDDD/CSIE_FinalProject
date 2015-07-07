package Data.Project.G6.blacksmith.smithing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Equipment extends JPanel implements ActionListener{
	
	private JPanel Equip;
	private JButton upper;
	
	private JLabel Label;
	
	public Equipment(){
		super();
		this.setLayout(new BorderLayout());  
		
		Equip = new JPanel();
		setBackground(Color.BLACK);
	}
	
	public void actionPerformed(ActionEvent e) {
	    
	}
}
