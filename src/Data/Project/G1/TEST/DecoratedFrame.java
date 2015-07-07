package Data.Project.G1.TEST;

import Data.Project.G1.PublicClass.ScreenSize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class DecoratedFrame extends JFrame {
    private ScreenSize scSize;
    private Image fixSize;
    private Image GetPic;
    private ImageIcon head = new ImageIcon(getClass().getResource("MainScreen/head.jpg"));
    private ImageIcon Show;

    private JLabel loading;

    public DecoratedFrame() {
        scSize = new ScreenSize();

        this.getContentPane().add(new JLabel("Just a test."));
        this.setUndecorated(true); // 去掉視窗的裝飾
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        //採用指定的視窗裝飾風格
        GetPic = head.getImage();
        fixSize = GetPic.getScaledInstance(SetPicWidth(head, 500), 500, Image.SCALE_SMOOTH);
        Show = new ImageIcon(fixSize);
        loading = new JLabel(Show);
        this.getContentPane().add(loading, BorderLayout.CENTER);
        this.pack();
        this.setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                        scSize.getHeight()/2 - this.getHeight()/2);
    }

    public int SetPicWidth(ImageIcon head, int y){
        int width = head.getIconWidth();
        int height = head.getIconHeight();
        int x = width * y / height;

        System.out.println("BookData Head: w: " + head.getIconWidth() +
                " h: " + head.getIconHeight() +
                " After w: " + x);

        return x;
    }

    public static void main(String[] args) {
        JFrame frame = new DecoratedFrame();
        frame.setVisible(true);
    }
}
