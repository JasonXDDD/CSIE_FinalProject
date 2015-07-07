package Data.Project.G1.PublicClass;

import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.DataClass.StoreData;
import Data.Project.G1.DialogData.*;
import Data.Project.G1.MainScreen.MainTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ToolBarAction extends JButton implements ActionListener{
    private ImageIcon head, Show;
    private String[] Name = new String[100];

    public ToolBarAction(String name, Icon icon){
        super(name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "aEdit"){
            EditAccount aEdit = new EditAccount(null, "EditAccount", true);
            aEdit.setVisible(true);

            if(aEdit.isSetData() == true) {
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_lblName().
                        setText(MainTest.accountData.getAccount_Name());

                System.out.println("Edit Head: " + MainTest.accountData.getAccount_Head());

                head = MainTest.accountData.getAccount_Head();
                Show = ImageProcess.scaleImage(head, 230, ImageProcess.Auto);
                Show = ImageProcess.cutImage(Show, 0, 0, 230, 230);
                MainTest.testFrame.getMF_spAccountData().getIfAT().getIfAT_iclblHead().
                        setIcon(Show);
            }
        }


        else if(e.getActionCommand() == "sAdd"){
            AddStore sAdd = new AddStore(null, "AddStore", true);
            sAdd.setVisible(true);

            int a = 0;
            for(StoreData i : MainTest.stList) {
                Name[a] = i.getStore_Name();
                System.out.println(Name[a]);
                a++;
            }

            MainTest.testFrame.getMF_spAccountData().getIfST().
                    getIfST_lsBookStore().setListData(Name);

//            MainTest.testFrame.getMF_spAccountData().getIfST().
//                    getIfST_lsBookStore().setSelectedIndex(0);
        }

        else if(e.getActionCommand() == "sEdit"){
            if(MainTest.testFrame.getMF_spAccountData().getIfST()
                    .getIfST_lsBookStore().isSelectionEmpty() == true) return;
            EditStore sEdit = new EditStore(null, "EditStore", true);
            sEdit.setVisible(true);

            int a = 0;
            for(StoreData i : MainTest.stList) {
                Name[a] = i.getStore_Name();
                System.out.println(Name[a]);
                a++;
            }

            MainTest.testFrame.getMF_spAccountData().getIfST().
                    getIfST_lsBookStore().setListData(Name);

//            MainTest.testFrame.getMF_spAccountData().getIfST().
//                    getIfST_lsBookStore().setSelectedIndex(0);
        }

        else if(e.getActionCommand() == "bAdd"){
            AddBook bAdd = new AddBook(null, "AddBook", true);
            bAdd.setVisible(true);



            MainTest.testFrame.getMF_pnBook().getPnCeter().removeAll();

            for(BookData a : MainTest.bkList) {
                System.out.println("Add Book: name:" + a.getBk_Name());
                MainTest.testFrame.getMF_pnBook().AddBook(a);
            }

            MainTest.testFrame.revalidate();
            MainTest.testFrame.repaint();
            System.out.println("!!!MainFrame Renew!!!\n");
        }

        else if(e.getActionCommand() == "bEdit"){
            EditBook bEdit = new EditBook(null, "EditBook", true, MainTest.testFrame.getMF_pnBook().getChoose());
            bEdit.setVisible(true);


            MainTest.testFrame.getMF_pnBook().getPnCeter().removeAll();

            for(BookData a : MainTest.bkList) {
                System.out.println("Add Book: name:" + a.getBk_Name());
                MainTest.testFrame.getMF_pnBook().AddBook(a);
            }

            MainTest.testFrame.revalidate();
            MainTest.testFrame.repaint();
            System.out.println("!!!MainFrame Renew!!!\n");

        }


    }
}
