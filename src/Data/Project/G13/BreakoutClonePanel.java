package Data.Project.G13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BreakoutClonePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	public static final int iWidth = 650;
	public static final int iHeight = 490;
	private int x;
	private int mode_bar=0;
	private int mode_ball=0;
	private boolean move = true;
	private final int ADDLIFE=1;
	private final int ADDLONGERBAR=2;
	private final int ADDSHORTERBAR=3;
	private final int KILL=4;
	private final int MEGABALL=5;
	private final int SHRINDBALL=6;
	private final int DOWNFLOOR=7;
	private final int SLOWBALL=8;
	private final int FASTBALL=9;
	private Image icon_bar;
	private Image icon_ball;
	private Image icon_downfloor = new ImageIcon(getClass().getResource("downfloor.png")).getImage();
	private Image icon_medianball = new ImageIcon(getClass().getResource("ball.png")).getImage();
	private Image icon_medianbar = new ImageIcon(getClass().getResource("bar.png")).getImage();
	private Image icon_redbric = new ImageIcon(getClass().getResource("redbric.png")).getImage();
	private Image icon_bluebric = new ImageIcon(getClass().getResource("bluebric.png")).getImage();
	private Image icon_pinkbric = new ImageIcon(getClass().getResource("pinkbric.png")).getImage();
	private Image icon_life = new ImageIcon(getClass().getResource("life.png")).getImage();
	private Image icon_addLife = new ImageIcon(getClass().getResource("add_life.png")).getImage();
	private Image icon_addLongerBar = new ImageIcon(getClass().getResource("add_longerBar.png")).getImage();
	private Image icon_LongerBar = new ImageIcon(getClass().getResource("LongerBar.png")).getImage();
	private Image icon_shorterBar = new ImageIcon(getClass().getResource("shorterBar.png")).getImage();
	private Image icon_addshorterBar = new ImageIcon(getClass().getResource("add_shorterBar.png")).getImage();
	private Image icon_killLife = new ImageIcon(getClass().getResource("kill.png")).getImage();
	private Image icon_addmegaball = new ImageIcon(getClass().getResource("add_megaball.png")).getImage();
	private Image icon_megaball = new ImageIcon(getClass().getResource("megaball.png")).getImage();
	private Image icon_addshrindball = new ImageIcon(getClass().getResource("add_shrindball.png")).getImage();
	private Image icon_shrindball = new ImageIcon(getClass().getResource("shrindball.png")).getImage();
	private Image icon_addslowball = new ImageIcon(getClass().getResource("add_slowball.png")).getImage();
	private Image icon_addfastball = new ImageIcon(getClass().getResource("add_fastball.png")).getImage();
	private int xBar = 0, yBar = 0, xBall = 0, yBall = 0, xMove = 5, yMove = 5,xLife,yLife;
	private int iconBallWidth, iconBallHeight, iconBarWidth, iconBarHeight, iconbricWidth, iconbricHeight, LIFE = 3;
	private int iconLifeWidth,iconLifeHeight,iconAddLifeWidth,iconAddLifeHeight;
	private int xAdd=0,yAdd=-30;
	private boolean b;
	private boolean add,downfloor,dropping;
	private Timer t;
	private int iconScoreX,iconScoreY,iScore=0;
	private Image imBuffer;// 蝺抵��
	private int randX;

	Random random = new Random();
	private Graphics back;
	boolean bCheckbar[][];
	private int addEvent;
	private int downfloor_level=0;
	//private static myMusicPlay audioPlayWave_game,audioPlayWave2;
	Clayout c;

	public BreakoutClonePanel() {
//		audioPlayWave_game = new myMusicPlay("DX_Ball2.wav");// 撘��銋�
//		audioPlayWave_game.start();
		// setSize & setVisible 撅祆JPanel��un
		iconBallWidth = icon_medianball.getWidth(this);// ��祝
		iconBallHeight =icon_medianball.getHeight(this);// ����
		iconBarWidth = icon_medianbar.getWidth(this);// ��祝
		iconBarHeight = icon_medianbar.getHeight(this);// ����
		iconbricWidth = icon_redbric.getWidth(this);// 蝤�祝
		iconbricHeight = icon_redbric.getHeight(this);// 蝤���
		iconLifeWidth = icon_life.getWidth(this);
		iconLifeHeight = icon_life.getHeight(this);
	//	iconAddLifeWidth = icon_addLife.getWidth(this);
	//	iconAddLifeHeight = icon_addLife.getHeight(this);
		icon_bar=icon_medianbar;
		iconScoreX=500;
		iconScoreY=20;
		bCheckbar = new boolean[12][10];
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		t = new Timer(20, this);
		initial();
	}

	public void initial() { // ����蝙��
		xBar = iWidth / 2; // ���蜇����葉���
		yBar = iHeight - iconBarHeight - 10; // 蝮賜�皜�����漲�����
		xLife = 2;
		yLife = 5;
		xBall = xBar + iconBarWidth / 2 - iconBallWidth / 2;
		yBall = yBar - iconBallHeight;
		iScore=0;
		move = true;
		b = false;
		mode_bar=0;
		yAdd=-30;
	//	dropping=false;
		icon_bar=icon_medianbar;
		icon_ball=icon_medianball;
		iconBarWidth=icon_bar.getWidth(this);
		iconBarHeight=icon_bar.getHeight(this);
		iconBallWidth=icon_medianball.getWidth(this);
		iconBallHeight=icon_medianball.getHeight(this);
		randX=random.nextInt(600);
		addEvent=randX%10;
		for (int i = 0; i < bCheckbar.length; i++) {
			for (int j = 0; j < bCheckbar[i].length; j++) {
				bCheckbar[i][j] =true;
			}
		}
		repaint();
	}

	public void init2() { // ��摰�摰�
		move = false;
	//	dropping=false;
		LIFE--;
		icon_ball=icon_medianball;
		iconBallWidth = icon_medianball.getWidth(this);
		iconBallHeight = icon_medianball.getHeight(this);
		icon_bar=icon_medianbar;
		iconBarWidth = icon_medianbar.getWidth(this);// ��祝
		iconBarHeight = icon_medianbar.getHeight(this);
		b = false;
		System.out.printf("LiFE =%d\n", LIFE);
		if (LIFE <= 0) {
			new Over1(iScore);
			LIFE=3;
			downfloor_level=0;
			initial();
		}
		t.stop();
		try {
			Thread.sleep(500);
		//	if (yBall >= iHeight)System.out.printf("@@%d", yBall);
			xBall = xBar + iconBarWidth / 2 - iconBallWidth / 2;
			yBall = yBar - iconBallHeight;
			xMove = 5;
			yMove = 5;
			yAdd=-30;
			move = true;
		} catch (Exception e) {
		}
		repaint();

	}

	public void init3() { // ����摰�
		
//		System.out.printf("!!!%d", yBall);
	//	if (yBall >= iHeight)
		//	System.out.printf("@@%d", yBall);
		xBall = xBar + iconBarWidth / 2 - iconBallWidth / 2;
		yBall = yBar - iconBallHeight;
		xMove = 5;
		yMove = 5;
		move = true;
		b = true;
	//	dropping=false;
		repaint();
	}

	public void paint(Graphics g) {
		// super.paintComponents(g);//����辣		
		if (move) {
			int iBricX=0,iBricY=0;
			if(LIFE<=0)init2();
			imBuffer = createImage(iWidth, iHeight);
			back = imBuffer.getGraphics();
			back.drawImage(icon_ball, xBall, yBall, this); // 憿舐內���
			back.drawImage(icon_bar, xBar, yBar, this); // 憿舐內����
			//System.out.printf("dropping -- %b\n",dropping);

			switch(addEvent){
					case ADDLIFE :
						back.drawImage(icon_addLife,xAdd, yAdd,this);
						break;
					case ADDLONGERBAR:
						back.drawImage(icon_addLongerBar,xAdd, yAdd,this);
						break;
					case ADDSHORTERBAR:
						back.drawImage(icon_addshorterBar,xAdd, yAdd,this);
						break;
					case KILL:
						back.drawImage(icon_killLife,xAdd, yAdd,this);
						break;
					case MEGABALL:
						back.drawImage(icon_addmegaball, xAdd, yAdd, this);
						break;
					case SHRINDBALL:
						back.drawImage(icon_addshrindball, xAdd, yAdd, this);
						break;
					case DOWNFLOOR:
						back.drawImage(icon_downfloor, xAdd, yAdd, this);
						break;
					case SLOWBALL:
						back.drawImage(icon_addslowball, xAdd, yAdd, this);
						break;
					case FASTBALL:
						back.drawImage(icon_addfastball, xAdd, yAdd, this);
						break;
				}
			for(int i =0;i<LIFE;i++){
				back.drawImage(icon_life, xLife+i*iconLifeWidth, yLife, this); // 憿舐內��
			}
			
			int bric_num=0;
			for (int i = 0; i < bCheckbar.length; i++) {// 撠赤�������
				for (int j = 0; j < bCheckbar[i].length; j++) {
					if(downfloor){
						System.out.printf("down\n");
						downfloor_level=downfloor_level+2;
						downfloor=false;
					}
					if (!bCheckbar[i][j]){
						bric_num++;
						if(bric_num==120)end();
						//System.out.printf("bric_num=%d\n",bric_num);
 					    continue;// 撌脫���歲���鼓�
					}
					iBricX = (i + 2) * iconbricWidth+iconbricWidth/2;
					iBricY = (j + 5+downfloor_level) * iconbricHeight;
					int iBricAreaX = iBricX + iconbricWidth;
					int iBricAreaY = iBricY + iconbricHeight;
					if (xBall >= iBricX && xBall <= iBricAreaX && yBall > iBricY && yBall <= iBricAreaY) {// 撌脫�葉
					if ((xBall >= iBricX && xBall <= (iBricX + iconBallWidth))
								|| (xBall <= iBricAreaX && xBall >= (iBricAreaX - xMove))) {
							xMove = -xMove;
						} else yMove = -yMove;
						bCheckbar[i][j] = false;
						if(iBricX<=200)iScore += 1;
						else if(iBricX>200 && iBricX<400)iScore += 100;
						else{
							iScore += 10;
						}
						System.out.printf("addEvent=%d\n",addEvent);
			
						break;
						
					}
					
					if(i < bCheckbar.length/2){
						if(i<bCheckbar.length/2/2)back.drawImage(icon_redbric, iBricX, iBricY, this);
						else back.drawImage(icon_pinkbric, iBricX, iBricY, this);
					}
					if(i >= bCheckbar.length/2){			
						if(i>bCheckbar.length/3 && i<=bCheckbar.length*2/3)back.drawImage(icon_pinkbric, iBricX, iBricY, this);
						else back.drawImage(icon_bluebric, iBricX, iBricY, this);		
					}
					
				}
			}
			back.setFont(new Font("宋體",Font.BOLD, 20));
			back.setColor(Color.WHITE);
			back.drawString("Score " + iScore, iconScoreX, iconScoreY);
		    
	
			g.drawImage(imBuffer, 0, 0, this);
			if (xBall <= 0 || xBall >= iWidth - iconBallWidth -30)
				xMove = -xMove;// 撌血����
			if (yBall <= 20)
				yMove = -yMove;// 銝���
			if (xBall >= xBar && xBall <= xBar + iconBarWidth - iconBarWidth && yBall > yBar - iconBallHeight) {// ����漲
				yMove = -yMove;
			}else if (yBall >= iHeight - 30) {
				if (xBall >= (x - iconBarWidth / 2) && xBall <= (x + iconBarWidth / 2))
					init3();
				else
					init2();
				if(random.nextInt(2)==0){
					randX=random.nextInt(500);
					addEvent=randX%10;
					System.out.printf("addEvent=%d\n",addEvent);
					add=true;
					
				}
				System.out.printf("����摮�--add%b\n",add);
			}
			if(yAdd>= iHeight - iconBarHeight){
				if(xAdd >= (x - iconBarWidth / 2) && xAdd <= (x + iconBarWidth / 2)){
					acceptDownBox(addEvent);
				}else{
					skipDownBox();
				}
				yAdd=-30;
				add=false;
			}
		}
	}
	
	private void end(){
		System.out.printf("END\n");
		if(move){
			move=false;
			c.audioPlayWave.stop();
			JOptionPane.showMessageDialog(null, "Success ^^", "BreakoutClone", JOptionPane.WARNING_MESSAGE);
			
			initial();	
		}
		//new Over1(iScore);
	}
	//��
	 private void showDownBox(){
	        xAdd=randX;
	        yAdd=yAdd+5;
	//        //dropping=true;
	}
	private void acceptDownBox(int event){
//頩西髡�----憭望��
//		audioPlayWave2 = new myMusicPlay("Ball.wav");// 撘��銋�
//        audioPlayWave2.start();
//        try {
//			audioPlayWave2.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        audioPlayWave2.stop();
		System.out.printf("accept\n");
		switch(event){
			case ADDLIFE:
				if(LIFE<4){
					LIFE++;
				}
				break;
			case ADDLONGERBAR:
			    switch(mode_bar){
				    case 0: //敺葉霈
					System.out.printf("Longer");
					icon_bar=icon_LongerBar;
					iconBarWidth = icon_LongerBar.getWidth(this);// ��祝
					iconBarHeight = icon_LongerBar.getHeight(this);// ����
					mode_bar=1;
					break;
					
				    case -1: //敺霈葉
				    	icon_bar=icon_medianbar;
						iconBarWidth = icon_medianbar.getWidth(this);// ��祝
						iconBarHeight = icon_medianbar.getHeight(this);// ����
						mode_bar=0;
					break;
			    }
			    break;
			case ADDSHORTERBAR:
				System.out.printf("Shorter");
				switch(mode_bar){
				case 1://敺霈葉
					icon_bar=icon_medianbar;
					iconBarWidth = icon_medianbar.getWidth(this);// ��祝
					iconBarHeight = icon_medianbar.getHeight(this);// ����
					mode_bar=0;
					break;
				case 0://敺葉霈
					System.out.printf("shorter2");
					icon_bar=icon_shorterBar;
					iconBarWidth = icon_shorterBar.getWidth(this);// ��祝
					iconBarHeight = icon_shorterBar.getHeight(this);// ����
					mode_bar=-1;
				    break;
				}
				break;
			case KILL:
				LIFE--;
				break;
			case MEGABALL:
				switch(mode_ball){
					case 0://mode_ball=0 �銝剛�之���
						System.out.print("Mega");
						icon_ball=icon_megaball;
						iconBallWidth = icon_megaball.getWidth(this);
						iconBallHeight = icon_megaball.getHeight(this);
						mode_ball=1;
						break;
					case -1: //�撠��葉���
						System.out.print("Mega2");
						icon_ball=icon_medianball;
						iconBallWidth = icon_medianball.getWidth(this);
						iconBallHeight = icon_medianball.getHeight(this);
						mode_ball=0;
						break;
				}
				break;
			case SHRINDBALL:
				switch(mode_ball){		
				case 1:  //�憭扯�葉
					System.out.print("Shring");
					icon_ball=icon_medianball;
					iconBallWidth = icon_medianball.getWidth(this);
					iconBallHeight = icon_medianball.getHeight(this);
					mode_ball=0;
					break;
				case 0:  //�銝剛���
					System.out.print("Shring2");
					icon_ball=icon_shrindball;
					iconBallWidth = icon_shrindball.getWidth(this);
					iconBallHeight = icon_shrindball.getHeight(this);
					xMove=7;
					yMove=7;
					mode_ball=-1;
					break;
				}
				break;
			case DOWNFLOOR:
				if(downfloor_level<=6)downfloor=true;	
				break;
			case SLOWBALL:
				System.out.print("Slow");
				xMove = -1;
				yMove = -1;
				break;
			case FASTBALL:
				System.out.print("Fast");
				xMove=-6;
				yMove=-6;
				break;
		}
		
		
	}
	private void skipDownBox(){
		System.out.printf("skip\n");
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		x = e.getX();
		int mx = e.getX() - iconBarWidth / 2;
		if (mx + iconBarWidth >= iWidth || mx <= 0)
			return;
		xBar = mx;
		if (!b) {// ����宏���
			xBall = mx + iconBarWidth / 2;
			move = true;
			repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (move) {
			t.start();
			b = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (move) {
			xBall -= xMove;
			yBall -= yMove;
			if(add)showDownBox();
			repaint();
		}
	}

}
