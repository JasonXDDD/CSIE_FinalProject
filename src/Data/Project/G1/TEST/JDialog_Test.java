package Data.Project.G1.TEST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/24.
 */
public class JDialog_Test extends JDialog implements ActionListener{
    private JLabel XDD = new JLabel("XDDDDDDD");
    private JButton close = new JButton("Close");

    public JDialog_Test(JFrame frame, String str, boolean model){
        super(frame,str,model);

        getContentPane().add(XDD, BorderLayout.CENTER);

        close.addActionListener(this);
        getContentPane().add(close, BorderLayout.SOUTH);

        setSize(100,300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close)
            dispose();
    }
}
