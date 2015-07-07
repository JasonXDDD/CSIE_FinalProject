package Data.Project.G1.DialogData;

import Data.Project.G1.MainScreen.MainTest;
import Data.Project.G1.PublicClass.ImageProcess;
import Data.Project.G1.PublicClass.ScreenSize;
import Data.Project.G1.ServerConnect.Global;
import Data.Project.G1.ServerConnect.sEditAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class EditAccount extends BasicDialog implements ActionListener{
    private ScreenSize scSize;
    private sEditAccount se;
    private Global gbl;

    private File file;
    private ImageIcon Show, head;

    private JLabel lbl;
    private JLabel Error;
    private JTextField enter_name;
    private JPasswordField enter_passwd;
    private JButton OK, cancel, headbtn;

    private boolean IsSetData = false;

    public EditAccount(JFrame f, String str, boolean model){
        super(f, str, model);

        scSize = new ScreenSize();

//        SetTheSize(new int[]{50, 30, 80, 80, 50},  //col width
//                new int[]{30, 35, 35, 35, 35, 35, 30});  //row height
        SetTheSize(new int[]{50, 60, 120, 30, 80, 80, 50},
                new int[]{30, 30, 30, 30, 30, 60, 30, 30});

        Error = new JLabel("");
        AddFiled(Error, new int[]{4,1,1,3});

        lbl = new JLabel("Name: ");
        AddFiled(lbl, new int[]{3,2,1,1});

        enter_name = new JTextField(MainTest.accountData.getAccount_Name());
        AddFiled(enter_name, new int[]{4,2,1,2});

        lbl = new JLabel("Password: ");
        AddFiled(lbl, new int[]{3,3,1,1});

        enter_passwd = new JPasswordField(MainTest.accountData.getAccount_Password());
        AddFiled(enter_passwd, new int[]{4,3,1,2});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{5,6,1,1});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{4,6,1,1});

        head = MainTest.accountData.getAccount_Head();
        Show = ImageProcess.scaleImage(head, 180, ImageProcess.Auto);
        Show = ImageProcess.cutImage(Show, 0,0,180,180);

        headbtn = new JButton(Show);
        headbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        headbtn.setBackground(Color.white);
        headbtn.addActionListener(this);
        AddFiled(headbtn, new int[]{1,1,5,2});

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                    scSize.getHeight()/2- this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == OK) {
            try {
                Error.setText("");
                se = new sEditAccount(gbl.getToken(),
                        enter_name.getText(),
                        new String(enter_passwd.getPassword()),
                        MainTest.accountData.getAccount_ID(),
                        file);
                System.out.println("On Dialog: Name: " + enter_name.getText() +
                        "  password: " + new String(enter_passwd.getPassword()) +
                        "  UserID: " + MainTest.accountData.getAccount_ID() +
                        "  Head: " + MainTest.accountData.getAccount_Head().getDescription());
            } catch (IOException I) {
                System.out.println("EditAccount actionPerformed IOException " + I.getMessage());
            }


            if (se.getRespondcode() / 100 == 2) {
                dispose();
                System.out.println();
                IsSetData = true;
            } else
                Error.setText("帳號已存在!");
        }

        else if(e.getSource() == cancel){
            dispose();
            System.out.println();
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

    public boolean isSetData() {
        return IsSetData;
    }
}
