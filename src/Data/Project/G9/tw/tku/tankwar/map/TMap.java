package Data.Project.G9.tw.tku.tankwar.map;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Data.Project.G9.tw.tku.tankwar.model.Wall;

/**
 * tank基礎地圖 . <br />
 * 
 * @author
 */
public class TMap {
	
	public static final int BIT_BLANK = 0;
	public static final int BIT_BULLET = - (1 << 20);
	
	protected int[][] maps = null;
	protected int rows;
	protected int cols;
	protected int x_offset;
	protected int y_offset;
	protected int width;
	protected int height;
	protected HashMap<Integer, Wall> wallmap;
	
	public TMap( int rows, int cols,
				int x_offset, int y_offset, HashMap<Integer, Wall> wallmap ) {
		this.rows = rows;
		this.cols = cols;
		this.x_offset = x_offset;
		this.y_offset = y_offset;
		this.wallmap = wallmap;
		
		maps = new int[rows][cols];
		width = cols * x_offset;
		height = rows * y_offset;
	}
	
	/**
	 * 生成地圖. <br />
	 * 
	 * @param	g
	 */
	public void draw( Graphics g ) {
		if ( wallmap != null ) {
			Iterator<Entry<Integer, Wall>> it = wallmap.entrySet().iterator();
			Wall w;
			while ( it.hasNext() ) {
				Entry<Integer, Wall> e= it.next();
				w = e.getValue();
				if ( ! w.isAlive() ) it.remove();
				else {
					g.drawImage(w.getImage(), w.getX() * x_offset, w.getY() * y_offset, 24, 24, null);
				}
			}
		}

	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public int getBit( int x, int y ) {
		return maps[y][x];
	}
	
	/**
	 * 設置地圖特殊值. <br />
	 * 
	 * @param	x
	 * @param	y
	 * @param	rows
	 * @param	cols
	 * @param	val
	 */
	public void setMapBit( int x, int y, int rows, int cols, int val ) {
		int c;
		for ( int r = 0; r < rows; r++ ) {
			for ( c = 0; c < cols; c++ ) setBit(x + c, y + r, val);
		}
	}
	
	/**  
	 * 檢查地圖
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	y
	 * @return	boolean
	 */
	public boolean checkMapBit( int x, int y, int rows, int cols, int val ) {
		int c;
		for ( int r = 0; r < rows; r++ ) {
			for ( c = 0; c < cols; c++ ) if ( getBit(x + c, y + r) != val ) return false;
		}
		return true;
	}
	
	public void setBit( int x, int y, int val ) {
		maps[y][x] = val;
	}
	
	public int getXoffset() {
		return x_offset;
	}
	
	public int getYoffset() {
		return y_offset;
	}
	
	public void clear() {
		int x, y;
		for ( y = 0; y < rows; y++ ) {
			for ( x = 0; x < cols; x++ ) maps[y][x] = BIT_BLANK;
		}
	}
	
	/**
	 * 獲得特定系列牆體 <br />
	 * 
	 * @param	serial
	 * @return	Wall
	 */
	public Wall getWall( int serial ) {
		if ( wallmap == null ) return null;
		return wallmap.get(serial);
	}
	
	/**
	 * 清除地圖牆體 <br />
	 * 
	 * @param	w
	 */
	public void clearWall( Wall w ) {
		if ( w != null ) {
			setMapBit(w.getX(), w.getY(), w.getRows(), w.getCols(), BIT_BLANK);
		}
	}
	
	/**
	 * 設置牆體 . <br /> 
	 */
	public void setWalls( HashMap<Integer, Wall> wallmap ) {
		this.wallmap = wallmap;
		
		//設置牆體
		if ( wallmap != null ) {
			Iterator<Entry<Integer, Wall>> it = wallmap.entrySet().iterator();
			Wall w;
			while ( it.hasNext() ) {
				Entry<Integer, Wall> e= it.next();
				w = e.getValue();
				if ( w.getType() != Wall.GRASS_WALL )
					setMapBit(w.getX(), w.getY(), w.getRows(), w.getCols(), w.getSerial());
			}
		}
	}
}
