package Data.Project.G15.game;

//import ContainerBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public  class Page2 extends JFrame implements ItemListener,ActionListener{
	JFrame a;
	String Start[]={"Start"};
//	private ContainerBox box; 
	
	JButton button;
	
	public Page2(){		
		a = new JFrame("Game");
		
		button = new JButton();
	
		Icon ya = new ImageIcon(System.getProperty("user.dir") + "\\src\\Data\\Project\\G15\\game\\123.jpg");
		JPanel panel = new JPanel();
		
		button.setIcon(ya);
		button.addActionListener(this);
		panel.add(button);
		a.add(panel);
//		a.setLocation(400,0);
		a.pack();
		a.show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== button){
			a.dispose();
                GamePage g3 = new GamePage();	
		g3.setLocation(150,100);
		g3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g3.setResizable(false);
		g3.setVisible(true);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}
