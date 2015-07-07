package Data.Project.G9.tw.tku.tankwar;

import javax.swing.*;
import java.awt.*;

public class BattleCanvas extends JPanel {
	
	private Image bufferImage = null;
	
	public BattleCanvas() {
		setSize(Battlefield.w_size);
		setPreferredSize(Battlefield.w_size);
	}
	
	public void paintComponent( Graphics g ) {
		if ( bufferImage == null ) {
			//填充背景
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			//加載信息
			String str = "加載中......";
			Font f = new Font("宋体", Font.BOLD, 50);
			g.setColor(Color.WHITE);
			g.setFont(f);
			g.drawString(str,
					(getWidth() - this.getFontMetrics(f).stringWidth(str)) / 2,
					getHeight() / 2);
			return;
		}
		//加載 buffer.
		g.drawImage(bufferImage, 0, 0, this);
	}
	
	public void setBufferImage( Image image ) {
		bufferImage = image;
	}
}
