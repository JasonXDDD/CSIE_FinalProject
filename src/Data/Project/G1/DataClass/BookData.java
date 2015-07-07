package Data.Project.G1.DataClass;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/15.
 */
public class BookData {
    private String Bk_Name;
    private ImageIcon Bk_cover;
    private String Bk_cover_URL;
    private String Bk_ISBN;
    private String Bk_Author;
    private String Bk_Publisher;

    private String Bk_PubDate;
    private int Bk_Price;
    private String Bk_Tag;

    private boolean Bk_Delete;
    private int Bk_ID;
    private ArrayList<Integer> Bk_Stlist = new ArrayList<Integer>();
    private Integer Bk_StoreID;

    public BookData() {
        Bk_Author = new String();
        Bk_PubDate = new String();
        Bk_Delete = false;
        Bk_ISBN = new String();
        Bk_Name = new String();
        Bk_ID = 0;
        Bk_cover = null;
        Bk_Price = 0;
        Bk_Publisher = new String();
    }

    public String getBk_cover_URL() {
        return Bk_cover_URL;
    }

    public void setBk_cover_URL(String bk_cover_URL) {
        Bk_cover_URL = bk_cover_URL;
    }

    public String getBk_Tag() {
        return Bk_Tag;
    }

    public void setBk_Tag(String bk_Tag) {
        this.Bk_Tag = bk_Tag;
    }

    public void setBk_Author(String bk_Author) {
        Bk_Author = bk_Author;
    }

    public void setBk_PubDate(String bk_PubDate) {
        Bk_PubDate = bk_PubDate;
    }

    public void setBk_Delete(boolean bk_Delete) {
        Bk_Delete = bk_Delete;
    }

    public void setBk_ISBN(String bk_ISBN) {
        Bk_ISBN = bk_ISBN;
    }

    public void setBk_Name(String bk_Name) {
        Bk_Name = bk_Name;
    }

    public void setBk_ID(int bk_ID) {
        Bk_ID = bk_ID;

    }

    public void setBk_cover(ImageIcon bk_cover) {
        Bk_cover = bk_cover;
    }

    public void setBk_Price(int bk_Price) {
        Bk_Price = bk_Price;
    }

    public void setBk_Publisher(String bk_Publisher) {
        Bk_Publisher = bk_Publisher;
    }

    public String getBk_Author() {
        return Bk_Author;
    }

    public String getBk_PubDate() {
        return Bk_PubDate;
    }

    public boolean isBk_Delete() {
        return Bk_Delete;
    }

    public String getBk_ISBN() {
        return Bk_ISBN;
    }

    public String getBk_Name() {
        return Bk_Name;
    }

    public int getBk_ID() {
        return Bk_ID;
    }

    public ImageIcon getBk_cover() {
        return Bk_cover;
    }

    public int getBk_Price() {
        return Bk_Price;
    }

    public String getBk_Publisher() {
        return Bk_Publisher;
    }

    public Integer getBk_StoreID() {
        return Bk_StoreID;
    }

    public void setBk_StoreID(Integer bk_StoreID) {
        Bk_StoreID = bk_StoreID;
        Bk_Stlist.add(Bk_StoreID);
    }

    public ArrayList<Integer> getBk_Stlist() {
        return Bk_Stlist;
    }

    public String writeBk_Stlist() {
        String str = new String();
        for(Integer a : Bk_Stlist){
            str += a;
            str += " ";
        }
        return str;
    }

    public void setBk_Stlist(ArrayList<Integer> bk_Stlist) {
        Bk_Stlist = bk_Stlist;
    }
}
