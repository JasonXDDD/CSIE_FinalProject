package GUI;

import Data.Project_Data;
import Public_Class.ImageProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by JASON_ on 2015/6/9.
 */
public class GUIFrame extends JFrame implements ActionListener{
    private CardLayout cardLayout;

    private JLabel lbl;
    private JButton btn;
    private ArrayList<JButton> btnlist = new ArrayList<JButton>();
    private JPanel btn_pn;
    private JPanel west_pn;

    private JPanel east_pn;
    private ArrayList<ShowPanel> showList = new ArrayList<ShowPanel>();
    private ShowPanel showPanel;
    private ImageIcon head;
    private Project_Data pData;

    private ImageProcess imageProcess;

    public GUIFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setLayout(new BorderLayout());
        imageProcess = new ImageProcess();
        pData = new Project_Data();

        btn_pn = new JPanel(new GridLayout(17, 1, 20, 20));
        btn_pn.setOpaque(false);

        lbl = new JLabel("103 資工一B JAVA 期末報告");
        lbl.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btn_pn.add(lbl);

        lbl = new JLabel("==============================");
        btn_pn.add(lbl);

        btn_pn.setBounds(0, 0, 200, 1000);
        for(int i = 1; i <= 15; i++){
            btn = new JButton("Group " + i);
            btn.setFont(new Font("微軟正黑體", Font.BOLD, 20));
            btn_pn.add(btn);
            btnlist.add(btn);
        }

        west_pn = new JPanel();
        west_pn.add(btn_pn);
        west_pn.setBackground(Color.CYAN);
        this.getContentPane().add(west_pn, BorderLayout.WEST);

        cardLayout = new CardLayout();
        east_pn = new JPanel(cardLayout);
        genShowPanel();
    }

    public void genShowPanel(){
        for(int i = 1; i <= 15; i++){
            head = imageProcess.imageLoader("G" + i + ".png");
            showPanel = new ShowPanel(pData.getTitle(i),
                                      pData.getContent(i),
                                      head,
                                        )
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
