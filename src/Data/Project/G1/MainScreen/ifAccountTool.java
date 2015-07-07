package Data.Project.G1.MainScreen;

import javax.swing.*;
import java.awt.*;
import Data.Project.G1.PublicClass.*;

import java.awt.Color;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class ifAccountTool extends JInternalFrame {
    private JLayeredPane lp_layer;

    private JLabel ifAT_iclblHead;
    private JLabel ifAT_lblName;
    private Font lblName_ftName;
    private JProgressBar ifAT_pbSpace;

    private ToolBar ifAT_toolbar;

    public ifAccountTool(ImageIcon head, String name, int usingsp, int totalsp){
        super("AccountTool", false, false, false, false);
        setLayout(null);
        lp_layer = this.getLayeredPane();

        head = ImageProcess.scaleImage(head, 230, ImageProcess.Auto);
        head = ImageProcess.cutImage(head, 0, 0, 230, 230);

        ifAT_iclblHead = new JLabel(head);
        ifAT_iclblHead.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        ifAT_iclblHead.setBounds(20, 20, 230, 230);
        ifAT_iclblHead.setBackground(Color.BLACK);
        getContentPane().add(ifAT_iclblHead);

        lblName_ftName = new Font("微軟正黑體", Font.BOLD, 20);
        ifAT_lblName = new JLabel(name, JLabel.CENTER);
        ifAT_lblName.setFont(lblName_ftName);
        ifAT_lblName.setBounds(20, 210, 230, 130);
        getContentPane().add(ifAT_lblName);

        ifAT_pbSpace = new JProgressBar();
        ifAT_pbSpace.setMaximum(totalsp);
        ifAT_pbSpace.setMinimum(0);
        ifAT_pbSpace.setValue(usingsp);
        ifAT_pbSpace.setBorderPainted(true);
        ifAT_pbSpace.setStringPainted(true);
        ifAT_pbSpace.setBounds(20, 300, 230, 20);
        getContentPane().add(ifAT_pbSpace);

        ifAT_toolbar = new ToolBar();
        ifAT_toolbar.AddTool("aEdit", null);
        ifAT_toolbar.AddTool("Plus", null);
        ifAT_toolbar.AddTool("Logout", null);
        lp_layer.setLayout(new BorderLayout());
        lp_layer.add(ifAT_toolbar, BorderLayout.SOUTH, new Integer(2550));

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public JLabel getIfAT_lblName() {
        return ifAT_lblName;
    }

    public JLabel getIfAT_iclblHead() {
        return ifAT_iclblHead;
    }
}
