package Data.Project.G4.tku.g4.game_tab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Game1Panel extends JPanel implements ActionListener, ItemListener{
	
	private JPanel centerPanel;
	
    private JPanel GameStartPanel;
    private JButton start1;
    private JButton start2;
	
    public Game1Panel(){
    	super();
    	
    	centerPanel = new JPanel();
    	
    	GameStartPanel = new JPanel(new GridLayout(2,1));
    	Icon number = new ImageIcon( getClass().getResource( "number.png" ) );
    	start1 = new JButton("", number);
    	GameStartPanel.add(start1);
    	start1.addActionListener(this);
    	centerPanel.add(GameStartPanel);
    	
    	Icon AB = new ImageIcon( getClass().getResource( "AB.png" ) );
    	start2 = new JButton("", AB);
    	GameStartPanel.add(start2);
    	start2.addActionListener(this);
    	
    	add(centerPanel, BorderLayout.CENTER);
    	
    }
    
    public void actionPerformed(ActionEvent e){
    	if (e.getSource() == start1){
    		GameRun run = new GameRun();
    	}
    }	
    public void itemStateChanged( ItemEvent e )
    {

    } // end method itemStateChanged
    

}
