package Data.Project.G1.DialogData;

import Data.Project.G1.MainScreen.MainFrame;
import Data.Project.G1.MainScreen.MainTest;
import Data.Project.G1.PublicClass.GBConstraint;
import Data.Project.G1.PublicClass.ImageProcess;
import Data.Project.G1.PublicClass.ScreenSize;
import Data.Project.G1.ServerConnect.Global;
import Data.Project.G1.ServerConnect.sAddStore;
import Data.Project.G1.ServerConnect.sRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


/**
 * Created by JASON_ on 2015/5/25.
 */
public class Register extends JDialog implements ActionListener{
    private ScreenSize scSize;
    private sRegister sr;
    private sAddStore sa;

    private Global gbl;

    private JLabel lbl;
    private JLabel Error;
    private JTextField enter_name;
    private JTextField enter_email;
    private JPasswordField enter_passwd;
    private JButton create;
    private JButton log;

    private File file;

    private ImageIcon head;
    private ImageIcon Show;

    private JButton headbtn;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();

    private int[][] position = new int[][]{
                                  {4,1,1,3},
                       {3,2,1,1}, {4,2,1,2},
                       {3,3,1,1}, {4,3,1,2},
                       {3,4,1,1}, {4,4,1,2},
                                  {4,5,1,2},
                                  {5,6,1,1},
            {1,7,1,1}, {1,1,5,2},

    };

    public Register(JFrame f, String str, boolean model){
        super(f, str, model);

        gbl = new Global();

        System.out.println("-----Register-----");

        gb.rowHeights = new int[]{30, 30, 30, 30, 30, 60, 30, 30};
        gb.columnWidths = new int[]{50, 60, 120, 30, 30, 130, 50};
        setLayout(gb);
        scSize = new ScreenSize();


        for(int i = 0; i <= 10; i++){
            gbc.setValue(gbc, position[i][0], position[i][1],
                              position[i][2], position[i][3]);

            switch (i){
                case 0:
                    Error = new JLabel("");
                    add(Error, gbc);
                    break;
                case 1:
                    lbl = new JLabel("Email(帳號): ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 2:
                    enter_email = new JTextField();
                    getContentPane().add(enter_email, gbc);
                    break;
                case 3:
                    lbl = new JLabel("User Name: ");
                    add(lbl, gbc);
                    break;
                case 4:
                    enter_name = new JTextField();
                    getContentPane().add(enter_name, gbc);
                    break;
                case 5:
                    lbl = new JLabel("Password: ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 6:
                    enter_passwd = new JPasswordField();
                    getContentPane().add(enter_passwd, gbc);
                    break;
                case 7:
                    lbl = new JLabel("Email為之後登入帳號，註冊後不可修改。");
                    getContentPane().add(lbl, gbc);
                    break;
                case 8:
                    create = new JButton("Create");
                    getContentPane().add(create, gbc);
                    create.addActionListener(this);
                    break;
                case 9:
                    log = new JButton("Login");
                    getContentPane().add(log, gbc);
                    log.addActionListener(this);
                    break;
                case 10:
                    headbtn = new JButton();
                    headbtn.setBorder(BorderFactory.createLineBorder(Color.black));
                    headbtn.setBackground(Color.white);
                    getContentPane().add(headbtn, gbc);
                    headbtn.addActionListener(this);
                    break;
            }
        }

        setLocation(scSize.getWidth() / 2 - 160, scSize.getHeight() / 2 - 105);
        pack();
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            try {
                Error.setText("");
                sr = new sRegister(gbl.getToken(), enter_name.getText(),
                                    enter_email.getText(),
                                    new String(enter_passwd.getPassword()),
                                    file);
                System.out.println( "On Dialog: Name: " + enter_name.getText()+
                                    "  email: " + enter_email.getText()+
                                    "  password: " + new String(enter_passwd.getPassword()) +
                                    "  Head: " + file.getPath());
            }
            catch (IOException I){}


            if(sr.getRespondcode()/100 == 2){
                dispose();
                System.out.println();
                try {
                    sa = new sAddStore(gbl.getToken(), "All");
                }catch (IOException I){}

                MainTest.testFrame = new MainFrame();
            }
            else
                Error.setText("帳號已存在!");
        }

        else if(e.getSource() == log){
            try {
                dispose();
                Login login = new Login(null, "Login", true);
                login.setVisible(true);
                System.out.println();
            }
            catch (IOException I){}
        }

        else if(e.getSource() == headbtn){
            String str = new String("");
            FileDialog fd = new FileDialog(this, "FileDialog", FileDialog.LOAD);
            fd.setVisible(true);

            str = fd.getDirectory() + fd.getFile();

            file = new File(str);
            System.out.println("set head file: " + file.toString());
            head = new ImageIcon(str);

            Show = ImageProcess.scaleImage(head, 180, ImageProcess.Auto);
            Show = ImageProcess.cutImage(Show, 0,0,180,180);

            headbtn.setIcon(Show);
        }
    }

}
