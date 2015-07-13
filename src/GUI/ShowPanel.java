package GUI;

import Public_Class.ImageProcess;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JASON_ on 2015/7/4.
 */
public class ShowPanel extends JPanel{
    private JLabel Title;
    private JLabel Content;
    private JLabel Head;
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
        imageProcess = new ImageProcess();

        font = new Font("微軟正黑體", Font.BOLD, 72);
        Title = new JLabel(title);
        Title.setFont(font);
        Title.setHorizontalAlignment(JLabel.LEFT);
        Title.setBounds(100, 100, 400, 100);
        Title.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Title);


        font = new Font("微軟正黑體", Font.BOLD, 20);
        Content = new JLabel(content);
        Content.setFont(font);
        Content.setHorizontalAlignment(JLabel.LEFT);
        Content.setBounds(150, 190, 500, 50);
        Content.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Content);

        Project = new JButton("Project");
        Project.setBackground(Color.WHITE);
        Project.setFont(font);
        Project.setBounds(100, 270, 150, 50);
        if(isProject)
            Project.setEnabled(false);
        this.add(Project);

        Openfile = new JButton("OpenFile");
        Openfile.setBackground(Color.WHITE);
        Openfile.setFont(font);
        Openfile.setBounds(300, 270, 150, 50);
        this.add(Openfile);

        Head = new JLabel(Pic);
        Head.setBounds(100, 350, 800, 600);
        Head.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.add(Head);
    }
}
