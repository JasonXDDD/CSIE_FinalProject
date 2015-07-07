package Data.Project.G4.tku.g4.game_tab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameRun extends JFrame implements ActionListener, ItemListener{
	
	private GridBagLayout layout; // layout of this frame
    private GridBagConstraints gbc; // constraints of this layout
	
	private JPanel bottomPanel;
	
	private JPanel numberPanel;
	private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton input;
    private JButton clear;
    
    private JTextField field;
    
    private String string = "";
    
    private int RealAns;
    private int YourAns;
    private int max = 100;
    private int min = 1;
    private int count = 0;
    
	
	public GameRun(){
		//setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 400, 300 ); // set frame size
		setVisible( true ); // display frame
		
		Random rand = new Random();
		RealAns = rand.nextInt(98)+2;
		
	    this.setLayout(new BorderLayout());
	    
	    bottomPanel = new JPanel();
	    
	    layout = new GridBagLayout();
	    
	    numberPanel = new JPanel(layout);
	    gbc = new GridBagConstraints();
	    
	    zero = new JButton(" 0 ");
	    gbc.gridx = 0; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(zero, gbc);
	    zero.addActionListener(this);
	    
	    one = new JButton(" 1 ");
	    gbc.gridx = 1; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(one, gbc);
	    one.addActionListener(this);
	    
	    two = new JButton(" 2 ");
	    gbc.gridx = 2; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(two, gbc);
	    two.addActionListener(this);
	    
	    three = new JButton(" 3 ");
	    gbc.gridx = 3; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(three, gbc);
	    three.addActionListener(this);
	    
	    four = new JButton(" 4 ");
	    gbc.gridx = 4; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(four, gbc);
	    four.addActionListener(this);
	    
	    five = new JButton(" 5 ");
	    gbc.gridx = 0; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(five, gbc);
	    five.addActionListener(this);
	    
	    six = new JButton(" 6 ");
	    gbc.gridx = 1; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(six, gbc);
	    six.addActionListener(this);
	    
	    seven = new JButton(" 7 ");
	    gbc.gridx = 2; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(seven, gbc);
	    seven.addActionListener(this);
	    
	    eight = new JButton(" 8 ");
	    gbc.gridx = 3; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(eight, gbc);
	    eight.addActionListener(this);
	    
	    nine = new JButton(" 9 ");
	    gbc.gridx = 4; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 1; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(nine, gbc);
	    nine.addActionListener(this);
	    
	    input = new JButton(" input ");
	    gbc.gridx = 5; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 2; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(input, gbc);
	    input.addActionListener(this);
	    
	    clear = new JButton(" clear ");
	    gbc.gridx = 5; 
	    gbc.gridy = 1; 
	    gbc.gridwidth = 2; 
	    gbc.gridheight = 1; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    numberPanel.add(clear, gbc);
	    clear.addActionListener(this);
		
	    bottomPanel.add(numberPanel);
	    
	    add(bottomPanel, BorderLayout.SOUTH);
	    
	    field = new JTextField();
		field.setEnabled(false);
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setFont(new Font("Arial", Font.PLAIN, 24));
		field.setHorizontalAlignment(JTextField.RIGHT);
		add(field);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==zero)
			field.setText(field.getText()+0);
		if(e.getSource()==one)
			field.setText(field.getText()+1);
		if(e.getSource()==two)
			field.setText(field.getText()+2);
		if(e.getSource()==three)
			field.setText(field.getText()+3);
		if(e.getSource()==four)
			field.setText(field.getText()+4);
		if(e.getSource()==five)
			field.setText(field.getText()+5);
		if(e.getSource()==six)
			field.setText(field.getText()+6);
		if(e.getSource()==seven)
			field.setText(field.getText()+7);
		if(e.getSource()==eight)
			field.setText(field.getText()+8);
		if(e.getSource()==nine)
			field.setText(field.getText()+9);
		
		if(e.getSource()==input){
			YourAns = Integer.parseInt(field.getText());
			if(YourAns != RealAns && YourAns > RealAns){
				max = YourAns;
				string = String.format("The answer of range is %d ~ %d",min,max);
				JOptionPane.showMessageDialog(null, string ,
				          "Remind",
				          JOptionPane.INFORMATION_MESSAGE);
				count++;
				field.setText("");
			}
			
			if(YourAns != RealAns && YourAns < RealAns){
				min = YourAns;
				string = String.format("The answer of range is %d ~ %d",min,max);
				JOptionPane.showMessageDialog(null, string ,
				          "Remind",
				          JOptionPane.INFORMATION_MESSAGE);
				count++;
				field.setText("");
			}
			if(YourAns == RealAns){
				count++;
				string = String.format("You get the right number:%d\nYou guess %d times",RealAns,count);
				JOptionPane.showMessageDialog(null, string ,
				          "Congratulation",
				          JOptionPane.INFORMATION_MESSAGE);
				field.setText("");
			}
		}
		
		if(e.getSource()==clear)
			field.setText("");
	}

}
