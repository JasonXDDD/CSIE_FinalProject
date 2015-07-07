package Data.Project.G6.blacksmith.smithing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Smithing extends JPanel implements ActionListener{
    private JLabel role;
    private JPanel rolePanel;
    private JPanel SouthPanel;
    private JButton play;
    
    public Smithing(){    
        
        rolePanel = new JPanel();
        setBackground(Color.WHITE);
        Icon Pic = new ImageIcon( getClass().getResource( "role_1.png"));
        role = new JLabel(Pic);
        play = new JButton("Play");
        role.setLocation(500, 500);
        rolePanel.add(role);
        rolePanel.setBackground(Color.white);
        
        play.setBackground(Color.WHITE);
        
        play.addActionListener(this);
        
        add(play);
        add(rolePanel);
    }
    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==play){
			
		            PlayPanel playing = new PlayPanel();            
		            playing.setSize(600,600);
		            playing.setVisible(true); 
		            playing.setLocationRelativeTo(null);
		            
		}
	}
}
