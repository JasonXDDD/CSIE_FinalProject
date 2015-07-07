package Data.Project.G9.tw.tku.tankwar.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.map.TMap;
import Data.Project.G9.tw.tku.tankwar.util.IConstants;

/**
 * 基礎tank類. <br />
 * 
 * @author 
 */
public class Tank {
	
	public static final int HERO_TANK = 0;
	public static final int ENEMY_TANK = 1;
	
	public static final Font font = new Font("Arial", Font.PLAIN, 10);

	protected static Battlefield BF = null;
	protected static TMap MAP = null;
	protected int serial;
	protected Image[] images;
	protected int x;
	protected int y;
	protected int t;
	protected int rows;			
	protected int cols;			
	protected int head = IConstants.DIRECTION_U;
	protected int direction = 0;	//移動方向
	protected int offset = 1;
	protected int blood;			//當前血量
	private int life = -1;				//總血量
	protected boolean alive = true;
	
	//子彈
	protected int movingBullets = 0;
	protected int bomb = 1;
	protected int missile = 0;
	
	/**
	 * 空構造方法 .  
	 */
	protected Tank( Battlefield bf, Image[] images, int t, 
				int serial, int x, int y, int cols, int rows ) {
		this(bf, images, t, serial, x, y, cols, rows, 0, 2);
	}
	
	/**
	 * 構造方法 
	 * 
	 * @param	img		tank skin
	 * @param	x		x position
	 * @param	y		y position
	 * @param	blood	blood count
	 */
	protected Tank( Battlefield bf, Image[] images, int t,
			int serial, int x, int y, int cols, int rows, int head, int blood ) {
		BF = bf;
		MAP = BF.getMap();
		this.images = images;
		this.t = t;
		this.serial = serial;
		this.cols = cols;
		this.rows = rows;
		this.x = x;
		this.y = y;
		this.head = head;
		this.blood = blood;
	}
	
	/**
	 * 獲得tank方向 . 
	 * 
	 * @return	int
	 */
	public int getMoveDirection() {
		int d = 0, direct = direction;		//重複上面方向
		if ( ( direct & IConstants.DIRECTION_U ) != 0 ) {		//上移
			d = IConstants.DIRECTION_U;
			if ( ( direct & IConstants.DIRECTION_L ) != 0 ) d = IConstants.DIRECTION_LU;
			if ( ( direct & IConstants.DIRECTION_R ) != 0 ) d = IConstants.DIRECTION_RU;
		} 
		else if ( ( direct & IConstants.DIRECTION_R ) != 0 ) {	//右移
			d = IConstants.DIRECTION_R;
			if ( ( direct & IConstants.DIRECTION_U ) != 0 ) d = IConstants.DIRECTION_RU;
			if ( ( direct & IConstants.DIRECTION_D ) != 0 ) d = IConstants.DIRECTION_RD;
		}
		else if ( ( direct & IConstants.DIRECTION_D ) != 0 ) {	//下移
			d = IConstants.DIRECTION_D;
			if ( ( direct & IConstants.DIRECTION_L ) != 0 ) d = IConstants.DIRECTION_LD;
			if ( ( direct & IConstants.DIRECTION_R ) != 0 ) d = IConstants.DIRECTION_RD;
		}
		else if ( ( direct & IConstants.DIRECTION_L ) != 0 ) {	//左移
			d = IConstants.DIRECTION_L;
			if ( ( direct & IConstants.DIRECTION_U ) != 0 ) d = IConstants.DIRECTION_LU;
			if ( ( direct & IConstants.DIRECTION_D ) != 0 ) d = IConstants.DIRECTION_LD;
		}
		
		return d;
	}
	
	/**
	 * tank 生成方法
	 */
	public void draw(Graphics g) {
		if ( alive ) {
		int x = this.x * MAP.getXoffset();
		int y = this.y * MAP.getYoffset();
		boolean ch = true, down = false;
		switch ( head ) {
		case IConstants.DIRECTION_U:	g.drawImage(images[0], x, y, null); down = true; break;
		case IConstants.DIRECTION_RU:	g.drawImage(images[1], x, y, null); down = true; break;
		case IConstants.DIRECTION_R:	g.drawImage(images[2], x, y, null); break;
		case IConstants.DIRECTION_RD:	g.drawImage(images[3], x, y, null); break;
		case IConstants.DIRECTION_D:	g.drawImage(images[4], x, y, null); break;
		case IConstants.DIRECTION_LD:	g.drawImage(images[5], x, y, null); break;
		case IConstants.DIRECTION_L:	g.drawImage(images[6], x, y, null); break;
		case IConstants.DIRECTION_LU:	g.drawImage(images[7], x, y, null); down = true; break;
		default : ch = false;
		}
		//血量
		if ( ch ) {
			g.setColor(Color.RED);
			int w = ( cols - 2 ) * MAP.getXoffset();
			int h = 4;
			x = x + MAP.getXoffset();
			/*邊界返回*/
			y = down ? y + (rows + 1) * MAP.getYoffset() : y - 2 * MAP.getYoffset();
			g.drawRect(x, y, w, h);
			
			//生命條
			if ( life == -1 ) life = blood;
			g.fillRect(x + 1, y, blood * (w - 1) / life, h);
			
			//生命值
			g.setColor(Color.WHITE);
			g.setFont(font);
			String str = blood+"/"+life+","+missile;
			g.drawString(str,
					x + ( w - g.getFontMetrics().stringWidth(str) ) / 2,
					y + font.getSize() / 2);
		}
		
		move();
		}
	}
	
