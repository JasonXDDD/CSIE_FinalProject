package Data.Project.G6.blacksmith.smithing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ActionPanel extends JFrame implements ActionListener{
	
	private JPanel Panel;
	private JPanel po;
	
	private TitledBorder la1Title;
	private JPanel la1;
	private JLabel la2;
	private JLabel la3;
	private JLabel la4;
	private JButton weapon;
	private JButton power;
	private JButton get;
	private JButton sell;
	
	public ActionPanel()
	{
		this.setLayout(new BorderLayout());  
		setBackground(Color.BLACK);
		
		po = new JPanel();
		po.setLayout(new FlowLayout());
		
		final CardLayout card = new CardLayout();
		Panel = new JPanel(card);
		Panel.setLayout(card);
		
		Icon ico4 = new ImageIcon( getClass().getResource("A4.jpg"));
		
        la1 = new JPanel(new GridLayout(5,1));
		Border blackLine = BorderFactory.createLineBorder(Color.black);  
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 50);        
        la1Title = BorderFactory.createTitledBorder(blackLine,"katana Data", 0 ,0 , font, Color.GREEN);
        la1.setBorder(la1Title);
        
        Font font1 = new Font(Font.MONOSPACED, Font.PLAIN, 30);  
        JLabel name = new JLabel("Name: Power Katana");
        name.setFont(font1);
        la1.add(name);
        JLabel Hardness = new JLabel("Hardness: 9");
        Hardness.setFont(font1);
        la1.add(Hardness);
        JLabel Price = new JLabel("Price: 60000");
        Price.setFont(font1);
        la1.add(Price);
        JLabel Stock = new JLabel("Stock: 1");
        Stock.setFont(font1);
        la1.add(Stock);
        JLabel Katana = new JLabel("Level: A");
        Katana.setFont(font1);
        la1.add(Katana);
        
	        
		la4 = new JLabel(ico4);
		
		Panel.add(la4 ,"1");
        Panel.add(la1 ,"2");
		
		weapon = new JButton("weapon");
		power = new JButton("Power");
		get = new JButton("Get!");
		sell = new JButton("Sell!");
		
		power.setFont(new Font("Arial", Font.ITALIC, 20));
        power.setBackground(Color.black);
        power.setForeground(Color.WHITE);
		
        get.setFont(new Font("Arial", Font.ITALIC, 20));
        get.setBackground(Color.black);
        get.setForeground(Color.WHITE);
		
        sell.setFont(new Font("Arial", Font.ITALIC, 20));
        sell.setBackground(Color.black);
        sell.setForeground(Color.WHITE);
        
        weapon.setFont(new Font("Arial", Font.ITALIC, 20));
        weapon.setBackground(Color.black);
        weapon.setForeground(Color.WHITE);
        
        power.addActionListener(this);
        get.addActionListener(this);
        sell.addActionListener(this);
        weapon.addActionListener(this);
        
        weapon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(Panel,"1");
            }
              });
        
        power.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(Panel,"2");
            }
              });
		
		po.add(weapon);
        po.add(power);
        po.add(get);
        po.add(sell);
		po.add(Panel);
		
		add(po,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==get){
			super.dispose();
		}else if(e.getSource()==sell){
			int n =JOptionPane.showConfirmDialog(null, "It's sell!", "Title",JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.NO_OPTION ){
				repaint();
			}else if(n == JOptionPane.YES_OPTION){
				super.dispose();
			}
		}
	}
}
