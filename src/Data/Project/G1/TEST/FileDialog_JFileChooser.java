package Data.Project.G1.TEST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/5/22.
 */
public class FileDialog_JFileChooser extends JFrame implements ActionListener{
    JButton jb,jb2;

    public FileDialog_JFileChooser(){

        jb=new JButton("FileDialog");
        jb.addActionListener(this);
        jb2=new JButton("JFileChoose");
        jb2.addActionListener(this);

        this.add(jb,BorderLayout.NORTH);
        this.add(jb2,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(130,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    String Filename=null;

    public void Open(){
        FileDialog fd = new FileDialog(this, "FileDialog", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd!=null){
            Filename=fd.getDirectory() +fd.getFile();
            System.out.println("FileDialog---->"+Filename);
        }
    }

    public void JFile(){
        JFileChooser jfc=new JFileChooser();
        jfc.setDialogTitle("JFileChooser");
        int result = jfc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            Filename=jfc.getSelectedFile().getAbsolutePath();
            System.out.println("JFileChooser---->"+Filename);
        }

    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

        if(arg0.getSource()==jb){
            Open();
        }
        else if(arg0.getSource()==jb2){
            JFile();
        }
    }

}
