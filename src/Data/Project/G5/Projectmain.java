package Data.Project.G5;

import javax.swing.WindowConstants;

public class Projectmain {
	
	static int height = 720,width = 1280;
	
	public static void main(String[] args) {
		
		GameFrame game = new GameFrame(height,width);
		game.setSize(width, height);
		game.setResizable(false);
		game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		game.setVisible(true);
		
	}

}
