package Data.Project.G1.PublicClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class ToolBar extends JToolBar {
    private ArrayList<ToolBarAction> Tools = new ArrayList<ToolBarAction>();
    private ToolBarAction btnTool;
    private int numTool = 0;

    public ToolBar(){
        super(JToolBar.HORIZONTAL);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        setFloatable(false);
        setBackground(Color.WHITE);
    }

    public void AddTool(String name, ImageIcon head) {
        btnTool = new ToolBarAction(name, head);
        btnTool.addActionListener(this.btnTool);
        btnTool.setBackground(Color.WHITE);
        btnTool.setForeground(Color.BLACK);
        btnTool.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnTool.setFont(new Font("微軟正黑體", Font.BOLD, 16));

        Tools.add(btnTool);
        numTool++;
        add(btnTool);

    }

}
