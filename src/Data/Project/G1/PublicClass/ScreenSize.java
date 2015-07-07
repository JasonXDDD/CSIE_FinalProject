package Data.Project.G1.PublicClass;

import java.awt.*;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class ScreenSize {
    private Dimension scSize;

    public ScreenSize(){
        scSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("This screen Size is  Width:" + scSize.getWidth() +
                            " Height: " + scSize.getHeight());
    }

    public int getWidth(){
        return (int)scSize.getWidth();
    }

    public int getHeight(){
        return (int)scSize.getHeight();
    }
}
