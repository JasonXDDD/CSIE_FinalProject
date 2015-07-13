package Public_Class;

/**
 * Created by JasonXDDD on 2015/7/13.
 */
public class TEST {
    public static void main(String[] args){
//        ImageIcon head = new ImageIcon(ClassLoader.getSystemResource("/Data/Cover/G1.jpg"));
        System.out.print(ClassLoader.class.getResource("/Data/Cover/G1.jpg"));
    }
}
