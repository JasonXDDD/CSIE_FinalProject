package Data.Project.G1.MainScreen;

import javax.swing.*;

/**
 * Created by JASON_ on 2015/5/18.
 */
public class spAccountData extends JSplitPane {
    private ifAccountTool ifAT;
    private ImageIcon ifAT_iconHead;

    private ifStoreTool ifST;
    private String[] ifST_strBookName;

    public spAccountData(){
        super(JSplitPane.VERTICAL_SPLIT, true);

        //ifAT_iconHead = new ImageIcon(getClass().getResource("ResourceData/account_head.png"));
        System.out.println("In frame data: " + MainTest.accountData.getAccount_Name());
        ifAT = new ifAccountTool(MainTest.accountData.getAccount_Head(),
                                 MainTest.accountData.getAccount_Name(), 37, 100);
        ifAT.setBounds(100, 100, 280, 400);

        add(ifAT);

        ifST_strBookName = new String[100];
        for(int i = 0; i < MainTest.stList.size(); i++) {
            ifST_strBookName[i] = MainTest.stList.get(i).getStore_Name();
        }
        ifST = new ifStoreTool(3, ifST_strBookName);
        ifST.setBounds(500, 100, 280, 610);

        add(ifST);

        setDividerLocation(400);
        setOneTouchExpandable(true);
        setDividerSize(10);

    }

    public ifAccountTool getIfAT() {
        return ifAT;
    }

    public ifStoreTool getIfST() {
        return ifST;
    }
}
