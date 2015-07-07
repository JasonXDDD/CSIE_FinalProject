package Data.Project.G1.DialogData;

import Data.Project.G1.PublicClass.GBConstraint;
import Data.Project.G1.PublicClass.ScreenSize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/5/26.
 */



public class BasicDialog extends JDialog {
    private ScreenSize scSize;

    private GBConstraint gbc = new GBConstraint();
    private GridBagLayout gb = new GridBagLayout();
    private int rownum = 0;
    private int colnum = 0;


    private int[] col;
    private int[] row;

    public BasicDialog(JFrame f, String str, boolean model){
        super(f, str, model);

        setLayout(gb);
        scSize = new ScreenSize();


        gbc.fill = GridBagConstraints.BOTH;

        setLocation(scSize.getWidth()/2-this.getWidth()/2,
                    scSize.getHeight()/2-this.getHeight()/2);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        pack();

    }

    public void SetTheSize(int[] col, int[] row){
        this.col = col;
        this.row = row;

        gb.columnWidths = col;
        gb.rowHeights = row;
    }

    public void AddFiled(JComponent filed, int[] pos){
        gbc.setValue(gbc, pos[0], pos[1], pos[2], pos[3]);
        getContentPane().add(filed, gbc);

    }
}

