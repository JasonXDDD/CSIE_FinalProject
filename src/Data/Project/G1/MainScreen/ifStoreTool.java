package Data.Project.G1.MainScreen;

import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.DataClass.StoreData;
import Data.Project.G1.PublicClass.ToolBar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class ifStoreTool extends JInternalFrame implements ListSelectionListener{
    private JLayeredPane lp_layer;
    private ScrollPane sp_scroll;

    private JList ifST_lsBookStore;
    private String[] lsBS_strName;
    private int lsBS_numBook;
    private Font lsBS_font;

    private ToolBar ifST_toolbar;

    public ifStoreTool(int booknum, String[] bookname){
        super("BookTool", false, false, false, false);
        setLayout(new BorderLayout());
        lp_layer = this.getLayeredPane();
        sp_scroll = new ScrollPane();

        lsBS_font = new Font("微軟正黑體", Font.BOLD, 20);
        this.lsBS_numBook = booknum;
        this.lsBS_strName = bookname;
        ifST_lsBookStore = new JList(lsBS_strName);
        ifST_lsBookStore.setSelectedIndex(0);
        ifST_lsBookStore.setBorder(BorderFactory.createTitledBorder("BookStore"));
        ifST_lsBookStore.setBackground(Color.WHITE);
        ifST_lsBookStore.setFont(lsBS_font);
        ifST_lsBookStore.addListSelectionListener(this);

        sp_scroll.add(ifST_lsBookStore);
        getContentPane().add(sp_scroll, BorderLayout.CENTER);

        ifST_toolbar = new ToolBar();
        ifST_toolbar.AddTool("sAdd", null);
        ifST_toolbar.AddTool("sEdit", null);
        ifST_toolbar.AddTool("Delete", null);
        lp_layer.setLayout(new BorderLayout());
//        lp_layer.add(ifST_toolbar, BorderLayout.SOUTH, new Integer(8550));
        getContentPane().add(ifST_toolbar, BorderLayout.SOUTH);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public JList getIfST_lsBookStore() {
        return ifST_lsBookStore;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == ifST_lsBookStore){

            try {
                MainTest.testFrame.getMF_pnBook().getPnCeter().removeAll();
                MainTest.testFrame.getMF_pnBook().getPnCeter().repaint();

                System.out.println("e.LastIndex: " + e.getLastIndex() +
                        "e.FirstIndex: " + e.getFirstIndex() +
                        "lsBookStore getIndex" + ifST_lsBookStore.getSelectedIndex());


                for (int b : MainTest.stList.get(ifST_lsBookStore.getSelectedIndex()).getBooks_ID()) {
                    for (BookData a : MainTest.bkList) {
                        if (a.getBk_ID() == b) {
                            System.out.println("Set Book: name:" + a.getBk_Name());
                            MainTest.testFrame.getMF_pnBook().AddBook(a);

                        }
                    }
                }

                MainTest.testFrame.revalidate();
                MainTest.testFrame.repaint();
                System.out.println("!!!MainFrame Renew!!!\n");
            }
            catch (ArrayIndexOutOfBoundsException I){}
            catch (IndexOutOfBoundsException I){}
        }
    }
}
