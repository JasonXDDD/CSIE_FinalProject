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

    private JLabel BackGround;
    private JLayeredPane layeredPane;

    private ImageProcess imageProcess;

    public GUIFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        this.setLayout(new BorderLayout());
        imageProcess = new ImageProcess();
        layeredPane = this.getLayeredPane();
        pData = new Project_Data();

        btn_pn = new JPanel(new GridLayout(17, 1, 17, 17));
        btn_pn.setOpaque(false);

        lbl = new JLabel("103 資工一B JAVA 期末報告");
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btn_pn.add(lbl);

        lbl = new JLabel("=======================");
        btn_pn.add(lbl);

        btn_pn.setBounds(0, 0, 200, 1000);
        for(int i = 1; i <= 15; i++){
            btn = new JButton("Group " + i);
            btn.setFont(new Font("微軟正黑體", Font.BOLD, 20));
            btn.addActionListener(this);
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
        cardLayout.show(east_pn, "G1");
        this.getContentPane().add(east_pn, BorderLayout.CENTER);

    }

    public void genShowPanel(){
        for(int i = 1; i <= 15; i++){
            showPanel = new ShowPanel(pData.getTitle(i),
                                      pData.getContent(i),
                                      pData.genHead("G" + i + ".png"),
                                      pData.genBackGround("G" + i + ".png"),
                                      pData.isProject(i));
            east_pn.add(showPanel, "G" + i);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < btnlist.size(); i++){
            if(e.getSource() == btnlist.get(i)){
                System.out.println(i);
                cardLayout.show(east_pn, "G" + (i+1));
            }
        }

    }
}
