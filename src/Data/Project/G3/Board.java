package Data.Project.G3;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Board extends JFrame {

	private Menu menupanel;
	private Games gamespanel;
	private Option optionpanel;

	private ImageIcon backgroundImg1;
	private ImageIcon backgroundImg2;
	private ImageIcon backgroundImg3;
	private ImageIcon backgroundImg4;
	private ImageIcon hitmousebgImg;
	private ImageIcon carbgImg;
	private ImageIcon mazebgImg;

	private JLabel background;

	private AudioPlayer Sunday_Plans;
	private AudioPlayer Sioux_Falls;
	private AudioPlayer Giant_Leap;

	private int showvolumen = 5;
	private int bgnum;
	private Random rand;
	protected int currentbg = 1;
	
	protected boolean clear1 = false;
	protected boolean clear2 = false;
	protected boolean clear3 = false;
	protected boolean clear4 = false;
	protected boolean clear5 = false;
	protected boolean clear6 = false;
	protected boolean clear7 = false;
	protected boolean clear8 = false;
	protected boolean clear9 = false;
	protected boolean clear10 = false;
	protected boolean clear11 = false;
	protected boolean clear12 = false;
	protected boolean clear13 = false;
	protected boolean clear14 = false;
	protected boolean clear15 = false;

	public Board() {
		rand = new Random();

		setBG();
		setMusic();

		menupanel = new Menu(this);
		menupanel.setOpaque(false);
		menupanel.setLayout(null);

		add(menupanel, 0);
	}

	public void setBG() {

		backgroundImg1 = new ImageIcon(
				Board.class.getResource("objects\\background1.jpg"));

		backgroundImg2 = new ImageIcon(
				Board.class.getResource("objects\\background2.jpg"));

		backgroundImg3 = new ImageIcon(
				Board.class.getResource("objects\\background3.jpg"));

		backgroundImg4 = new ImageIcon(
				Board.class.getResource("objects\\background4.jpg"));

		hitmousebgImg = new ImageIcon(
				Board.class.getResource("objects\\hitmousebg.png"));

		carbgImg = new ImageIcon(Board.class.getResource("objects\\carbg.jpg"));

		mazebgImg = new ImageIcon(Board.class.getResource("objects\\mazebg.jpg"));

		background = new JLabel(backgroundImg1);
		background.setBounds(0, 0, 1000, 700);

		getContentPane().add(background, -1);

	}

	public void changebg(int bgnum) {
		this.remove(background);
		this.revalidate();
		this.repaint();

		switch (bgnum) {
		case 1:
			background = new JLabel(backgroundImg1);
			currentbg = bgnum;
			break;
		case 2:
			background = new JLabel(backgroundImg2);
			currentbg = bgnum;
			break;
		case 3:
			background = new JLabel(backgroundImg3);
			currentbg = bgnum;
			break;
		case 4:
			background = new JLabel(backgroundImg4);
			currentbg = bgnum;
			break;
		case 5:
			background = new JLabel(hitmousebgImg);
			break;
		case 6:
			background = new JLabel(carbgImg);
			break;
		case 7:
			background = new JLabel(mazebgImg);
			break;
		}
		
		
		background.setBounds(0, 0, 1000, 700);

		getContentPane().add(background, -1);
	}

	public void setMusic() {
		Sunday_Plans = new AudioPlayer(
				Board.class.getResource("objects\\Sunday_Plans.wav"));

		Sioux_Falls = new AudioPlayer(
				Board.class.getResource("objects\\Sioux_Falls.wav"));
		Giant_Leap = new AudioPlayer(
				Board.class.getResource("objects\\Giant_Leap.wav"));

		Sunday_Plans.play();

	}

	public void volumeup() {

		try {
			Sunday_Plans.setVolume(Sunday_Plans.getVolume() + 10);

			Sioux_Falls.setVolume(Sioux_Falls.getVolume() + 10);
			Giant_Leap.setVolume(Giant_Leap.getVolume() + 10);
			showvolumen++;
		} catch (RuntimeException e) {

		}

	}

	public void volumedown() {

		try {
			Sunday_Plans.setVolume(Sunday_Plans.getVolume() - 10);

			Sioux_Falls.setVolume(Sioux_Falls.getVolume() - 10);
			Giant_Leap.setVolume(Giant_Leap.getVolume() - 10);
			showvolumen--;
		} catch (RuntimeException e) {

		}

	}

	public void stopMusic() {
		Sunday_Plans.stop();

		Sioux_Falls.stop();
		Giant_Leap.stop();
	}

	public AudioPlayer getSunday_Plans() {
		return Sunday_Plans;
	}

	public AudioPlayer getSioux_Falls() {
		return Sioux_Falls;
	}

	public AudioPlayer getGiant_Leap() {
		return Giant_Leap;
	}

	public int getShowvolumen() {
		return showvolumen;
	}

}
