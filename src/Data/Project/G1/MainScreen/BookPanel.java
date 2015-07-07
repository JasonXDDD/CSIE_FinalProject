package Data.Project.G1.MainScreen;

import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.PublicClass.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class BookPanel extends JPanel implements ActionListener{
    private BookNode bookNode;
    private ArrayList<BookNode> bookNodesList = new ArrayList<BookNode>();

    private pnBookInfor bookInfor;

    private JPanel pnCeter;
    private JPanel pnBottom;

    private ToolBar BT_toolbar;

    private ScrollPane sp_scroll;

    private BookData choose;

    public BookPanel(){
        setLayout(new BorderLayout());
        sp_scroll = new ScrollPane();

        pnBottom = new JPanel();

        pnCeter = new JPanel(new WrapLayout(FlowLayout.LEADING, 60, 60));
        pnCeter.setSize(1000, 1500);
        pnCeter.setBackground(Color.WHITE);
        sp_scroll.add(pnCeter);
        add(sp_scroll, BorderLayout.CENTER);

        for(BookData a : MainTest.bkList) {
            System.out.println("Add Book: name:" + a.getBk_Name());
            AddBook(a);
        }

        BT_toolbar = new ToolBar();
        BT_toolbar.AddTool("bAdd", null);
        BT_toolbar.AddTool("bEdit", null);
        BT_toolbar.AddTool("Delete", null);
        add(BT_toolbar, BorderLayout.NORTH);


        bookInfor = new pnBookInfor();
        pnBottom.add(bookInfor);
        pnBottom.setBorder(BorderFactory.createLineBorder(Color.black));
        pnBottom.setBackground(Color.WHITE);
        add(pnBottom, BorderLayout.SOUTH);


        setBackground(Color.WHITE);
    }

    public void AddBook(BookData bookData){
        if(bookData.getBk_cover() == null)
            bookData.setBk_cover(new ImageIcon(getClass().getResource("bookhead.jpg")));
        else
            System.out.println("AddBook: " + bookData.getBk_cover().toString());

        bookNode = new BookNode(bookData);
        bookNode.addActionListener(this);
        bookNodesList.add(bookNode);
        pnCeter.add(bookNode);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(BookNode a : bookNodesList){
            if(e.getSource() == a){
                System.out.println("Select node: " + a.getText() + " ID: " + a.x);
                a.setBackground(Color.cyan);
                a.updateUI();

                for(BookData b : MainTest.bkList){
                    if(b.getBk_ID() == a.x){
                        choose = b;
                        pnBottom.remove(bookInfor);
                        bookInfor = new pnBookInfor(b);
                        pnBottom.add(bookInfor);
                    }
                }


            }
            else {
                a.setBackground(Color.WHITE);
                a.updateUI();
            }
        }
    }

    public BookData getChoose() {
        return choose;
    }

    public JPanel getPnCeter() {
        return pnCeter;
    }

    public void setPnCeter(JPanel pnCeter) {
        this.pnCeter = pnCeter;
    }
}
