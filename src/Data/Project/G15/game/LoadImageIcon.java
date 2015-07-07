package Data.Project.G15.game;


import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;


public class LoadImageIcon {
	public final int size = 4;
	public int imgW,imgH;		
	public ImageIcon [] img;	
	

	public LoadImageIcon(){
		initLoadImageIcon();
	}

	public void initLoadImageIcon(){
		imgW = 800;
		imgH = 600;
		img = new ImageIcon[size];

		for(int i = 0; i < img.length; i++){
			img[i] = new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Data\\Project\\G15\\game\\img\\"+i+".jpg").getImage().getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT));
		}
	}
	

	public ImageIcon [][] getPieceImg(int index,int row,int col){	
		int w = img[index].getIconWidth()/row;
		int h = img[index].getIconHeight()/col;
		ImageIcon [][] p = new ImageIcon[row][col];
		

		for(int i = 0; i < row; i++){
			ImageProducer imageproducer = img[index].getImage().getSource();
			for(int j = 0; j < col; j++){
				CropImageFilter cropimagefilter = new CropImageFilter(j * w, i * h, w, h);
				p[i][j] = new ImageIcon( Toolkit.getDefaultToolkit().createImage( new FilteredImageSource( imageproducer , cropimagefilter )));
			}
		}
		return p;
	}
}
