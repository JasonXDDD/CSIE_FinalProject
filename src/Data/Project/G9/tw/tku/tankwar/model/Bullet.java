package Data.Project.G9.tw.tku.tankwar.model;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.ExplosionFactory;
import Data.Project.G9.tw.tku.tankwar.map.TMap;
import Data.Project.G9.tw.tku.tankwar.util.IConstants;

import java.awt.*;

/**
 * 子彈類
 * 
 * @author  linzihao
 */
public class Bullet {
	
	public static final short NORMAL_BULLET = 0;
	public static final short BOMB_BULLET = 1;
	public static final short MISSILE_BULLET = 2;
	
	public static Battlefield BF = null;
	public static TMap MAP = null;
	
	private Image image;
	private Tank mtank;				/*來源tank系列*/
	private int tt;					/*來源tank類型 [Tank.HERO_TANK, TANK.ENEMY_TANK]*/
	private int x;
	private int y;
	private short rows;
	private short cols;
	private int offset = 1;
	private short t;
	private int blood = 1;			/*每次傷害量.*/
	private int direction = 0;
	private boolean alive = true;
	
	/**
	 * 子彈構造方法 . 
	 * 
	 * @param	bf
	 * @param	image
	 * @param	w
	 * @param	h
	 */
	public Bullet( Battlefield bf, Image image, short t, Tank mtank, int tt,
				int x, int y, short rows, short cols, int direction ) {
		this(bf, image, t, mtank, tt, x, y, rows, cols, direction, 1);
	}
	
	/**
	 * 子彈構造方法 . 
	 * 	
	 * @param	bf
	 * @param	image
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	t
	 */
	public Bullet( Battlefield bf, Image image, short t, Tank mtank, int tt,
				int x, int y, short rows, short cols, int direction, int blood ) {
		BF = bf;
		MAP = bf.getMap();
		this.image = image;
		this.t = t;
		this.mtank = mtank;
		this.tt = tt;
		this.x = x;
		this.y = y;
		this.rows = rows;
		this.cols = cols;
		this.direction = direction;
		this.blood = blood;
	}
	
	/**
	 * 產生子彈.  
	 * @param	g
	 */
	public void draw( Graphics g ) {
		g.drawImage(image, (x - cols / 2) * MAP.getXoffset(),
				(y - rows / 2) * MAP.getYoffset(), null);
		move();
	}
	
	/**
	 * 子彈移動 . <br /> 
	 */
	private void move() {
		switch ( direction ) {
		case IConstants.DIRECTION_U:	y -= offset; break;
		case IConstants.DIRECTION_RU:	x += offset; y -= offset; break;
		case IConstants.DIRECTION_R:	x += offset; break;
		case IConstants.DIRECTION_RD:	x += offset; y += offset; break;
		case IConstants.DIRECTION_D:	y += offset; break;
		case IConstants.DIRECTION_LD:	x -= offset; y += offset; break;
		case IConstants.DIRECTION_L:	x -= offset; break;
		case IConstants.DIRECTION_LU:	x -= offset; y -= offset; break;	
		}
		
		//子彈出界
		if ( (x < 0 || x >= (MAP.getCols() - 1)) 
					|| (y < 0 || y >= (MAP.getRows() - 1)) ) {
			setAlive(false);
			mtank.reduceMovingBullets();
			return;
		}
		//子彈擊中判定
		int bit = MAP.getBit(x, y);
		if ( bit == mtank.getSerial() ) {
			return;
		}
		
		if ( bit < 0 ) {							//擊中牆體或者子彈
			if ( bit != TMap.BIT_BULLET ) {
				Wall w = MAP.getWall(bit);
				if ( w != null && w.couldSmash(this) ) {
					MAP.clearWall(w);
					w.setAlive(false);				//清除可以擊碎牆體
				}
			}
			setAlive(false);						//清除子彈
			mtank.reduceMovingBullets();
		} else if ( bit > 0 ) {						//擊中tank
			Tank tank = BF.getTankBySerial(bit);	//tank擊中狀態
			if ( tank == null )		return;
			if ( tank.getType() != tt ) {			//隊友判定					
				if ( tank.getBlood() > blood ) {	//傷害判定
					tank.setBlood(tank.getBlood() - blood);
				} else {							//死亡判定
					tank.setAlive(false);
					//顯示爆炸動畫
					BF.addExplosion(ExplosionFactory.createExplosion(BF, x, y,
							t == MISSILE_BULLET ? Explosion.SUPER_EXPLOSION : Explosion.SMALL_EXPOSION));
				}
				setAlive(false);
				mtank.reduceMovingBullets();
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public short getRows() {
		return rows;
	}
	
	public short getCols() {
		return cols;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	public void setOffset( int offset ) {
		this.offset = offset;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive( boolean alive ) {
		this.alive = alive;
	}
	
	public Tank getMasterTank() {
		return mtank;
	}
	
	public int getType() {
		return t;
	}
	
	public int getTankType() {
		return tt;
	}
}
