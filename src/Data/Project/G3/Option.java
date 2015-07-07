package Data.Project.G3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class Option extends JPanel implements ActionListener{
	private Board board;
	private Menu menupanel;
	
	private ImageIcon volumeImg;
	
	private JLabel volume;
	private JButton volumeplus;
	private JButton volumeminus;
	
	private ImageIcon changeBGImg;
	private JLabel changeBG;
	private JButton changeBGb;
	
	private ImageIcon backImg;
	private JButton back;
	
	private Random rand;
	private int bgnum;
	private AudioPlayer Sunday_Plans;
	private JTextField showvolume;
	private int showvolumen;
	private String showvolumeo = "";
	
	public Option(Board board){
		
		this.board = board;
		Sunday_Plans = board.getSunday_Plans();
		rand = new Random();
		
		volumeImg = new ImageIcon(Option.class.getResource("objects\\volume.png"));
		volume = new JLabel(volumeImg);
		volume.setBounds(150,100,100,100);
		this.add(volume);
		
		volumeplus = new JButton("�Q");
		volumeplus.setBounds(700,125,50,50);
		volumeplus.addActionListener(this);
		this.add(volumeplus);
		
		volumeminus = new JButton("�@");
		volumeminus.setBounds(300,125,50,50);
		volumeminus.addActionListener(this);
		this.add(volumeminus);
		
		changeBGImg = new ImageIcon(Option.class.getResource("objects\\changeBG.png"));
		changeBG = new JLabel(changeBGImg);
		changeBG.setBounds(150,250,100,100);
		this.add(changeBG);
		
		changeBGb = new JButton("CHANGE BACKGROUND");
		changeBGb.setBounds(300,275,450,50);
		changeBGb.addActionListener(this);
		this.add(changeBGb);
		
		backImg = new ImageIcon(Option.class.getResource("objects\\back.jpg"));
		back = new JButton(backImg);
		back.setBounds(870,620,70,30);
		back.addActionListener(this);
		this.add(back);
		
		showvolume = new JTextField();
		showvolume.setBounds(390, 135, 250, 30);
		showvolume.setEditable(false);
		changevolumetext();	
		this.add(showvolume);
		
	}

	public void changevolumetext(){
		showvolumen = board.getShowvolumen();
		for(int i = 1;i <=showvolumen;i++){
			showvolumeo = showvolumeo + "�p�p";
		}
		showvolume.setText(showvolumeo);
		showvolumeo = "";
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==volumeplus){
			board.volumeup();
			changevolumetext();	
		}else if(e.getSource()==volumeminus){
			board.volumedown();
			changevolumetext();	
		}else if(e.getSource()==changeBGb){
			do{
				bgnum = rand.nextInt(4) + 1;
			}while(board.currentbg == bgnum);
			board.changebg(bgnum);
		}else if(e.getSource()==back){
			this.removeAll();
			this.revalidate();
			this.repaint();
			
			setMenu();
		}
		
	}
	
	private void setMenu() {
		menupanel = new Menu(board);
		menupanel.setOpaque(false);
		menupanel.setLayout(null);
		
		board.add(menupanel,0);
		
	}
}
