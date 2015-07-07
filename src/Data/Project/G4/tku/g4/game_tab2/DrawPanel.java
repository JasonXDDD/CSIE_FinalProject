package Data.Project.G4.tku.g4.game_tab2;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    
    
	private int MAX;
  
    public DrawPanel(int MAX){
       this.MAX = MAX;
       
   
       
    }
    
    
   public void papper(){
	    Random rand = new Random();
	    final int x=rand.nextInt(3);
	   if(x==1){
	         JOptionPane.showMessageDialog(null,
	           "���X���Y�A�AĹ�F�I�I",
	           "Result",
	           JOptionPane.WARNING_MESSAGE);  
	         }else if(x==2){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X�ŤM,�A��F�I�I",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }else if(x==3){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X���A����",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }
   }
   public void scissor(){
	   Random rand = new Random();
	    final int y=rand.nextInt(3);
	   if(y==1){
	         JOptionPane.showMessageDialog(null,
	           "���X���Y�A�A��F�I�I",
	           "Result",
	           JOptionPane.WARNING_MESSAGE);  
	         }else if(y==2){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X�ŤM,����",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }else if(y==3){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X���A�AĹ�F�I�I",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }
	   
   }
   public void stone(){
	   Random rand = new Random();
	    final int z=rand.nextInt(3);
	   if(z==1){
		   
	         JOptionPane.showMessageDialog(null,
	           "���X���Y�A����",
	           "Result",
	           JOptionPane.WARNING_MESSAGE);  
	         }else if(z==2){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X�ŤM,�AĹ�F�I�I",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }else if(z==3){
	        	 JOptionPane.showMessageDialog(null,
	      	           "���X���A�A��F�I�I",
	      	           "Result",
	      	           JOptionPane.WARNING_MESSAGE);  
	         }
	   
   }
   
   
   
}
