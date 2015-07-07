package Data.Project.G1.TEST;

import Data.Project.G1.DialogData.EditAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/23.
 */
public class JDialog_Frame extends JFrame implements ActionListener{
    private JButton XDD = new JButton("XDD");

    public JDialog_Frame(){
        add(XDD, BorderLayout.CENTER);
        XDD.addActionListener(this);


        setVisible(true);
        setSize(500,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = null;

        if(e.getSource() == XDD){
            EditAccount editAccount = new EditAccount(null, "Edit Account", true);
            editAccount.setVisible(true);
        }
    }
}
