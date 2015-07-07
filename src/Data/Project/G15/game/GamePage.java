package Data.Project.G15.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;



public class GamePage extends JFrame{
	private int ROW,COL,OP_RC,level;
	private int RAND_COUNT,SEC;//�üƲ��Ϧ���,�C�����j���
	private final int LEFT = 37,UP = 38, RIGHT = 39, DOWN = 40;//���ʤ�N�X
	private String passNum;//����ܪ��Ϥ�(�Ʀr)
	private LoadImageIcon loadImg;//Ū�����d�Ϥ�
	private Timer timer;
	private String [][] box;//�޿�W�b���ʪ��Ʀr�G���}�C
	private ImageIcon [][] pieceJpg;//�n���ӶK�Ϫ��G���}�C�Ϥ�(���L���Ϥ�)
	private JLabel [][] jl;//��Ϫ�label
	private JPanel panel,indexPanel;
	private JMenuItem [] setOP,gm;
	private boolean isStart; //�C���i�檬�A   true:�i�椤

	public GamePage(){
		super("Puzzle");
		OP_RC = 3;//�w�] 3 x 3
		RAND_COUNT = 200;//�ü�200��
		SEC = 2;	//��2��~���U�@��
		level = 1;//�q��1���}�l

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loadImg = new LoadImageIcon();

		indexPanel = getIndexImg(loadImg,0);//�β�0�i�Ϥ���ʭ�
		getContentPane().add(indexPanel);

		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb); //�[�J�u��C

		JMenu game = new JMenu("�C��");	


		gm = new JMenuItem[3];
		JMenuItem [] abo = new JMenuItem[2];
		setOP = new JMenuItem[2];

		//�C������ܶ���
		jmb.add(game);
		gm[0] = new JMenuItem("�s��");
		gm[0].setName("new");
		gm[1] = new JMenuItem("���");
		gm[1].setName("giveUp");
		gm[2] = new JMenuItem("�����C��");
		gm[2].setName("exit");
		game.add(gm[0]);
		game.add(gm[1]);
		game.addSeparator();
		game.add(gm[2]);
		gm[1].setEnabled(false);

		setOP[0] = new JMenuItem("3 x 3");
		setOP[0].setName("3");
		setOP[1] = new JMenuItem("4 x 4");
		setOP[1].setName("4");

		abo[0] = new JMenuItem("�C������");
		abo[0].setName("detail");
		abo[1] = new JMenuItem("�@��");
		abo[1].setName("author");

		ButtonHandler bh = new ButtonHandler();//�\����ƥ�
		keyLis kl = new keyLis();//��L�ƥ�

		//���U�\�����ť��
		gm[0].addActionListener(bh);
		gm[1].addActionListener(bh);
		gm[2].addActionListener(bh);

		abo[0].addActionListener(bh);
		abo[1].addActionListener(bh);

		setOP[0].addActionListener(bh);
		setOP[1].addActionListener(bh);

