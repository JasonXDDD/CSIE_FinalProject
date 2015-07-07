package Data.Project.G9.tw.tku.tankwar;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 * 遊戲結果類 .
 * 
 * @author BB
 */
public class GameResult {
	
	private Font fFont = new Font("宋体", Font.BOLD, 30);
	private Font tFont = new Font("宋体", Font.PLAIN, 12);
	private Color sColor = new Color(100, 100, 35);
	
	private Image image;
	private int i_width;
	private int idx = 0;
	private int w;
	private int h;
	private int ret;
	
	private int offset;
	private int counter = 0;
	
	private AudioClip gamevictory = null;
	private AudioClip gamedefault = null;
	
	
	public GameResult( int w, int h, int ret, int offset, ImageIcon icon ) {
		this.w = w;
		this.h = h;
		this.ret = ret;
		this.offset = offset;
		this.counter = offset;
		
		this.image = icon.getImage();
		i_width = icon.getIconWidth();

	}
	

	
	/**
	 * 用戶介面
	 * @param	g
	 */
	public void draw( Graphics g ) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w, h);
		
		String str, tip;
		g.setFont(fFont);
		g.setColor(sColor);
		if ( ret == Battlefield.GAME_FAILED ) {
			str = "失敗.";
			tip = "<按下ESC返回到主選單或者R重新挑戰>";
		} else {
			str = "成功";
			tip = "<按下ESC返回到主選單或者N挑戰下一關>";
			
		}
		
		int x = ( w - g.getFontMetrics().stringWidth(str) ) / 2;
		int y = h / 2 - fFont.getSize() - 20;
		g.drawString(str, x, y);
		int rows = g.getFontMetrics().stringWidth(str) / i_width + 1;
		if ( counter-- == 0 ) {
			if ( idx < rows ) idx++;
			counter = offset;
		}
		for ( int j = 0; j < idx; j++ ) {
			g.drawImage(image, x + j * i_width, y + 10, null);
		}
		
		//提示文段
		g.setFont(tFont);
		g.drawString(tip, ( w - g.getFontMetrics().stringWidth(tip) ) / 2, 
				h / 2 + tFont.getSize() + 20);
	}
}
