package Data.Project.G6.blacksmith.smithing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class List implements ActionListener{
    
    public List(){
        
    }
    
    public Component Mineral(){
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(142, 142, 142)); 
        
        JPanel jpanel1 = new JPanel();
        jpanel1.setLayout(new BorderLayout());
        
        jpanel1.setBorder(BorderFactory.createTitledBorder(border, "Mineral"));
        
        String[] items = new String[10];
        items[0] = "gold";
        items[1] = "silver";
        items[2] = "copper";
        items[3] = "iron";
        items[4] = "platinum";
        items[5] = "titanium";
        items[6] = "palladium";
        items[7] = "tamahagane";
        items[8] = "carbon";
        
        JList jlist1 = new JList(items);
        jlist1.setVisibleRowCount(5);
        jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane jscrollpane1 = new JScrollPane(jlist1);
        
        jpanel1.add(jscrollpane1);
        
        return jpanel1;
    }

    public Component Equipment(){
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(142, 142, 142)); 

        JPanel jpanel1 = new JPanel();
        jpanel1.setLayout(new FlowLayout());
        jpanel1.setBorder(BorderFactory.createTitledBorder(border, "Equipment"));
        
        String[] items = new String[10];
        for (int i=0; i < 10; i++)    
            items[i] = "Equipment " + (i+1);
        
        JList jlist1 = new JList(items);
        jlist1.setVisibleRowCount(5);
        jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane jscrollpane1 = new JScrollPane(jlist1);
        
        jpanel1.add(jscrollpane1);
        return jpanel1;
    }
    
    public Component Katana(){
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(142, 142, 142)); 

        JPanel jpanel1 = new JPanel();
        FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
        flowlayout.setVgap(300);
        jpanel1.setLayout(new FlowLayout());
        jpanel1.setBorder(BorderFactory.createTitledBorder(border, "Katana"));
        
        String[] items = new String[10];
        for (int i=0; i < 10; i++)    
            items[i] = "Katana " + (i+1);
        
        JList jlist1 = new JList(items);
        jlist1.setVisibleRowCount(5);
        jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane jscrollpane1 = new JScrollPane(jlist1);
        
        jpanel1.add(jscrollpane1);
        return jpanel1;
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
}
