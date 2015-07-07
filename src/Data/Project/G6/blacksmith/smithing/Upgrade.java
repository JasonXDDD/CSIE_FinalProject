package Data.Project.G6.blacksmith.smithing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Upgrade extends JPanel implements ActionListener{
    
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottonPanel;
    private JButton upper;
    private JLabel Label;
    private JLabel text;
    public Upgrade()
    {
        super();
        this.setLayout(new BorderLayout());  

        
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottonPanel = new JPanel();
        
        
        Icon ico1 = new ImageIcon( getClass().getResource("up.jpg"));
        Icon ico2 = new ImageIcon( getClass().getResource("screen.jpg"));
        
        upper = new JButton("Upper",ico1);   
        upper.addActionListener(this);
        upper.setFont(new Font("Arial", Font.ITALIC, 20));
        upper.setBackground(Color.black);
        upper.setForeground(Color.WHITE);
        
        bottonPanel.add(upper);
        Label = new JLabel(ico2);
        topPanel.add(Label);
        
        text = new JLabel("It is becoming strong by choosing the road");
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        middlePanel.add(text);
        
        
        upper.setToolTipText("It is becoming strong by choosing the road");
        

     //   upper.setBounds(250,500,200,80);
        
        
        add(topPanel,BorderLayout.NORTH);
        add(middlePanel,BorderLayout.CENTER);
        add(bottonPanel,BorderLayout.SOUTH);
        
        
        
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    

}