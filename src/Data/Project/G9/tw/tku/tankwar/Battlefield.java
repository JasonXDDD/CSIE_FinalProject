package Data.Project.G9.tw.tku.tankwar;

import Data.Project.G9.tw.tku.tankwar.barriers.Barriers;
import Data.Project.G9.tw.tku.tankwar.barriers.BarriersSelector;
import Data.Project.G9.tw.tku.tankwar.map.RandomWordsMap;
import Data.Project.G9.tw.tku.tankwar.map.TMap;
import Data.Project.G9.tw.tku.tankwar.model.Bullet;
import Data.Project.G9.tw.tku.tankwar.model.Explosion;
import Data.Project.G9.tw.tku.tankwar.model.Tank;
import Data.Project.G9.tw.tku.tankwar.tank.HeroTank;
import Data.Project.G9.tw.tku.tankwar.tank.RandomTank;
import Data.Project.G9.tw.tku.tankwar.util.AudioLoader;
import Data.Project.G9.tw.tku.tankwar.util.IConstants;
import Data.Project.G9.tw.tku.tankwar.util.ImageLoader;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * battlefield for tank war .
 * @author	BB
 * @version	1.0
 */
public class Battlefield extends JFrame {

	public static final int GAME_OVERED = -1;
	public static final int GAME_PUSHED = 0;
	public static final int GAME_BARRIER_SELECT = 1;
	public static final int GAME_MAP_SELECT = 2;
	public static final int GAME_RUNING = 3;
	public static final int GAME_FAILED = 4;
	public static final int GAME_SUCCEED = 5;
	
	public static final int SIMPLE_MODE = 1;
	public static final int STANDART_MODE = ~SIMPLE_MODE;
	
	
	public static Object lock = new Object();
	public static Dimension w_size = new Dimension(640, 512);
	public static ExecutorService tpool = Executors.newCachedThreadPool();
	
	//圖片資源
	public static Image[] background = null;
	public static Image[] heroImages = null;
	public static Image[][] enemyImages = null;
	public static Image[] bulletImages = null;
	public static Image[] wallImages = null;
	public static Image[][] explosionImages = null;
	public static Image helpImage = null;
	
	public int bgWidth = 0;
	public int bgHeight = 0;
	
	//元件
	private BattleCanvas canvas = null;
	private TMap tankmap = null;
	private HeroTank hero = null;
	private HashMap<Integer, Tank> tanks = null;
	private ArrayList<Bullet> bullets = null;
	private ArrayList<Explosion> explosions = null;
	
	//用戶介面
	private BarriersSelector bselector = null;
	private GameResult gresult = null;
	
	private int state = GAME_BARRIER_SELECT;
	private Barriers[] barriersSetting = GameBarriers.DEFAULT;
	private int barriers = 0;
	private boolean sound = true;		//開啟遊戲聲音
	private int bg = 0;					
	private GameHelp gameHelp = null;
	private int mode = STANDART_MODE;
	
	//聲效
	private AudioClip explosionClip[] = null;
	
	//雙 Buffer
	private Image bufferImage = null;
	private Graphics bufferScreen = null;
	
