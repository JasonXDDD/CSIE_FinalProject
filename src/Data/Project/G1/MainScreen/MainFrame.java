package Data.Project.G1.MainScreen;

import Data.Project.G1.PublicClass.ScreenSize;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainFrame extends JFrame{
    private ScreenSize scSize;
    private JLayeredPane lp_Layer;

    private spAccountData MF_spAccountData;
    private BookPanel MF_pnBook;

    public MainFrame(){
        System.out.println("-----MainFrame-----");

        setLayout(new BorderLayout());
        scSize = new ScreenSize();
        lp_Layer = this.getLayeredPane();
        lp_Layer.setLayout(null);

        MF_spAccountData = new spAccountData();
        getContentPane().add(MF_spAccountData, BorderLayout.WEST);

        MF_pnBook = new BookPanel();
        getContentPane().add(MF_pnBook, BorderLayout.CENTER);


        setVisible(true);
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(scSize.getWidth(), scSize.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println();
    }

    public BookPanel getMF_pnBook() {
        return MF_pnBook;
    }

    public void setMF_pnBook(BookPanel MF_pnBook) {
        this.MF_pnBook = MF_pnBook;
    }

    public spAccountData getMF_spAccountData() {
        return MF_spAccountData;
    }

    public void setMF_spAccountData(spAccountData MF_spAccountData) {
        this.MF_spAccountData = MF_spAccountData;
    }
}
