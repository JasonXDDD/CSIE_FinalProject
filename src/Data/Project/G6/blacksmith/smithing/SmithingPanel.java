package Data.Project.G6.blacksmith.smithing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class SmithingPanel extends JFrame implements ActionListener{
    private Shop shopscreen;
    private Stock stockscreen;
    private Smithing smithingscreen;
    private Direction directionscreen;
    private Upgrade  upgradescreen;
    private JPanel smithingPanel;
    
    private JLabel iconLabel;
    private JPanel personalPanel;
    private TitledBorder personalTitle;    
    private JLabel leftupLabel;
    private JPanel bottomLeft;
    private JPanel rightPanel;    
    private JLabel name;
    private JLabel level;
    private JLabel reputation;
    private JLabel skilled;
    private JLabel money;
    private JPanel buttonPanel;
    private TextArea text;
    
    private JButton blacksmithing;
    private JButton shop;
    private JButton stock;
    
    public String ID;

    public void setID(String iD) {
        ID = iD;
    }
    
    public String getID(){
        return ID;
    }
    
    public SmithingPanel() {
        super();
        this.setLayout(new BorderLayout());
        
        smithingPanel = new JPanel();
        smithingPanel.setBounds(0, 0, 1280, 1080);
        
        bottomLeft = new JPanel(new GridLayout(3,1)); 
        
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        
        Icon Pic = new ImageIcon( getClass().getResource( "MIA_Blacksmith.jpg" ) );
        leftupLabel = new JLabel (Pic,JLabel.CENTER);
        
        personalPanel = new JPanel(new GridLayout(5,1));  
        
        Icon Pic2 = new ImageIcon( getClass().getResource( "Teemo.jpg" ) );
        iconLabel = new JLabel (Pic2,JLabel.CENTER);
        bottomLeft.add(iconLabel);
        Border blackLine = BorderFactory.createLineBorder(Color.black);  
        Font font = new Font(Font.MONOSPACED, Font.ITALIC, 18);        
        personalTitle = BorderFactory.createTitledBorder(blackLine,"Role Data", 0 ,0 , font, Color.BLUE);
        personalPanel.setBorder(personalTitle);
        
        name = new JLabel(); 
        name.setText("NAME:    Teemo");
        personalPanel.add(name);
        level = new JLabel("Level:   1");
        personalPanel.add(level);
        reputation = new JLabel("Reputation:   0");
        personalPanel.add(reputation);
        skilled = new JLabel("Skilled:   0");
        personalPanel.add(skilled);
        money = new JLabel("Money:   2000");
        personalPanel.add(money);
        bottomLeft.add(personalPanel);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        rightPanel = new JPanel();
        final CardLayout cardlayout = new CardLayout();
        rightPanel.setLayout(cardlayout);
        
        shopscreen = new Shop();
        stockscreen = new Stock();
        smithingscreen = new Smithing();
        directionscreen = new Direction();
        upgradescreen = new Upgrade();
        rightPanel.add(smithingscreen,"1");
        rightPanel.add(shopscreen ,"2");
        rightPanel.add(stockscreen ,"3");
        rightPanel.add(new JLabel("Card 4") ,"4");
        rightPanel.add(upgradescreen,"5");
        rightPanel.add(directionscreen, "6");
        
        JButton smithing = new JButton("Smithing");
        smithing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cardlayout.show(rightPanel,"1");
            }
          });
        JButton shop = new JButton ("Shop");
        shop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cardlayout.show(rightPanel,"2");
            }
          });
          
        JButton stock = new JButton ("Stock");
        stock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cardlayout.show(rightPanel,"3");
            }
          });
        
        JButton equipment = new JButton ("Eqipment");
        equipment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cardlayout.show(rightPanel,"4"); 
            }
          });
        
        JButton upgrade = new JButton ("Upgrade");
        upgrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cardlayout.show(rightPanel,"5");
            }
          });
        JButton direction = new JButton ("Direction");
        direction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cardlayout.show(rightPanel,"6");
            }
          });
        buttonPanel.add(smithing);
        buttonPanel.add(shop);
        buttonPanel.add(stock);
        buttonPanel.add(equipment);
        buttonPanel.add(upgrade);
        buttonPanel.add(direction);
        buttonPanel.add(rightPanel);
        
        String s = "Welcome to Blacksmith!"; 
        text = new TextArea(s, 10, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        text.setFont(new Font("Arial", Font.PLAIN,20)); 
        text.setSize(300,500);
        bottomLeft.add(text);
        
        JSplitPane top = new JSplitPane(JSplitPane.VERTICAL_SPLIT,leftupLabel,bottomLeft);
        top.setOneTouchExpandable(true);
        top.setDividerLocation(200);
        
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,top,buttonPanel);
        split.setOneTouchExpandable(true);
        split.setDividerLocation(400);
        
        add(split);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
}
