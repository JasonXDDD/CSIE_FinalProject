package Data.Project.G15.game;

//import ContainerBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public  class Page1 extends JFrame implements ItemListener,ActionListener{
	JFrame a;
	String Start[]={"Start"};

	
	JButton button;
	
	public Page1(){		
		a = new JFrame("Game");
		
		button = new JButton("a");
	
		Icon ya = new ImageIcon(System.getProperty("user.dir") + "\\src\\Data\\Project\\G15\\game\\sad.png");
		JPanel panel = new JPanel();
		
		button.setIcon(ya);
		button.addActionListener(this);
		panel.add(button);
		a.add(panel);
//		a.setLocation(300,500);
		a.pack();
		a.show();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== button){
			a.dispose();
			Page2 g2 = new Page2();	
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}
