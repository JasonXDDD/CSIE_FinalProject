package Data.Project.G1.DialogData;

import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.MainScreen.MainTest;
import Data.Project.G1.PublicClass.ImageProcess;
import Data.Project.G1.PublicClass.ScreenSize;
import Data.Project.G1.ServerConnect.Global;
import Data.Project.G1.ServerConnect.sEditBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class EditBook extends BasicDialog implements ActionListener, ItemListener {
    private ScreenSize scSize;
    private Global gbl;
    private String[] storeName = new String[100];

    private ImageIcon head, Show;
    private JButton headbtn;
    private JLabel lbl;
    private JLabel Error;
    private JButton cancel;
    private JButton OK;

    private JTextField enter_Name;
    private JTextField enter_ISBN;
    private JTextField enter_Author;
    private JTextField enter_Publisher;
    private JTextField enter_PubDate;
    private JTextField enter_Price;
    private JTextField enter_Tag;

    private ArrayList<JComboBox> StoreList = new ArrayList<JComboBox>();
    private JComboBox enter_Store;
    private int y = 9;

    private File file = null;
    private sEditBook seb;

    private BookData choose;

    public EditBook(JFrame f, String str, boolean model, BookData choose){
        super(f, str, model);
        scSize = new ScreenSize();

        SetTheSize(new int[]{50,180,30,80,80,50},
                new int[]{30,30,30,30,30,30,30,30,30,30,30,30,30});

        this.choose = choose;
        if(choose == null) this.dispose();

        head = choose.getBk_cover();
        Show = ImageProcess.scaleImage(head, 210, ImageProcess.Auto);


        for(int a = 0; a < MainTest.stList.size(); a++){
            storeName[a] = new String(MainTest.stList.get(a).getStore_Name());
//            System.out.println("Store size: " + MainTest.stList.size());
            System.out.println("Store " + a + ": " + MainTest.stList.get(a).toString());
        }

        headbtn = new JButton(Show);
        headbtn.setBorder(BorderFactory.createLineBorder(Color.black));
        headbtn.setBackground(Color.WHITE);
        headbtn.addActionListener(this);
        AddFiled(headbtn, new int[]{1, 2, 7, 1});

        Error = new JLabel("必須輸入名稱"); AddFiled(Error, new int[]{3,1,1,2});
        lbl = new JLabel("Name: ");         AddFiled(lbl, new int[]{2,2,1,1});
        lbl = new JLabel("ISBN: ");         AddFiled(lbl, new int[]{2,3,1,1});
        lbl = new JLabel("Author: ");       AddFiled(lbl, new int[]{2,4,1,1});
        lbl = new JLabel("Publisher: ");    AddFiled(lbl, new int[]{2,5,1,1});
        lbl = new JLabel("Publish Date: "); AddFiled(lbl, new int[]{2,6,1,1});
        lbl = new JLabel("Price: ");        AddFiled(lbl, new int[]{2,7,1,1});
        lbl = new JLabel("Tag: ");          AddFiled(lbl, new int[]{2,8,1,1});

        enter_Name = new JTextField(choose.getBk_Name());
        AddFiled(enter_Name, new int[]{3,2,1,2});
        enter_ISBN = new JTextField(choose.getBk_ISBN());
        AddFiled(enter_ISBN, new int[]{3,3,1,2});
        enter_Author = new JTextField(choose.getBk_Author());
        AddFiled(enter_Author, new int[]{3,4,1,2});
        enter_Publisher = new JTextField(choose.getBk_Publisher());
        AddFiled(enter_Publisher, new int[]{3,5,1,2});
        enter_PubDate = new JTextField(choose.getBk_PubDate());
        AddFiled(enter_PubDate, new int[]{3,6,1,2});
        enter_Price = new JTextField(choose.getBk_Price());
        AddFiled(enter_Price, new int[]{3,7,1,2});
        enter_Tag = new JTextField(choose.getBk_Tag());
        AddFiled(enter_Tag, new int[]{3,8,1,2});


        enter_Store = new JComboBox(storeName);
        enter_Store.setSelectedIndex(0);
        enter_Store.addItemListener(this);
        AddFiled(enter_Store, new int[]{3, y, 1, 2});
        StoreList.add(enter_Store);


        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        AddFiled(cancel, new int[]{3,y+2,1,1});

        OK = new JButton("OK");
        OK.addActionListener(this);
        AddFiled(OK, new int[]{4,y+2,1,1});

        y++;

        pack();
        setLocation(scSize.getWidth()/2 - this.getWidth()/2,
                scSize.getHeight()/2 - this.getHeight()/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            System.out.println();
            dispose();
        }
        else if(e.getSource() == headbtn){
            String str = new String("");
            FileDialog fd = new FileDialog(this, "FileDialog", FileDialog.LOAD);
            fd.setVisible(true);

            str = fd.getDirectory() + fd.getFile();

            if(fd.getFile() != null) {
                file = new File(str);
                System.out.println("set head file: " + file.toString());
                head = new ImageIcon(str);

                Show = ImageProcess.scaleImage(head, 210, ImageProcess.Auto);

                headbtn.setIcon(Show);
            }
            pack();
        }
        else if(e.getSource() == OK){
            try{
                Error.setText("");
                ArrayList<Integer> store_id = new ArrayList<Integer>();
                for(JComboBox a : StoreList) {
                    store_id.add(MainTest.stList.get(a.getSelectedIndex()).getStore_ID());
                    System.out.println("select ID: " + MainTest.stList.get(a.getSelectedIndex()).getStore_ID());
                }

                Integer[] stid = new Integer[store_id.size()];
                stid = store_id.toArray(stid);

                for(Integer a : stid) {
                    System.out.println("Store id: " + a);
                }

                seb = new sEditBook(gbl.getToken(), enter_Name.getText(),
                        enter_ISBN.getText(), enter_Author.getText(),
                        enter_Publisher.getText(), enter_PubDate.getText(),
                        enter_Price.getText(), enter_Tag.getText(), stid,
                        choose.getBk_ID(), file);

                System.out.println( "On Dialog: Name: " + enter_Name.getText() +
                        "  ISBN: " + enter_ISBN.getText() +
                        "  Author: " + enter_Author.getText() +
                        "  Publisher: " + enter_Publisher.getText() +
                        "  PubDate: " + enter_PubDate.getText() +
                        "  Price: " + enter_Price.getText() +
                        "  Tags: " + enter_Tag.getText());
                if(file != null)
                    System.out.println("  File: " + file.toString());

            }
            catch (IOException I){}


            if(seb.getRespondcode()/100 == 2){
                dispose();
                System.out.println();
            }
            else
                Error.setText("名稱錯誤!!");
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == enter_Store) {
            if (enter_Store.getSelectedIndex() != -1) {
                System.out.println("Successful to select on combobox");

                int[] height = new int[100];
                for (int i = 0; i <= 13 + y - 10; i++) {
                    height[i] = new Integer(30);
                }
                SetTheSize(new int[]{50, 180, 30, 80, 80, 50}, height);

                enter_Store = new JComboBox(storeName);
                enter_Store.setSelectedIndex(0);
                enter_Store.addItemListener(this);
                AddFiled(enter_Store, new int[]{3, y, 1, 2});
                StoreList.add(enter_Store);

                remove(cancel);
                cancel = new JButton("Cancel");
                cancel.addActionListener(this);
                AddFiled(cancel, new int[]{3, y + 2, 1, 1});

                remove(OK);
                OK = new JButton("OK");
                OK.addActionListener(this);
                AddFiled(OK, new int[]{4, y + 2, 1, 1});

                y++;

                this.revalidate();
                this.repaint();
                this.pack();
            }
        }
    }
}
