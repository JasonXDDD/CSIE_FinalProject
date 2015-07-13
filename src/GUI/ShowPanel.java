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
    private Font font;


    private ImageProcess imageProcess;

    public ShowPanel(String title, String content, ImageIcon pic, boolean isProject){
        Pic = pic;
        this.isProject = isProject;
        this.setLayout(null);

        font = new Font("微軟正黑體", Font.BOLD, 72);
        Title = new JLabel(title);
        Title.setFont(font);
        Title.setHorizontalAlignment(JLabel.LEFT);
        Title.setBounds(50, 50, 400, 100);
        Title.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Title);


        font = new Font("微軟正黑體", Font.BOLD, 20);
        Content = new JLabel(content);
        Content.setFont(font);
        Content.setHorizontalAlignment(JLabel.LEFT);
        Content.setBounds(100, 130, 500, 50);
        Content.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Content);

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
        Head.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.add(Head);

        Pic = imageProcess.scaleImage(Pic, 900, imageProcess.Width);
        BackGround = new JLabel(Pic);
        BackGround.setBounds(0, 0, 1200, 900);
        this.add(BackGround);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
