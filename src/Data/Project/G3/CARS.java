package Data.Project.G3;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class CARS extends JButton implements FocusListener{
	protected int num;
	protected Rectangle rect = null;
	protected ImageIcon carpic;
	protected int x,y;
	protected int height,width;
	protected Stages stages;
	protected boolean vertical;
	
	public CARS(int num,ImageIcon carpic,int x,int y,int width,int height,Stages stages,boolean vertical){
		this.num = num;
		this.carpic = carpic;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.stages = stages;
		this.vertical = vertical;
		
		//this.setOpaque(false);
		this.setIcon(carpic);
		this.setBounds(x, y, width, height);
		rect = new Rectangle(x, y, width, height);
		
		this.addKeyListener(stages);
		this.addFocusListener(this);
		stages.add(this,0);
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.setBackground(Color.ORANGE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		this.setBackground(null);
		
	}
	
	
}
