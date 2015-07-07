package Data.Project.G1.DataClass;

import javafx.scene.shape.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class AccountData {
    private ImageIcon Account_Head;
    private String Account_HeadURL;
    private String Account_Name;
    private String Account_Email;
    private String Account_Password;
    private int Account_ID;
    private boolean Account_deactivated = false;

    private ArrayList<StoreData> Stores = new ArrayList<StoreData>();
    private StoreData StoreSample;

    public AccountData(){ }

    public boolean isAccount_deactivated() {
        return Account_deactivated;
    }

    public void setAccount_deactivated(boolean account_deactivated) {
        Account_deactivated = account_deactivated;
    }

    public String getAccount_Email() {
        return Account_Email;
    }

    public void setAccount_Email(String account_Email) {
        Account_Email = account_Email;
    }

    public ImageIcon getAccount_Head() {
        return Account_Head;
    }

    public void setAccount_Head(ImageIcon account_Head) {
        Account_Head = account_Head;
    }

    public int getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(int account_ID) {
        Account_ID = account_ID;
    }

    public String getAccount_Name() {
        return Account_Name;
    }

    public void setAccount_Name(String account_Name) {
        Account_Name = account_Name;
    }

    public String getAccount_Password() {
        return Account_Password;
    }

    public void setAccount_Password(String account_Password) {
        Account_Password = account_Password;
    }

    public ArrayList<StoreData> getStores() {
        return Stores;
    }

    public void setStores(ArrayList<StoreData> stores) {
        Stores = stores;
    }

    public StoreData getStoreSample() {
        return StoreSample;
    }

    public void setStoreSample(StoreData storeSample) {
        StoreSample = storeSample;
    }

    public String getAccount_HeadURL() {
        return Account_HeadURL;
    }

    public void setAccount_HeadURL(String account_HeadURL) {
        Account_HeadURL = account_HeadURL;
    }
}
