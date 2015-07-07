package Data.Project.G9.tw.tku.tankwar.map;

import Data.Project.G9.tw.tku.tankwar.model.Wall;

import java.awt.*;
import java.util.HashMap;

/**
 * random words map . 
 * 
 * @author 
 */
public class RandomWordsMap {
	
	public static final String[] WORDS = {
		"9", "J", "A", "V", "A", "G", "A", "M",
		"E", "I", "S", "T", "A", "N", "K", "W", "A", "R", "I",
		"S", "F", "U", "N", "N", "Y", "A", "R", "E", "Y", "O", "U", "OK"};
	/**
	 * 生成隨機地圖 . 
	 * 
	 * @param	images
	 * @param	rows		(wall image rows bit)
	 * @param	cols		(wall image cols bit)
	 * @param	x_offset	(start x offset in the map)
	 * @param	y_offset	(start y offset in the map)
	 */
	public static HashMap<Integer, Wall> generate( Image[] images, int rows, int cols, 
				int width, int height, int x_offset, int y_offset ) {
		//獲得關鍵字
		String str = WORDS[( (int) (Math.random() * 10000) ) % WORDS.length];
		int[][] maps = WordsToRGB.invoke(width, height, str);
		
		HashMap<Integer, Wall> wmap = new HashMap<Integer, Wall>(16, 0.85F);
		int key = -1;
		
		//創建牆體
		Wall wall;
		int x_off = width / maps.length;
		int y_off = height / maps[0].length;
		int t, _x, _y, r = y_off / rows, c = x_off / cols;
		for ( int y = 0; y < maps.length; y++ ) {
			for ( int x = 0; x < maps[0].length; x++ ) {
				if ( maps[y][x] == -1 ) {
					t = ( (int)(Math.random() * 10000) ) % images.length;
					_x = x_offset + x * x_off;
					_y = y_offset + y * y_off;
					//添加牆體設置
					for ( int j = 0; j < r; j++) {
						for ( int i = 0; i < c; i++ ) {
							wall = new Wall(images[t], t, key,
									_x + i * cols, _y + j * rows, rows, cols);
							wmap.put(key--, wall);
						}
					}
				}
			}
		}
		
		return wmap;
	}
}
