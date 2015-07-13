package GUI;

import Public_Class.ImageProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JASON_ on 2015/7/4.
 */
public class ShowPanel extends JPanel implements ActionListener{
    private JLabel Title;
    private JLabel Content;
    private JLabel Head;
    private JLabel BackGround;
    private boolean isProject;
    private JButton Project;
    private JButton Openfile;
    private ImageIcon Pic;
    private ImageIcon Bk;
    private Font font;


    private ImageProcess imageProcess;

    public ShowPanel(String title, String content, ImageIcon pic, ImageIcon bk, boolean isProject){
        Pic = pic;
        Bk = bk;
        this.isProject = isProject;
        this.setLayout(null);

        font = new Font("微軟正黑體", Font.BOLD, 72);
        Title = new JLabel(title);
        Title.setFont(font);
        Title.setHorizontalAlignment(JLabel.LEFT);
        Title.setBounds(50, 50, 1400, 100);
        this.add(Title);


        font = new Font("微軟正黑體", Font.BOLD, 30);
        Content = new JLabel(content);
        Content.setFont(font);
        Content.setHorizontalAlignment(JLabel.LEFT);
        Content.setBounds(150, 140, 1500, 50);
        this.add(Content);

        font = new Font("微軟正黑體", Font.BOLD, 25);
        Project = new JButton("Project");
        Project.setBackground(Color.WHITE);
        Project.setFont(font);
        Project.setBounds(80, 210, 150, 50);
        if(!isProject)
            Project.setEnabled(false);
        this.add(Project);

        Openfile = new JButton("OpenFile");
        Openfile.setBackground(Color.WHITE);
        Openfile.setFont(font);
        Openfile.setBounds(280, 210, 150, 50);
        this.add(Openfile);

        Pic = imageProcess.scaleImage(Pic, 800, imageProcess.Height);
        Head = new JLabel(Pic);
        Head.setBounds(80, 310, 800, 600);
        Head.setVerticalAlignment(JLabel.TOP);
        this.add(Head);

        Bk = imageProcess.scaleImage(Bk, 900, imageProcess.Width);
        BackGround = new JLabel(Bk);
        BackGround.setHorizontalAlignment(JLabel.LEFT);
        BackGround.setBounds(0, 0, 1200, 900);
        this.add(BackGround);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
