package Data.Project.G9.tw.tku.tankwar.util;

import java.awt.Point;

/**
 * util class . 
 * 
 * @author
 */
public class Util {
	
	/**
	 *計算X和Y座標和中心座標
	 * @param	x
	 * @param 	y
	 * @param	y
	 * @param	h
	 */
	public static Point center( int x, int y, int w, int h ) {
		return new Point(x - w / 2, y - h / 2);
	}
}
