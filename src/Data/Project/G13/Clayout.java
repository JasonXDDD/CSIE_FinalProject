package Data.Project.G13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clayout implements MouseListener {
	JFrame frame = new JFrame("CardLayout demo");
	JPanel Panel = new JPanel();
	JPanel PanelForward = new JPanel();
	JPanel PanelBreakoutClone = new BreakoutClonePanel();
	JButton buttonSecond = new JButton("Switch to first panel/workspace");
	CardLayout cl = new CardLayout();
	private int WIDTH;
	private int HEIGHT;
	private Boolean forward=true;
	public static myMusicPlay audioPlayWave;

	public Clayout() {
		
		Panel.setLayout(cl);
		ImageIcon img = new ImageIcon(this.getClass().getResource("forward.png"));
		WIDTH=img.getIconWidth();
		HEIGHT=img.getIconHeight();
		System.out.printf("%d,%d",WIDTH,HEIGHT);
		JLabel imgLabel = new JLabel(img);
		PanelForward.add(imgLabel);
		PanelBreakoutClone.add(PanelForward);
		frame.getContentPane().add(PanelBreakoutClone);
		frame.setBackground(Color.BLACK);
		Panel.add(PanelForward, "1");
		Panel.add(PanelBreakoutClone, "2");
		cl.show(Panel, "1");
		imgLabel.addMouseListener(this);

		
		buttonSecond.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel, "1");
			}
		});
		frame.addWindowListener(new AdapterDemo());
		frame.setResizable(false);
		frame.add(Panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		

	}
	class AdapterDemo extends WindowAdapter {
	    public void windowClosing(WindowEvent e) {
	    	System.out.printf("!");
	        System.exit(0);
	    }
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Clayout();
				
			}
		});
		
		audioPlayWave = new myMusicPlay(System.getProperty("user.dir") + "\\src\\Data\\Project\\G13\\DX_Ball.wav");
        audioPlayWave.start();
//        musicOpenLab = 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(forward){
			audioPlayWave.stop();
			audioPlayWave =new myMusicPlay(System.getProperty("user.dir") + "\\src\\Data\\Project\\G13\\DX_Ball2.wav");
			audioPlayWave.start();
			cl.show(Panel, "2");
			System.out.printf("mousePressed");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}