	/**
	 *通過特定方向移動tank
	 */
	public void move() {
		int d = getMoveDirection();
		if ( d == 0 ) return;
		head = d;
		int off;
		switch ( d ) {
		case IConstants.DIRECTION_U:
			off = getUpMoveOffset(x, y); if ( off != 0 ) moveUp( off ); break;
		case IConstants.DIRECTION_RU:
			off = getRightMoveOffset(x, y); if ( off != 0 )	moveRight(off);
			off = getUpMoveOffset(x, y); if ( off != 0 )	moveUp( off );
			break;
		case IConstants.DIRECTION_R:	
			off = getRightMoveOffset(x, y); if ( off != 0 )	moveRight(off); break;
		case IConstants.DIRECTION_RD:	
			off = getRightMoveOffset(x, y); if ( off != 0 )	moveRight(off);
			off = getDownMoveOffset(x, y); if ( off != 0 )	moveDown(off);
			break;
		case IConstants.DIRECTION_D:	
			off = getDownMoveOffset(x, y); if ( off != 0 )	moveDown(off); break;
		case IConstants.DIRECTION_LD:
			off = getDownMoveOffset(x, y); if ( off != 0 )	moveDown(off);
			off = getLeftMoveOffset(x, y); if ( off != 0 ) 	moveLeft( off );
			break;
		case IConstants.DIRECTION_L:	
			off = getLeftMoveOffset(x, y); if ( off != 0 ) 	moveLeft( off ); break;
		case IConstants.DIRECTION_LU:	
			off = getLeftMoveOffset(x, y); if ( off != 0 ) 	moveLeft( off );
			off = getUpMoveOffset(x, y); if ( off != 0 ) moveUp( off );
			break;
		}
	}
	
	/**
	 * 上邊界移動判定 <br />
	 * 
	 * @param	x
	 * @param	y
	 * @return	int
	 */
	protected int getUpMoveOffset( int x, int y ) {
		int off = offset;
		if ( y - offset < 0 ) off = y;
		if ( MAP.checkMapBit( x, y - off, off, cols, TMap.BIT_BLANK ) ) return off;
		return 0;
	}
	/** 上移*/
	private void moveUp( int off ) {
		MAP.setMapBit( x, y + rows - off, off, cols, TMap.BIT_BLANK );
		y -= off;
		MAP.setMapBit( x, y, off, cols, serial );
	}
	
	/**
	 * 右邊界移動判定.
	 * 
	 * @param	x
	 * @param	y
	 * @return	int
	 */
	protected int getRightMoveOffset( int x, int y ) {
		int off = offset;
		if ( x + offset > (MAP.getCols() - cols) ) off = MAP.getCols() - cols - x;
		if ( MAP.checkMapBit( x + cols, y, rows, off, TMap.BIT_BLANK ) ) return off;
		return 0;
	}
	/** 右移 */
	private void moveRight( int off ) {
		MAP.setMapBit( x, y, rows, off, TMap.BIT_BLANK );
		x += off;
		MAP.setMapBit( x + cols - off, y, rows, off, serial );
	}
	
	/**
	 * 下邊界移動判定 <br /> 
	 * 
	 * @param	x
	 * @param	y
	 * @return	int
	 */
	protected int getDownMoveOffset( int x, int y ) {
		int off = offset;
		if ( y + offset > ( MAP.getRows() - rows ) ) off = MAP.getRows() - rows - y;
		if ( MAP.checkMapBit( x, y + rows, off, cols, TMap.BIT_BLANK ) ) return off;
		return 0;
	}
	/**下移*/
	private void moveDown( int off ) {
		MAP.setMapBit( x, y, off, cols, TMap.BIT_BLANK );
		y += off;
		MAP.setMapBit( x, y + rows - off, off, cols, serial );
	}
	
	/**
	 * 左邊界移動判定. <br />
	 * 
	 * @param	x
	 * @param	y
	 * @return	int
	 */
	protected int getLeftMoveOffset( int x, int y ) {
		int off = offset;
		if ( x - offset < 0 ) off = x;
		if ( MAP.checkMapBit( x - off, y, rows, off, TMap.BIT_BLANK ) ) return off;
		return 0;
	}
	/**左移*/
	private void moveLeft( int off ) {
		MAP.setMapBit( x + cols - off, y, rows, off, TMap.BIT_BLANK );
		x -= off;
		MAP.setMapBit( x, y, rows, off, serial );
	}
	
	/**
	 * 檢查tank是否能發射 <br />
	 * 
	 * @return	boolean
	 */
	public boolean couldShot() {
		return ( (BF.getGameMode() < 0 && getMovingBullets() < 1)
				|| BF.getGameMode() == Battlefield.SIMPLE_MODE );
	}
	
	public int getSerial() {
		return serial;
	}
	
	public void setSerial( int serial ) {
		this.serial = serial;
	}
	
	/**
	 * 獲得移動的子彈 <br /> 
	 * 
	 * @return	int
	 */
	public int getMovingBullets() {
		return movingBullets;
	}
	
	/**
	 * 增加/減少 移動的子彈 . <br /> 
	 */
	public void increaseMovingBullets() {
		movingBullets++;
	}
	public void reduceMovingBullets() {
		movingBullets--;
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
	
	public int getCols() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}

	public int getBlood() {
		return blood;
	}
	
	public void setHead( int head ) {
		this.head = head;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	public void setBomb( int bomb ) {
		this.bomb = bomb;
	}
	
	public void setMissile( int missile ) {
		this.missile = missile;
	}
	
	public void setOffset( int offset ) {
		this.offset = offset;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		if ( alive == false ) MAP.setMapBit( x, y, rows, cols, TMap.BIT_BLANK );
		this.alive = alive;
	}
	
	public void setType( int t ) {
		this.t = t;
	}
	
	public int getType() {
		return t;
	}
}
