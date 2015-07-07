package Data.Project.G13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Over1 implements ActionListener{

	JFrame frame = new JFrame("Game Over");

	JPanel Panel = new JPanel();
	JPanel PanelForward = new JPanel();
	Rank rank =new Rank(frame);
	
	CardLayout cl = new CardLayout();
	
    private JPanel panel;

    private JPanel showpanel;//show "enter your name"
    private JLabel show = new JLabel("Enter Your Name:");
    
    private JTextField text;
    
    private JPanel nextpanel;
    private JLabel next = new JLabel("Press\"Restart\"to restart game\n");
    
    private JPanel actionpanel;//repaly & enter
    private JButton replay;
    private JButton enter;
    private int iScore;

	public Over1(int iScore) {
		Panel.setLayout(cl);

		panel = new JPanel(new GridLayout(4,1));
    	showpanel=new JPanel();//show "enter your name"
    	show.setFont(new Font("Serif",Font.BOLD,24));
    	showpanel.add(show);
    	panel.add(showpanel);
    	
        text=new JTextField();
        frame.getContentPane().add(text,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        panel.add(text);
        
    	actionpanel=new JPanel();
        replay = new JButton("Restart");
        replay.addActionListener(this);	
        actionpanel.add(replay);
        
        enter = new JButton("Enter");
        enter.addActionListener(this);
        actionpanel.add(enter);
        this.iScore=iScore;
        
        panel.add(actionpanel);
        
    	nextpanel=new JPanel();
    	next.setFont(new Font("Serif",Font.BOLD,16));
    	nextpanel.add(next);
    	panel.add(nextpanel);
    	frame.add(panel,BorderLayout.CENTER);
    	/////////////////////////////////////////////////
    	
		rank.add(panel);
		
		frame.getContentPane().add(rank);
		Panel.add(panel, "1");
		Panel.add(rank, "2");
		cl.show(Panel, "1");
		
		frame.add(Panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==replay)
			frame.setVisible(false);
		else if(e.getSource()==enter){
			String iName = text.getText();
        	cl.show(Panel, "2");
        	VariableStorage a = VariableStorage.getInstance();
        	a.addNumname(iName);
        	a.addNumscore(iScore+"");
        	rank.setScoreAndName(iScore,iName);
		}
		
	}
}