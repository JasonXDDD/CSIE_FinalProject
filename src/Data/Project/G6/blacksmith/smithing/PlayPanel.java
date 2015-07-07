package Data.Project.G6.blacksmith.smithing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayPanel extends JFrame implements ActionListener{
	
	private JPanel Playing;
	private JButton addd;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	private JLabel l9;
	private JTextField d1;
	private JTextField d2;
	private JTextField d3;
	private JTextField d4;
	private JTextField d5;
	private JTextField d6;
	private JTextField d7;
	private JTextField d8;
	private JTextField d9;
	
	public PlayPanel(){
		setTitle("playing");
		setLayout(null);
		Playing = new JPanel();
		
		l1 = new JLabel("Gold");
		l2 = new JLabel("Sliver");
		l3 = new JLabel("Copper");
		l4 = new JLabel("Iron");
		l5 = new JLabel("Platinum");
		l6 = new JLabel("Titanium");
		l7 = new JLabel("Palladium");
		l8 = new JLabel("Tamahagane");
		l9 = new JLabel("Carbon");
		
		d1 = new JTextField();
		d2 = new JTextField();
		d3 = new JTextField();
		d4 = new JTextField();
		d5 = new JTextField();
		d6 = new JTextField();
		d7 = new JTextField();
		d8 = new JTextField();
		d9 = new JTextField();
		
		Icon ico = new ImageIcon( getClass().getResource("play.jpg"));
		
		addd= new JButton("Add and play",ico);
		
		addd.setBackground(Color.WHITE);
		
		l1.setBounds(90,45,100,30);
		l2.setBounds(280,45,100,30);
		l3.setBounds(480,45,100,30);
		l4.setBounds(90,195,100,30);
		l5.setBounds(275,195,100,30);
		l6.setBounds(475,195,100,30);
		l7.setBounds(70,345,100,30);
		l8.setBounds(265,345,100,30);
		l9.setBounds(480,345,100,30);
		
		d1.setBounds(50,75,100,30);
		d2.setBounds(250,75,100,30);
		d3.setBounds(450,75,100,30);
		d4.setBounds(50,225,100,30);
		d5.setBounds(250,225,100,30);
		d6.setBounds(450,225,100,30);
		d7.setBounds(50,375,100,30);
		d8.setBounds(250,375,100,30);
		d9.setBounds(450,375,100,30);
		
		addd.setBounds(150,500,300,50);
		
		addd.addActionListener(this);
		
		add(Playing);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(d1);
		add(d2);
		add(d3);
		add(d4);
		add(d5);
		add(d6);
		add(d7);
		add(d8);
		add(d9);
		add(addd);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addd){
			int n =JOptionPane.showConfirmDialog(null, "Are you sure?", "Title",JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.NO_OPTION ){
				repaint();
			}else if(n == JOptionPane.YES_OPTION){
				super.dispose();
				ActionPanel Action = new ActionPanel();            
	            Action.setSize(700,700);
	            Action.setVisible(true); 
	            Action.setLocationRelativeTo(null);
			}
		}
	}
}
