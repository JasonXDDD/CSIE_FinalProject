package Public_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;

/**
 * Created by JASON_ on 2015/5/27.
 */
public class ImageProcess {
    public static final int Height = 1;
    public static final int Width = 2;
    public static final int Auto = 3;

    public static ImageIcon cutImage(ImageIcon head , int x, int y,
                                                    int width, int height){
        Image croppedImage;
        ImageFilter cropFilter;
        Image sourceImage = head.getImage();
        ImageIcon Show;

        cropFilter =new CropImageFilter(x,y,width,height);
        croppedImage= Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(sourceImage.getSource(),cropFilter));

        Show = new ImageIcon(croppedImage);

        return Show;
    }

    public static ImageIcon scaleImage(ImageIcon head , int i, int changetype){
        Image GetPic;
        Image fixSize;
        ImageIcon Show;

        GetPic = head.getImage();

        if(changetype == Width)
            fixSize = GetPic.getScaledInstance
                    (SetPicLength(head, i, changetype), i, Image.SCALE_SMOOTH);
        else if(changetype == Height)
            fixSize = GetPic.getScaledInstance
                    (i, SetPicLength(head, i, changetype), Image.SCALE_SMOOTH);
        else {
            if(head.getIconWidth() >= head.getIconHeight())
                fixSize = GetPic.getScaledInstance
                        (SetPicLength(head, i, changetype), i, Image.SCALE_SMOOTH);
            else
                fixSize = GetPic.getScaledInstance
                        (i, SetPicLength(head, i, changetype), Image.SCALE_SMOOTH);
        }
        Show = new ImageIcon(fixSize);

        return Show;
    }

    public static int SetPicLength(ImageIcon head, int y, int changetype){
        int width = head.getIconWidth();
        int height = head.getIconHeight();
        int x;

        System.out.print("BookData Head: w: " + head.getIconWidth() +
                " h: " + head.getIconHeight());

        if(changetype == Width){
            x = width * y / height;
            System.out.println("  after w: " + x);
        }
        else if(changetype == Height){
            x = height * y / width;
            System.out.println("  after h: " + x);
        }
        else{
            if(width >= height) {
                x = width * y / height;
                System.out.println("  after w: " + x);
            }
            else {
                x = height * y / width;
                System.out.println("  after h: " + x);
            }
        }


        return x;
    }
}
