package Data.Project.G9.tw.tku.tankwar.util;

import javax.swing.*;
import java.awt.*;

/**
 * 圖片加載器. 
 * 
 * @author 
 */
public class ImageLoader {
	
	static Toolkit TK = Toolkit.getDefaultToolkit();
	
	/**
	 * 加載圖片進去 . <
	 * 
	 * @param	_file
	 * @return	ImageIcon
	 */
	public static ImageIcon loadImageIcon(String _file) {
		return new ImageIcon(ImageLoader.class.getResource("/Data/Project/G9/res/image/"+_file));
	}
}
