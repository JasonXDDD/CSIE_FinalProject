package Data.Project.G3;

import javax.swing.*;
import java.awt.*;


public class Main {

	public static void main(String[] args){
		double height;
		double width;


		Dimension screensize;
		
		Board board = new Board();
		
		
		screensize =  Toolkit.getDefaultToolkit().getScreenSize();
		
		height = screensize.getHeight();
		width = screensize.getWidth();
		
		board.setBounds((int)width/2-500,(int)height/2-350,1000,700);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setVisible(true);
		board.setResizable(false);
		board.setTitle("G03-FINAL-PROGRAM");
		
		
	}

}