		//���U��L��ť��
		addKeyListener(kl); 
		setSize(loadImg.imgW,loadImg.imgH + 50);
	}

	/**
	 * ��l�ƹC���ܼ�
	 * @param isResetBox true:���ë��� | false �����ë���
	 * @param level ��n�����Ϥ�
	 */
	private void initPiece2(boolean isResetBox,int level){
		if(ROW != OP_RC){
			setRowCol(OP_RC);
			addRowColJlabel();
		}

		passNum = String.valueOf(ROW * COL);
		pieceJpg = new ImageIcon[ROW][COL];
		box = new String[ROW][COL];
		isStart = isResetBox;

		//�]�w�޿�W�b���ʪ��Ʀr��m
		for(int i = 0; i < (ROW * COL); i++){
			box[i/ROW][i%COL] = String.valueOf(i+1);
		}

		//����level�����L�Ϥ�
		pieceJpg = loadImg.getPieceImg(level, ROW, COL);

		if(isResetBox){
			//�ζüƥ��üƦr���ƦC
			for(int count = 0; count < RAND_COUNT; count++){
				movePiece(box,(int)(Math.random()*4)+LEFT,passNum);
			}
			repaintGame();
		}
	}

	/**
	 * ���o�K�F�Ϥ���panel
	 * @param index
	 * @return
	 */
	public JPanel getIndexImg(LoadImageIcon load , int index){
		JLabel tmplb = new JLabel(load.img[index]);
		JPanel pn = new JPanel();
		pn.add(tmplb);
		return pn;
	}

	/**
	 * ����n���A�}�l����
	 * @param sec			���ݴX��
	 * @param level			���d
	 * @param currentImg
	 */
	public void nextLevel(final int sec, final int level, ImageIcon currentImg){
		timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				initPiece2(true,level);
			}
		};
		timer.schedule(task, sec * 1000);
	}

	/**
	 * �]�wrow �Pcol
	 * @param n
	 */
	public void setRowCol(int n){
		ROW = n;
		COL = n;
	}

	/**
	 * ���s�ƪ� 
	 */
	public void addRowColJlabel(){
		Container c = getContentPane();
		if(panel != null){
			c.remove(panel);//������ܤ�������Ϥ�
		}
		panel = new JPanel(new GridLayout(ROW,COL));//�N�]�w�����s�� row * col

		jl = new JLabel [ROW][COL];
		for(int i = 0; i < jl.length; i++){
			for(int j = 0; j < jl.length; j++){
				jl[i][j] = new JLabel();
				panel.add(jl[i][j]);
			}
		}

		c.add(panel);
	}

	/**
	 * ���e���Ϧ�m
	 */
	public void repaintGame(){
		for(int i = 0; i < box.length; i ++){
			for(int j = 0; j < box[i].length; j ++){
				int jpgIndex = Integer.parseInt(box[i][j]) - 1;
				jl[i][j].setIcon(null);//����쥻���ϲM��
				if(jpgIndex != ROW * COL - 1){//�̫�@�i�Ϥ����
					jl[i][j].setIcon(pieceJpg[jpgIndex/ROW][jpgIndex%COL]);//��W�s����
				}
			}
		}
		repaint();
	}

	//��L�ƥ�B�z
	private class keyLis implements KeyListener{
		public void keyPressed(KeyEvent e){
			if(isStart){
				movePiece(box,e.getKeyCode(),passNum);
				repaintGame();

				//�ˬd�O�_�Ϥ�1~8���b���T��m�l�A���@�i����N���}�ˬd�j��
				boolean pass = true;
				for(int i=0; i< (ROW * COL) - 1; i++){
					pass = box[i/ROW][i%COL].equals(String.valueOf(i+1));
					if(!pass) break;
				}

				if(pass){
					isStart = false;
					jl[ROW - 1][COL - 1].setIcon(pieceJpg[ROW - 1][COL - 1]);//��̫�@�i�ϸɤW

					JOptionPane.showMessageDialog(null, "�L���F!!", "�T��",JOptionPane.INFORMATION_MESSAGE);

					//�ˬd�O�_���U�@���A�ø߰ݬO�_�i��U�@��

					level++;
					if(level < loadImg.size && JOptionPane.showConfirmDialog(null, "�i��U�@��?", "�T��",JOptionPane.YES_NO_OPTION) == 0){
						nextLevel(SEC,level,loadImg.img[level]);                                     
					}else{
						JOptionPane.showMessageDialog(null, "���߱z�}���F!!", "�T��",JOptionPane.INFORMATION_MESSAGE);
						stopGame();
					}
				}
			}
		}

		public void keyReleased(KeyEvent e){}        
		public void keyTyped(KeyEvent e){}
	}


	public void movePiece(String [][] box,int keyNum,String passN){
		String temp = passN;
		int [] loaction = getPassNumLocation(box,passN);  //���o" "����m

		switch(keyNum){
		case LEFT: //������
			if(loaction[1]+1<box[loaction[0]].length){
				temp = box[loaction[0]][loaction[1]+1];
				box[loaction[0]][loaction[1]+1] = passN;
			}
			break;
		case UP: //���W��
			if(loaction[0]+1<box.length){
				temp = box[loaction[0]+1][loaction[1]];
				box[loaction[0]+1][loaction[1]] = passN;
			}                                        
			break;
		case RIGHT: //���k��
			if(loaction[1]-1 >= 0){
				temp = box[loaction[0]][loaction[1]-1];
				box[loaction[0]][loaction[1]-1] = passN;
			}        
			break;
		case DOWN: //���U��
			if(loaction[0]-1 >= 0){
				temp = box[loaction[0]-1][loaction[1]];
				box[loaction[0]-1][loaction[1]] = passN;
			}                                                                                        
			break;
		default:                
		}
		box[loaction[0]][loaction[1]] = temp;
	}

	/**
	 * ���o�Ʀr9����m
	 * @param boxArr
	 * @return
	 */
	private int [] getPassNumLocation(String [][] boxArr,String passN){
		int location[] = new int[2];

		for(int r = 0; r < boxArr.length; r++){
			for(int c = 0; c < boxArr[r].length; c++){
				if(boxArr[r][c].equals(passN)){
					location[0] = r;  //" "��x��m
					location[1] = c;  //" "��y��m
					return location;
				}
			}
		}
		return location;
	}

	//�\����ƥ�B�z
	private class ButtonHandler implements  ActionListener{
		public void actionPerformed(ActionEvent ae){
			String name = ((Component)ae.getSource()).getName();
			if(name.equals("new")){//�s��                              
				startGame();
			}else if(name.equals("giveUp")){
				stopGame();
			}else if(name.equals("3") || name.equals("4")){
				OP_RC = Integer.parseInt(name);
			}else if(name.equals("exit")){//�����C��
				System.exit(0);
			}

		}
	}

	/**
	 * �}�l�s���C��
	 */
	public void startGame(){
		gm[0].setEnabled(false);
		gm[1].setEnabled(true);
		setOP[0].setEnabled(false);
		setOP[1].setEnabled(false);
		indexPanel.setVisible(false);
		nextLevel(0,level,loadImg.img[level]);
	}

	/**
	 * ���C��
	 *
	 */
	public void stopGame(){
		isStart = false;
		gm[0].setEnabled(true);
		gm[1].setEnabled(false);
		setOP[0].setEnabled(true);
		setOP[1].setEnabled(true);
		if(timer != null){
			timer.cancel();
			timer = null; 
		}
		close();
	}

	/**
	 * �C������
	 */
	public void close(){
		setRowCol(0);
		level = 1;//�q��1���}�l
		if(panel != null){
			getContentPane().remove(panel);
			panel = null;
		}
		timer = null;
		indexPanel.setVisible(true);
	}


}

