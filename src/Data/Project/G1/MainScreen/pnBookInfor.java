package Data.Project.G1.MainScreen;

import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.PublicClass.ImageProcess;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/18.
 */
public class pnBookInfor extends JPanel {
    private BookData book;

    private JLabel lbl;

    private JLabel bk_name;
    private JLabel bk_head;
    private JLabel bk_ISBN;
    private JLabel bk_Author;
    private JLabel bk_Publisher;
    private JLabel bk_Date;
    private JLabel bk_Price;

    private ImageIcon Show;

    private int[][] position= new int[][]{
            {1,1,1,1}, {2,1,1,1},
            {1,2,1,1}, {2,2,1,1},
            {1,4,1,1}, {2,4,1,1},
            {1,5,1,1}, {2,5,1,1},
            {1,6,1,1}, {2,6,1,1},
            {1,7,1,1}, {2,7,1,1},
            {0,1,1,7}, {2,8,1,1}};

    private GridBagConstraints gbc = new GridBagConstraints();
    private GridBagLayout gblayout = new GridBagLayout();

    public pnBookInfor(BookData book){
        gblayout.columnWidths = new int[]{400, 150, 300};
        gblayout.rowHeights = new int[]{10, 20, 20, 20, 20, 20, 20, 20, 20, 10};
        setLayout(gblayout);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);

        this.book = book;

        bk_name = new JLabel();
        SetLabel(bk_name);
        bk_ISBN = new JLabel();
        SetLabel(bk_ISBN);
        bk_Author = new JLabel();
        SetLabel(bk_Author);
        bk_Publisher = new JLabel();
        SetLabel(bk_Publisher);
        bk_Date = new JLabel();
        SetLabel(bk_Date);
        bk_Price = new JLabel();
        SetLabel(bk_Price);

        Show = ImageProcess.scaleImage(book.getBk_cover(), 200, ImageProcess.Width);

        for(int i = 0; i <= 13; i++){
            gbc.gridx = position[i][0];
            gbc.gridy = position[i][1];
            gbc.gridwidth = position[i][2];
            gbc.gridheight = position[i][3];

            lbl = new JLabel();
            SetLabel(lbl);

            switch (i){
                case 0:
                    lbl.setText("Name");
                    add(lbl,gbc);
                    break;
                case 2:
                    lbl.setText("ISBN");
                    add(lbl,gbc);
                    break;
                case 4:
                    lbl.setText("Author");
                    add(lbl,gbc);
                    break;
                case 6:
                    lbl.setText("Publisher");
                    add(lbl,gbc);
                    break;
                case 8:
                    lbl.setText("Date");
                    add(lbl,gbc);
                    break;
                case 10:
                    lbl.setText("Price");
                    add(lbl,gbc);
                    break;

                case 1:
                    bk_name.setText(book.getBk_Name());
                    add(bk_name,gbc);
                    break;
                case 3:
                    bk_ISBN.setText(book.getBk_ISBN());
                    add(bk_ISBN,gbc);
                    break;
                case 5:
                    bk_Author.setText(book.getBk_Author());
                    add(bk_Author,gbc);
                    break;
                case 7:
                    bk_Publisher.setText(book.getBk_Publisher());
                    add(bk_Publisher,gbc);
                    break;
                case 9:
                    bk_Date.setText(book.getBk_PubDate());
                    add(bk_Date,gbc);
                    break;
                case 11:
                    bk_Price.setText(book.getBk_Price() + "");
                    add(bk_Price,gbc);
                    break;

                case 12:
                    bk_head = new JLabel(Show);
                    gbc.fill = 0;
                    bk_head.setBorder(BorderFactory.createLineBorder(Color.black));
                    SetLabel(bk_head);
                    add(bk_head,gbc);
                    break;
            }

        }

        setBackground(Color.WHITE);
    }

    public pnBookInfor(){
        gblayout.columnWidths = new int[]{400, 150, 300};
        gblayout.rowHeights = new int[]{40, 30, 30, 30, 30, 30, 30, 30, 30, 40};
        setLayout(gblayout);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);

        bk_name = new JLabel();
        SetLabel(bk_name);
        bk_ISBN = new JLabel();
        SetLabel(bk_ISBN);
        bk_Author = new JLabel();
        SetLabel(bk_Author);
        bk_Publisher = new JLabel();
        SetLabel(bk_Publisher);
        bk_Date = new JLabel();
        SetLabel(bk_Date);
        bk_Price = new JLabel();
        SetLabel(bk_Price);


        for(int i = 0; i <= 13; i++){
            gbc.gridx = position[i][0];
            gbc.gridy = position[i][1];
            gbc.gridwidth = position[i][2];
            gbc.gridheight = position[i][3];

            lbl = new JLabel();
            SetLabel(lbl);

            switch (i){
                case 0:
                    lbl.setText("Name");
                    add(lbl,gbc);
                    break;
                case 2:
                    lbl.setText("ISBN");
                    add(lbl,gbc);
                    break;
                case 4:
                    lbl.setText("Author");
                    add(lbl,gbc);
                    break;
                case 6:
                    lbl.setText("Publisher");
                    add(lbl,gbc);
                    break;
                case 8:
                    lbl.setText("Date");
                    add(lbl,gbc);
                    break;
                case 10:
                    lbl.setText("Price");
                    add(lbl,gbc);
                    break;

                case 1:
                    add(bk_name,gbc);
                    break;
                case 3:
                    add(bk_ISBN,gbc);
                    break;
                case 5:
                    add(bk_Author,gbc);
                    break;
                case 7:
                    add(bk_Publisher,gbc);
                    break;
                case 9:
                    add(bk_Date,gbc);
                    break;
                case 11:
                    add(bk_Price,gbc);
                    break;

                case 12:
                    bk_head = new JLabel();
                    add(bk_head,gbc);
                    break;
            }

        }

        setBackground(Color.WHITE);
    }

    public void SetLabel(JLabel lbl){
        //lbl.setBorder(BorderFactory.createLineBorder(Color.black));
        lbl.setHorizontalAlignment(JLabel.LEFT);
        lbl.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        lbl.setForeground(Color.BLACK);
    }

}
