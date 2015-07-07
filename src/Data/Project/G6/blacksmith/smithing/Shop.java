package Data.Project.G6.blacksmith.smithing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Shop extends JPanel{
    private List list;
    
    private JPanel buttonPanel;
    private JButton Mineral;
    private JButton Equipment;
    private JButton Katana;
    
    private JPanel cardPanel;
    
    private JPanel testPanel;
    public Shop(){
        testPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
       
        Icon pic1 = new ImageIcon(getClass().getResource("diamond.jpg"));
        Icon pic2 = new ImageIcon(getClass().getResource("weapon.jpg"));
        Icon pic3 = new ImageIcon(getClass().getResource("sword.jpg"));
        
        cardPanel = new JPanel();
        final CardLayout cardlayout = new CardLayout();
        cardPanel.setLayout(cardlayout);
        cardPanel.setBackground(Color.WHITE);
        
        list = new List();
        
        cardPanel.add(list.Mineral(),"1");
        cardPanel.add(list.Equipment(),"2");
        cardPanel.add(list.Katana(), "3");
        cardPanel.setSize(800, 700);;
        
        JButton Mineral = new JButton("Mineral",pic1);
        Mineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cardlayout.show(cardPanel,"1");
            }
          });
       
        JButton Equipment = new JButton("Equipment",pic2);
        Equipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cardlayout.show(cardPanel,"2");
            }
          });
        
        JButton Katana = new JButton("Katana",pic3);
        Katana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
              cardlayout.show(cardPanel,"3");
            }
          });
        
        Mineral.setBackground(Color.WHITE);
        Equipment.setBackground(Color.WHITE);
        Katana.setBackground(Color.WHITE);
        
        buttonPanel.add(Mineral);
        buttonPanel.add(Equipment);
        buttonPanel.add(Katana);
        buttonPanel.add(cardPanel);
        testPanel.add(buttonPanel);
        add(testPanel);
    }

    private LayoutManager flowLayout() {
        return null;
    }
    
}
