package Data.Project.G9.tw.tku.tankwar.barriers;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Data.Project.G9.tw.tku.tankwar.Battlefield;

/**
 * 關卡選擇類
 * 
 * @author BB
 */
public class BarriersSelector {

	private Font titleFont = new Font("宋体", Font.BOLD, 30);
	private Font numFont = new Font("黑体", Font.BOLD, 30);
	private Font cFont = new Font("宋体", Font.PLAIN, 12);
	private Color sColor = new Color(120, 100, 135);
	private Color color = new Color(230, 170, 5);

	private Battlefield BF = null;
	private Image tImages = null;
	private Image pImages = null;
	private ImageIcon grass = null;
	private AudioClip buttonClip = null;
	private int i_width;
	private int i_height;

	private int barriers;
	private int max; /* 最大關卡數 */
	private int offset; /*速度*/
	private int w; /* 顯示寬度 */
	private int h; /* 顯示高度 */

	private int str_width;

	/**
	 * 構造方法 <br />
	 * 
	 * @param default
	 * @param max
	 * @param offset
	 * @param w
	 * @param h
	 * @param icons
	 */
	public BarriersSelector(Battlefield bf, int defualt, int max, int offset,
			int w, int h, ImageIcon[] icons, AudioClip buttonClip) {
		this.BF = bf;
		this.barriers = defualt;
		this.max = max;
		this.offset = offset;
		this.w = w;
		this.h = h;
		this.tImages = icons[0].getImage();
		this.pImages = icons[1].getImage();
		this.grass = icons[2];
		this.buttonClip = buttonClip;
		i_width = icons[0].getIconWidth();
		i_height = icons[0].getIconHeight();

		str_width = max * this.offset;
	}

	/**
	 * 用戶介面
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w, h);

		// 顯示標題
		String str = " 關卡   選擇  ";
		g.setColor(sColor);
		g.setFont(titleFont);
		int x = (w - g.getFontMetrics(titleFont).stringWidth(str)) / 2;
		int y = h / 2 - 50; // 位置
		g.drawString(str, x, y);
		// 標題圖片
		g.drawImage(tImages, x - i_width - 10, y - i_height / 2 - 10, null);

		// 草坪圖片
		for (int j = 0; j < 9; j++) {
			g.drawImage(grass.getImage(),
					x - i_width - 10 + grass.getIconWidth() * j, y + 10, null);
		}

		g.setFont(numFont);
		y = h / 2 - numFont.getSize() + 70; // 中下位置
		for (int j = 1; j <=max; j++) {
			if (j < 10)
				str = "0" + j;
			else
				str = "" + j;
			x = (w - str_width) / 2 + offset * (j - 1);
			if (j == barriers) {
				g.drawImage(pImages, x - (i_width - numFont.getSize()) / 2, y,
						null);
				g.setColor(color);
				g.drawString(str, x, y);
			} else {
				g.setColor(sColor);
				g.drawString(str, x, y);
			}

		}

		// 版權
		g.setColor(new Color(50, 50, 50));
		int cw = 400, ch = 20;
		x = (w - cw) / 2;
		y = h / 10;
		g.fill3DRect(x, y, cw, ch, true);
		str = "Design By CSIE 1B Java No.9 Group";
		g.setFont(cFont);
		g.setColor(color);
		g.drawString(str, x + (cw - g.getFontMetrics(cFont).stringWidth(str))
				/ 2, y + cFont.getSize() + 2);

		// 操作提示
		str = "<tips: A, D 左右移動, J 確認遊戲, H 遊戲幫助>";
		g.drawString(str, (w - g.getFontMetrics().stringWidth(str)) / 2, y + ch
				+ 20);

	}

	/**
	 * 鍵盤操作方法
	 * 
	 * @param e
	 */
	public void keyPress(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			if (barriers > 1) {
				barriers--;
				buttonClip.stop();
				buttonClip.play();
			} else if (barriers == 1) {
				barriers = max;
				buttonClip.stop();
				buttonClip.play();
			}
			break;
		case KeyEvent.VK_D:
			if (barriers < max) {
				barriers++;
				buttonClip.stop();
				buttonClip.play();
			} else if (barriers == max) {
				barriers = 1;
				buttonClip.stop();
				buttonClip.play();
			}
			break;
		case KeyEvent.VK_J:
			buttonClip.stop();
			buttonClip.play();
			BF.play(barriers - 1);
			break;
		}
	}

	public void stopAudio() {
		buttonClip.stop();
	}

	public boolean hasNext() {
		return (barriers < max);
	}

	public int getBarriers() {
		return barriers;
	}

	public void setBarriers(int barriers) {
		if (barriers > 0 && barriers <= max)
			this.barriers = barriers;
	}

	public int next() {
		if (++barriers <= max)
			return barriers;
		return 0;
	}
}
