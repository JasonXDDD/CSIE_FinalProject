package Data.Project.G1.DialogData;

import Data.Project.G1.MainScreen.MainFrame;
import Data.Project.G1.MainScreen.MainTest;
import Data.Project.G1.PublicClass.GBConstraint;
import Data.Project.G1.PublicClass.ScreenSize;
import Data.Project.G1.ServerConnect.Global;
import Data.Project.G1.ServerConnect.sLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class Login extends JDialog implements ActionListener{
    private ScreenSize scSize;
    private sLogin sl;
    private Global gbl;

    private JLabel lbl;
    private JLabel Error;
    private JTextField enter_email;
    private JPasswordField enter_passwd;
    private JButton log;
    private JButton reg;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();

    private int[][] position = new int[][]{
            {1,1,1,3},
            {1,2,1,1}, {2,2,1,2},
            {1,3,1,1}, {2,3,1,2},
                       {3,5,1,1},
            {0,6,1,1}
    };

    public Login(JFrame f, String  str, boolean model) throws IOException{
        super(f, str, model);

        System.out.println("-----Login-----");

        gb.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30};
        gb.columnWidths = new int[]{50, 30, 30, 130, 50};
        setLayout(gb);
        scSize = new ScreenSize();



        for(int i = 0; i <= 6; i++){
            gbc.setValue(gbc, position[i][0], position[i][1],
                              position[i][2], position[i][3]);

            switch (i){
                case 0:
                    Error = new JLabel("你需要穩定的網路連線，以獲得最佳體驗");
                    add(Error, gbc);
                    break;
                case 1:
                    lbl = new JLabel("Email: ");
                    add(lbl, gbc);
                    break;
                case 2:
                    enter_email = new JTextField();
                    getContentPane().add(enter_email, gbc);
                    break;
                case 3:
                    lbl = new JLabel("Password: ");
                    getContentPane().add(lbl, gbc);
                    break;
                case 4:
                    enter_passwd = new JPasswordField();
                    getContentPane().add(enter_passwd, gbc);
                    break;
                case 5:
                    log = new JButton("login");
                    getContentPane().add(log, gbc);
                    log.addActionListener(this);
                    break;
                case 6:
                    reg = new JButton("Regist");
                    getContentPane().add(reg, gbc);
                    reg.addActionListener(this);
                    break;
            }
        }

        setLocation(scSize.getWidth()/2 - 145,
                    scSize.getHeight()/2- 105);
        pack();
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == log){
                try {
                    Error.setText("");
                    sl = new sLogin(gbl.getToken(), enter_email.getText(),
                            new String(enter_passwd.getPassword()));
                } catch (IOException I) { }

            enter_passwd.setText("");
            enter_email.setText("");

            if (sl.getRespondcode()/100 == 2) {
                System.out.println();
                dispose();
                MainTest.testFrame = new MainFrame();
            }
            else Error.setText("帳號或是密碼不存在!");
        }

        else if(e.getSource() == reg){
            dispose();
            Register register = new Register(null, "Regist", true);
            register.setVisible(true);
            System.out.println();


        }
    }
}
