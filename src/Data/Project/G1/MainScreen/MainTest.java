package Data.Project.G1.MainScreen;

import Data.Project.G1.DataClass.AccountData;
import Data.Project.G1.DataClass.BookData;
import Data.Project.G1.DataClass.StoreData;
import Data.Project.G1.DialogData.Login;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainTest {
    public static AccountData accountData = new AccountData();
    public static BookData bookData = new BookData();
    public static ArrayList<BookData> bkList = new ArrayList<BookData>();
    public static StoreData storeData = new StoreData();
    public static ArrayList<StoreData> stList = new ArrayList<StoreData>();
    public static MainFrame testFrame;

    public static void main(String[] args) throws IOException{
        String string;
        Loading frame = new Loading();

        Login login = new Login(null, "Login", true);
        login.setVisible(true);

    }


}
