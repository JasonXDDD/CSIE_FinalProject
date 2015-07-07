package Data.Project.G6.blacksmith.smithing;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

public class Stock extends JPanel implements ActionListener{
    private JPanel Sower;
    private JButton Mineral;
    private JButton Equipment;
    private JButton Katana;
    private JPanel pack;
    private JLabel Word;
    private TitledBorder Title;
    
 
    public Stock()
    {
        super();
   
       this.setLayout(new BorderLayout());
//       this.setBounds(0, 0, 700, 700);
        pack = new JPanel();
        pack.setLayout(new FlowLayout());
        
        final CardLayout card = new CardLayout();
        Sower = new JPanel(card);
        Sower.setLayout(card);
        
        Sower.add(new JLabel("Stock => Mineral") ,"1");
        Sower.add(new JLabel("Stock => Equipment") ,"2");
        Sower.add(new JLabel("Stock => Katana") ,"3");

        
        Icon pic1 = new ImageIcon(getClass().getResource("diamond.jpg"));
        Icon pic2 = new ImageIcon(getClass().getResource("weapon.jpg"));
        Icon pic3 = new ImageIcon(getClass().getResource("sword.jpg"));
        
        Mineral = new JButton("Mineral",pic1);
        Equipment = new JButton("Equipment",pic2);
        Katana = new JButton("Katana",pic3);

        Mineral.setBackground(Color.WHITE);
        Equipment.setBackground(Color.WHITE);
        Katana.setBackground(Color.WHITE);
        
        
        
        Mineral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(Sower,"1");
            }
                
              });
        Equipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                card.show(Sower,"2");
            }
                
              });
        Katana.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                card.show(Sower,"3");
            }
              });
        
        pack.add(Mineral);
        pack.add(Equipment);
        pack.add(Katana);
//        pack.add(Word);
        pack.add(Sower);
        add(pack);
        
        
        JSplitPane Jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,Sower,pack);
        Jsp.setOneTouchExpandable(true);
        Jsp.setDividerLocation(50);
       // ((BasicSplitPaneUI)Jsp.getUI()).getDivider().setBasicSplitPaneUI(null);
        Jsp.setEnabled(false);
        
        add(Jsp);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Mineral)
        {
            getMineral();
        }else if(e.getSource()==Equipment)
        {
            int n =JOptionPane.showConfirmDialog(null, "This button is not complete. Due to technical and engineering problems, we can not tell too much!", "Title",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.NO_OPTION )
            {
                repaint();
            }else if(n == JOptionPane.YES_OPTION)
            {
                repaint();
                
            }
        }else if(e.getSource()==Katana)
        {
            int n =JOptionPane.showConfirmDialog(null, "This button is not complete. Due to technical and engineering problems, we can not tell too much!", "Title",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.NO_OPTION )
            {
                repaint();
            }else if(n == JOptionPane.YES_OPTION)
            {
                repaint();
            }
        }
        
    }




    private void getMineral(){
        
        JPanel Mineral= new JPanel(new GridLayout(2,2));
        setLayout(null);
//      super(Name,Desity,hardness,price,stock);
        JLabel n0 = new JLabel("Name    Density Hardness    Price   Stock");
        JLabel n1 = new JLabel("god Mine    0.99    10  1000000 godd");
        JLabel n2 = new JLabel();
        JLabel n3 = new JLabel();
        JLabel n4 = new JLabel();
        JLabel n5 = new JLabel();
        JLabel n6 = new JLabel();
        JLabel n7 = new JLabel();
        
        n0.setBackground(Color.CYAN);
        
        Sower.add(Mineral);
        add(n0);
        add(n1);
        
        
        
    }


}
