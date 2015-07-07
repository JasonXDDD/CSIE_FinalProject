package Data.Project.G13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rank extends JPanel implements ActionListener{
	public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    JFrame frame;
    //BreakoutClonePanel b;
    private JPanel buttonpanel;
    private JButton enter;
    
    private JPanel rankpanel;
    private JLabel score;
    private JLabel Name;

    public Rank(JFrame frame){
    	setPreferredSize(new Dimension(WIDTH,HEIGHT));
    	this.setLayout(new BorderLayout());
    	this.frame=frame;

    	buttonpanel=new JPanel();
    	enter = new JButton("OK");
    	enter.addActionListener(this);
        
        buttonpanel.add(enter);
        add(buttonpanel,BorderLayout.SOUTH);
    	
    }
    public void setScoreAndName(int iScore,String name){
    	rankpanel=new JPanel();

    	rankpanel.setLayout(new GridBagLayout());
    	VariableStorage a = VariableStorage.getInstance();
    	
    	JLabel Index = new JLabel("<html>NO.---<br/>");
    	Index.setFont(new Font("Serif",Font.BOLD,24));
    	
    	rankpanel.add(Index);
    	
		Name = new JLabel("<html>Name---<br/>");
    	Name.setFont(new Font("Serif",Font.BOLD,24));
    	
    	rankpanel.add(Name);
    	
    	score= new JLabel("<html>Score<br/>");
    	score.setFont(new Font("Serif",Font.BOLD,24));
//    	score.setSize(160, 40);
    	rankpanel.add(score);
    	for(int i=0;i<a.getNumscore().size();i++){
    		String scoreYo = a.getNumscore().get(i);
    		String nameYo = a.getNumname().get(i);	
    		Index.setText(Index.getText()+(i+1)+".<br/>");
    		Name.setText(Name.getText()+nameYo+"<br/>");
    		score.setText(score.getText()+scoreYo+"<br/>");
    	}
    	Name.setText(Name.getText()+"<html/>");
    	score.setText(score.getText()+"<html/>");
    	add(rankpanel,BorderLayout.NORTH);


    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter)
			frame.setVisible(false);
	}
}