	public Battlefield() {
		setTitle("Tank War");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setResizable(false);
		canvas = new BattleCanvas();
		c.add(canvas);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * 		初始化資源：<br/>
	 * 1.加載玩家tank資源. <br/>
	 * 2.加載敵人tank資源. <br/>
	 * 3.加載爆炸效果資源. <br/>
	 * 4.加載子彈資源. 
	 */
	public void loadResource() {
		
		bufferImage = createImage(w_size.width, w_size.height);
		bufferScreen = bufferImage.getGraphics();
		addKeyListener(new TankKeyListener());
		
		//加載背景
		ImageIcon bg = ImageLoader.loadImageIcon("bg-green.gif");
		background = new Image[] {
			bg.getImage(),
			ImageLoader.loadImageIcon("bg-grass.jpg").getImage(),
			ImageLoader.loadImageIcon("bg-sand.jpg").getImage()
		};
		bgWidth = bg.getIconWidth();
		bgHeight = bg.getIconHeight();
		
		//玩家坦克資源
		heroImages = new Image[] {
			ImageLoader.loadImageIcon("tank/hero/1/hero-u.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-ru.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-r.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-rd.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-d.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-ld.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-l.png").getImage(),
			ImageLoader.loadImageIcon("tank/hero/1/hero-lu.png").getImage()	
		};
		//敵人坦克資源
		enemyImages = new Image[][] {
			new Image[] {
				ImageLoader.loadImageIcon("tank/enemy/1/tank-u.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-ru.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-r.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-rd.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-d.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-ld.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-l.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/1/tank-lu.png").getImage()	
			},
			new Image[] {
				ImageLoader.loadImageIcon("tank/enemy/2/tank-u.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-ru.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-r.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-rd.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-d.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-ld.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-l.png").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/2/tank-lu.png").getImage()	
			},
			new Image[] {
				ImageLoader.loadImageIcon("tank/enemy/3/tank-u.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-ru.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-r.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-rd.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-d.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-ld.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-l.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/3/tank-lu.gif").getImage()	
			},
			new Image[] {
				ImageLoader.loadImageIcon("tank/enemy/4/tank-u.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-ru.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-r.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-rd.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-d.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-ld.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-l.gif").getImage(),
				ImageLoader.loadImageIcon("tank/enemy/4/tank-lu.gif").getImage()	
			}
		};
		//子彈資源
		bulletImages = new Image[] {
			ImageLoader.loadImageIcon("bullet/normal.png").getImage(),
			ImageLoader.loadImageIcon("bullet/bomb.png").getImage(),
			ImageLoader.loadImageIcon("bullet/missile.png").getImage()	
		};
		//牆資源
		wallImages = new Image[] {
			ImageLoader.loadImageIcon("wall/grass.gif").getImage(),
			ImageLoader.loadImageIcon("wall/wood.gif").getImage(),
			ImageLoader.loadImageIcon("wall/brick.gif").getImage(),
			ImageLoader.loadImageIcon("wall/iron.gif").getImage()
		};
		//爆炸資源
		explosionImages = new Image[][] {
			new Image[] {
				ImageLoader.loadImageIcon("explosion/1.png").getImage(),
				ImageLoader.loadImageIcon("explosion/2.png").getImage(),
				ImageLoader.loadImageIcon("explosion/3.png").getImage(),
				ImageLoader.loadImageIcon("explosion/4.png").getImage(),
				ImageLoader.loadImageIcon("explosion/5.png").getImage(),
				ImageLoader.loadImageIcon("explosion/6.png").getImage()
			},
			new Image[] {
				ImageLoader.loadImageIcon("explosion/big/1.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/2.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/3.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/4.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/5.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/6.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/7.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/8.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/9.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/10.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/11.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/12.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/13.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/14.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/15.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/16.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/17.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/18.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/19.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/20.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/21.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/22.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/23.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/24.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/25.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/26.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/27.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/28.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/29.png").getImage(),
				ImageLoader.loadImageIcon("explosion/big/30.png").getImage()
			}
		};
		//創建遊戲幫助
		gameHelp = new GameHelp(200, 200);
		
		//爆炸聲效
		explosionClip = new AudioClip[] {
			AudioLoader.loadAudio("s-explosion.wav"),
			AudioLoader.loadAudio("b-explosion.wav")
		};
		
		
		//用戶介面
		bselector = new BarriersSelector(this, 1, barriersSetting.length,
				60, w_size.width, w_size.height,
				new ImageIcon[] {
				ImageLoader.loadImageIcon("barriers/title.png"),
				ImageLoader.loadImageIcon("barriers/pointer.png"),
				ImageLoader.loadImageIcon("barriers/grass.gif")},
				AudioLoader.loadAudio("barriers/done.wav")
		);
		
		short width = IConstants.X_OFFSET, height = IConstants.Y_OFFSET;
		tankmap = new TMap(w_size.height / height, w_size.width / width,
					width, height, null);
		
		canvas.setBufferImage(bufferImage);
		start();				//開始執行緒
	}
	
	public TMap getMap() {
		return tankmap;
	}
	
	/**
	 *  	開始遊戲 
	 * 1. 清空舊的原件
	 * 2. 生成遊戲原件
	 * 3. 狀態改變成GAME_RUNING . 
	 */
	public void play( int idx ) {
		gresult = null;				//重新生成用戶介面
		hero = null;				//清空玩家tank
		if ( tanks != null ) tanks.clear();
		if ( bullets != null ) bullets.clear();
		if ( explosions != null ) explosions.clear();
		tankmap.clear();			//清空地圖
		System.gc();				//垃圾回收
		bselector.stopAudio();		//停止聲效
		create( barriersSetting[idx] );
		state = GAME_RUNING;
	}
	
	/**
	 * 		初始化battlefield <br/>
	 * 1.生成新的玩家tank
	 * 2.生成新的敵人tank
	 * 3.生成爆炸效果
	 * 4.生成子彈容器
	 */
	private void create( Barriers barrier ) {	
		
		//獲得亂數背景
		bg = ( (int) (Math.random() * 10000) ) % background.length;
		
		//玩家tank
		int width = IConstants.T_WIDTH, height = IConstants.T_WIDTH;
		tanks = new HashMap<Integer, Tank>(16, 0.85F);
		TankFactory.reset();
		hero = TankFactory.createCenterHeroTank(this, width, height, barrier.getHeroArgs());
		tanks.put(hero.getSerial(), hero);
		
		//敵人tank
		width = IConstants.T_WIDTH; height = IConstants.T_WIDTH;
		int tanknum = TankFactory.DEFAULT_TANK_OUTPUT;
		if ( barrier.getEnemyNumber() < tanknum ) tanknum = barrier.getEnemyNumber();
		RandomTank etank;
		for ( int j = 0; j < tanknum; j++ ) {
			etank = TankFactory.createRandomTank(this, width, height, barrier.getEnemyArgs());
			tanks.put(etank.getSerial(), etank);
		}
		
		//設置牆體
		tankmap.setWalls(RandomWordsMap.generate(
				wallImages, 8, 8,
				tankmap.getCols() - 2 * hero.getCols(),
				tankmap.getRows() - 2 * hero.getRows(), hero.getCols(), hero.getRows() ));
		
		//子彈庫
		BulletFactory.heroDamage = barrier.getHeroBulletArgs();
		BulletFactory.enemyDamage = barrier.getEnemyBulletArgs();
		bullets = new ArrayList<Bullet>();
		
		//爆炸 by ArrayList
		explosions = new ArrayList<Explosion>();
	}
	
	/**
	 * 從執行緒開始遊戲
	 */
	private void start() {
		new Thread(new Runnable() {
			public void run() {
				while ( true ) {
					if ( state == GAME_OVERED ) break;
					if ( state == GAME_PUSHED ) {
						synchronized ( lock ) {
							try {lock.wait();} catch (InterruptedException e) {break;}
						}
					}
					try {Thread.sleep(30);} catch (InterruptedException e) {break;}
					
					switch ( state ) {
					case GAME_BARRIER_SELECT: bselector.draw(bufferScreen); break;
					case GAME_MAP_SELECT:	break;
					case GAME_RUNING: runningDraw(); break;
					case GAME_FAILED:
					case GAME_SUCCEED:
						if ( gresult != null ) gresult.draw(bufferScreen);
						break;
					}
					//遊戲幫助
					if ( gameHelp.isVisible() ) 
						bufferScreen.drawImage(gameHelp.getHelpImage(),
							(w_size.width - gameHelp.getWidth()) / 2,
							(w_size.height - gameHelp.getHeight()) / 2, null);
					
					//刷新畫面
					canvas.repaint();
				}
			}
		}).start();
	}
	
	/**
	 * 創建遊戲幫助介面
	 */
	public GameResult createGR( int ret ) {
		ImageIcon icon = (ret == GAME_SUCCEED) ? ImageLoader.loadImageIcon("barriers/grass.gif")
				: ImageLoader.loadImageIcon("barriers/sand.gif");
		return new GameResult(w_size.width, w_size.height, ret, 2, icon);
	}
	
	/**
	 * 生成戰場
	 */
	public void runningDraw() {
		//背景
		drawBackground(bufferScreen);
		
		//玩家tank
		if ( hero.isAlive() ) hero.draw(bufferScreen);
		else {
			state = GAME_FAILED;
			gresult = createGR(GAME_FAILED);
		}
			
		//敵人tank
		if ( tanks.size() == 1 ) {		//勝利條件判定：當且僅當玩家tank是唯一的存活tank
			state = GAME_SUCCEED;
			gresult = createGR(GAME_SUCCEED);
		}
		Iterator<Entry<Integer, Tank>> eit = tanks.entrySet().iterator();
		Tank etank;
		boolean _new = false;
		while ( eit.hasNext() ) {
			Entry<Integer, Tank> e = eit.next();
			etank = e.getValue();
			if ( ! etank.isAlive() ) {
				eit.remove();			//tank死亡
				_new = true;
			}
			else etank.draw(bufferScreen);
		}
		if ( _new ) {	//增加新tank
			if ( TankFactory.getTankOutput() 
					< barriersSetting[bselector.getBarriers() - 1].getEnemyNumber() ) {
				etank = TankFactory.createRandomTank(this, IConstants.T_WIDTH, IConstants.T_WIDTH, barriersSetting[bselector.getBarriers() - 1].getEnemyArgs());
				tanks.put(etank.getSerial(), etank);
			}
		}
		
		//子彈
		synchronized ( bullets ) {
			Iterator<Bullet> bit = bullets.iterator();
			Bullet btemp;
			while ( bit.hasNext() ) {
				btemp = bit.next();
				if ( ! btemp.isAlive() ) bit.remove();
				else btemp.draw(bufferScreen);
			}
		}
		
		//刷新畫面 (在爆炸後)
		tankmap.draw(bufferScreen);
		
		//爆炸
		Iterator<Explosion> expit = explosions.iterator();
		Explosion exp;
		while ( expit.hasNext() ) {
			exp = expit.next();
			if ( exp.isAlive() ) exp.draw(bufferScreen);
			else expit.remove();
		}
		
		//顯示遊戲信息
		drawGameInfo(bufferScreen);
	}
	
	/**
	 *顯示當前戰鬥中右下角的遊戲信息
	 */
	private void drawGameInfo( Graphics g ) {
		String str = "Simple mode, Enemy:"+
				(barriersSetting[bselector.getBarriers() - 1]
						.getEnemyNumber() - TankFactory.getTankOutput() + tanks.size() - 1)
				+", Press h for Help";
		g.setFont(IConstants.iFont);
		g.setColor(IConstants.iColor);
		g.drawString(str,
			w_size.width - g.getFontMetrics().stringWidth(str) - 10,
			w_size.height - IConstants.iFont.getSize());
	}
	
	/**
	 * 獲得一系列tank
	 */
	public Tank getTankBySerial( int serial ) {
		return tanks.get(serial);
	}
	
	/**
	 * 同步化添加子彈到戰場
	 */
	public void addSynBullet( final Bullet e ) {
		synchronized ( bullets ) {
			bullets.add(e);
		}
	}
	
	/**
	 *添加子彈到戰場
	 */
	public void addBullet( final Bullet e ) {
		bullets.add(e);
	}
	
	/**
	 * 添加爆炸到戰場
	 */
	public void addExplosion( final Explosion exp ) {
		explosions.add(exp);
		if ( isSoundOpen() ) {
			tpool.execute(new Runnable(){
				public void run() {
					explosionClip[exp.getType()].play();
				}
			});
		}
	}
	
	/**
	 * 背景
	 */
	public void drawBackground( Graphics g ) {
		int x = 0, y = 0;
		do {
			bufferScreen.drawImage(background[bg], x, y, this);
			x += bgWidth;
			if ( x >= getWidth() ) {
				x = 0;
				y += bgHeight;
			}
			if ( y >= getHeight() ) break;
		} while ( true );
	}
	
	/**
	 * 玩家操控
	 */
	private class TankKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			//退出ESC
			if ( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
				if ( state == GAME_PUSHED ) synchronized (lock) {lock.notify();}
				state = GAME_BARRIER_SELECT;
				return;
			}
			
			//暫停和開始遊戲
			if ( e.getKeyCode() == KeyEvent.VK_P ) {
				switch ( state ) {
				case GAME_PUSHED:		//啟動
					synchronized ( lock ) {
						lock.notify();
						state = GAME_RUNING;
					}
					break;
				case GAME_RUNING: state = GAME_PUSHED; break;
				}
				return;
			}
			
			//遊戲幫助
			if ( e.getKeyCode() == KeyEvent.VK_H ) {
				gameHelp.setVisible(!gameHelp.isVisible());
			}
			
			switch ( state ) {
			case GAME_BARRIER_SELECT: bselector.keyPress(e); break;
			case GAME_MAP_SELECT: break;
			case GAME_RUNING:
				hero.keyPress(e); 
				break;
			case GAME_FAILED:
				if ( e.getKeyCode() == KeyEvent.VK_R ) 
					play(bselector.getBarriers() - 1);
				break;
			case GAME_SUCCEED:
				if ( e.getKeyCode() == KeyEvent.VK_N && bselector.hasNext() ) {
					play(bselector.next() - 1);
				}
				break;
			}
		}
		public void keyReleased(KeyEvent e) {			
			switch ( state ) {
			case GAME_RUNING:	hero.keyRelease(e); break;
			}
		}
	}
	
	/**
	 *檢查遊戲聲效 
	 */
	public boolean isSoundOpen() {
		return sound;
	}
	
	/**
	 * 設置遊戲聲效狀態
	 */
	public void setSound( boolean sound ) {
		this.sound = sound;
	}
	
	/**
	 *獲得當前遊戲模式
	 **/
	public int getGameMode() {
		return mode;
	}
	public void setGameMode( int mode ) {
		this.mode = mode;
	}
	
	/**
	 * 設置當前遊戲
	 */
	public void setBarriers( int barriers ) {
		if ( barriers < barriersSetting.length ) this.barriers = barriers;
	}
	
	public int getBarriers() {
		return barriers;
	}
	
	/**
	 * Main
	 */
	public static void main(String[] args) {
		Battlefield battle = new Battlefield();
		battle.setVisible(true);
		battle.loadResource();
	}
}
