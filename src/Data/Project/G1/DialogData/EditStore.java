package Data.Project.G1.DialogData;

import Data.Project.G1.DataClass.StoreData;
import Data.Project.G1.MainScreen.MainTest;
import Data.Project.G1.PublicClass.ScreenSize;
import Data.Project.G1.ServerConnect.Global;
import Data.Project.G1.ServerConnect.sEditStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class EditStore extends BasicDialog implements ActionListener{
    private ScreenSize scSize;

    private JLabel lbl;
    private JTextField enter_name;
    private JLabel Error;

    private JButton OK;
    private JButton cancel;

    private Global gbl;
    private sEditStore se;

    private String choose;

    public EditStore(JFrame f, String str, boolean model){
        super(f,str,model);

        scSize = new ScreenSize();
        choose = MainTest.testFrame.getMF_spAccountData().getIfST().getIfST_lsBookStore().getSelectedValue().toString();
//        System.out.println("Choose" + choose);

        SetTheSize(new int[]{50,30,80,80,50},
                new int[]{30,30,30,30,30});

        Error = new JLabel("");
        AddFiled(Error, new int[]{2,1,1,2});

        lbl = new JLabel("Store Name: ");
        AddFiled(lbl, new int[]{1,2,1,1});

        enter_name = new JTextField(choose);
        AddFiled(enter_name, new int[]{2,2,1,2});

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{2, 3, 1, 1});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{3, 3, 1, 1});

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                scSize.getHeight()/2 - this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            dispose();
            System.out.println();
        }
        else if(e.getSource() == OK){

            StoreData chStore = new StoreData();

            for(StoreData i : MainTest.stList){
                if(i.getStore_Name() == choose) {
                    chStore = i;
                    break;
                }
            }

            try {
                System.out.println("Edit Store Dialog: name: " + enter_name.getText() +
                        "  ID: " + chStore.getStore_ID());
                se = new sEditStore(gbl.getToken(), enter_name.getText()
                            , chStore.getStore_ID());

            }
            catch (IOException I){
                System.out.println("EditAccount actionPerformed IOException " + I.getMessage());
            }

            if (se.getRespondcode() / 100 == 2) {
                dispose();
                System.out.println();
            } else
                Error.setText("請輸入正確名稱!!");
        }
    }
}
