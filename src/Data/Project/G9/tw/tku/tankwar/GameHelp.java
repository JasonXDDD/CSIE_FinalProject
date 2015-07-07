package Data.Project.G9.tw.tku.tankwar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 * 遊戲幫助類
 * 
 * @author BB
 */
public class GameHelp {
	
	
	public static final String[] HELP = new String[]{
		"Game Help: ",
		"J - 發射普通子彈",
		"K - 發射普通炸彈",
		"L - 發射無敵飛彈",
		"P - 暫停/開始",
		"ESC - 關卡選擇",
		"M - 簡單/複雜模式",
		"H - 幫助"
	};
	
	private Image image = null;
	private int w;
	private int h;
	private boolean show;
	
	public GameHelp( int w, int h ) {
		this.w = w;
		this.h = h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	public void setVisible( boolean show ) {
		this.show = show;
	}
	
	public boolean isVisible() {
		return show;
	}
	
	/**
	 * 創建遊戲幫助
	 * @return	Image
	 */
	public Image getHelpImage() {
		if ( image == null ) {
			BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = img.createGraphics();
			img = g.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
			g.dispose();
			g = img.createGraphics();
			
			g.setColor(new Color(0, 0, 0, 80));		//設置背景
			g.fillRoundRect(0, 0, w, h, 5, 5);
			
			Font f = new Font("宋体", Font.PLAIN, 14);
			g.setFont(f);
			g.setColor(Color.RED);
			int x_off = 20, y_off = 25;
			for ( int j = 0; j < HELP.length; j++ ) {
				g.drawString(HELP[j], x_off, y_off + j * (f.getSize() + 5));
			}
			
			g.dispose();
			image = img;
		}
		
		return image;
	}
}
