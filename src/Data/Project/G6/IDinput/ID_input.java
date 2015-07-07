package Data.Project.G6.IDinput;


import Data.Project.G6.blacksmith.smithing.SmithingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ID_input extends JFrame implements ActionListener{
    
    public static final long serialVersionUID = 1L;
    public static final int WIDTH=1000;
    public static final int HEIGHT=1000;
    
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private JButton skipButton;
       
    private JLabel enterID;
    private TextField IDfield;
    private JLabel pictureLabel;
    
    
    public ID_input(){
        super("Welcome to Blacksmith!");    
        this.getContentPane().setBackground( Color.black ); 
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        layout = new GridBagLayout();
        layout.columnWidths = new int[] {50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50 };
        layout.rowHeights = new int[]{50,50,50,50,50,50,50,50,50,50,
                50,50,50,50,50,50,50,50,50,50 };
        setLayout(layout);
        
        gbc = new GridBagConstraints();
        
        
        Icon Pic = new ImageIcon( getClass().getResource( "blacksmith.jpg" ) );
        pictureLabel = new JLabel (Pic);        
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 8;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);
        add(pictureLabel, gbc);
        
        enterID = new JLabel("Enter ID:");     
        enterID.setFont(new Font("Arial", Font.ITALIC, 35));
        enterID.setForeground(Color.RED);
        gbc.gridx = 8;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);
        add(enterID, gbc);
        
        IDfield = new TextField(8);
        IDfield.setFont(new Font("Arial", Font.PLAIN,50));   
        gbc.gridx = 9;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);
        add(IDfield, gbc);      
        
        skipButton = new JButton("Confirm");
        skipButton.setFont(new Font("Arial", Font.ITALIC, 20)); 
        skipButton.setForeground(Color.WHITE);
        skipButton.setBackground(Color.BLACK);        
        skipButton.addActionListener(this);
        skipButton.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.red));
        gbc.gridx = 13;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;        
        add(skipButton,gbc);        
    }
    public void CloseFrame(){
        super.dispose();
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == skipButton || e.getSource() == IDfield){
            SmithingPanel smithing = new SmithingPanel ();   
            smithing.setID(IDfield.getText());          
            smithing.setSize(1500,900);
            smithing.setVisible(true); 
            smithing.setLocationRelativeTo(null);
            CloseFrame();
        }
        
    }
    

}
