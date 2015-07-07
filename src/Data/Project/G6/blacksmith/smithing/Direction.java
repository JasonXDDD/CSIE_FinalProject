package Data.Project.G6.blacksmith.smithing;

import java.awt.Font;
import java.awt.TextArea;


import javax.swing.JPanel;

public class Direction extends JPanel{
    private TextArea story;
    
    public Direction(){
        this.setLayout(null);
        String s = "Long long time ago. Blacksmith is the most noble profession on the Continent "
                +"People say, they only have a black hammer working with an inferior workbench,"
                +"but they can creat the most powerful weapon in the world."
                +"People say. the keep a low profile.We won��t notice their exist in common days,"
                +"they only show up when people need them."
                +"People say.they are the richest people , a blacksmith should be wealthy."
                +"They.... they are almost flawless ,every forces should be their attached!"
                +"They behoove be the favourite of God."
                +"But, their right of develop had been token."
                +"Thousands year passed. You borned in a declining family."
                +"At the date you come of age, you hit on an ancient book in the locked wareroom."
                + "even the book is covered with thick dust,you bearly can see the title "
                +":The path of Blacksmith.Now , the great journey begin!";
        
        story = new TextArea(s, 20, 25, TextArea.SCROLLBARS_VERTICAL_ONLY);
        story.setFont(new Font("Arial", Font.BOLD,20));
        story.setEditable(false);
        
        story.setBounds(100, 200, 600, 350);
        
        add(story);
    }
}
