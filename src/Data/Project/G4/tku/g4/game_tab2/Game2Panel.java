package Data.Project.G4.tku.g4.game_tab2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game2Panel extends JPanel implements ActionListener{
	private DrawPanel draw;
    private JPanel bottomPanel;
    private JPanel topPanel;

    private int MAX = 50;
    
   
    private JButton papper;
    private JButton scissor;
    private JButton stone;
    private JButton title;
    
    public Game2Panel(){
        super();
        draw = new DrawPanel(MAX);
        add(draw, BorderLayout.CENTER);
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        Icon titleIcon = new ImageIcon( getClass().getResource( "title.png"));
        title = new JButton(titleIcon);
        title.addActionListener(this);
        topPanel.add(title);
        
        
        Icon papperIcon = new ImageIcon( getClass().getResource( "papper.png" ) );
        papper = new JButton("Papper",papperIcon);
        papper.addActionListener(this);
        bottomPanel.add(papper);
        
        
        Icon scissorIcon = new ImageIcon( getClass().getResource( "scissor.png" ) );
        scissor= new JButton("Scissor",scissorIcon);
        scissor.addActionListener(this);
        bottomPanel.add(scissor);
        
        
        Icon stoneIcon = new ImageIcon( getClass().getResource( "stone.png" ) );
        stone = new JButton("Stone",stoneIcon);
        stone.addActionListener(this);
        bottomPanel.add(stone);
        add(bottomPanel, BorderLayout.SOUTH);
        add(topPanel,BorderLayout.NORTH);

        
     }
     
     public void actionPerformed(ActionEvent e){
 		if (e.getSource() == papper){
 			draw.papper();
 			
 		}else if(e.getSource()==scissor){
 			draw.scissor();
 			
 		}else if(e.getSource()==stone){
 			draw.stone();
 			
 		}
            
     }
     



}
