package Data.Project.G1.DataClass;

import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/5/17.
 */
public class StoreData {
    private String Store_Name;
    private Integer Store_ID;
    private Integer User_ID;
    private ArrayList<Integer> Books_ID = new ArrayList<Integer>();
    private Integer BKID;
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public StoreData(){
    }

    public Integer getStore_ID() {
        return Store_ID;
    }

    public void setStore_ID(Integer store_ID) {
        Store_ID = store_ID;
    }

    public Integer getBKID() {
        return BKID;
    }

    public void setBKID(Integer BKID) {
        this.BKID = BKID;
        Books_ID.add(BKID);
    }

    public ArrayList<Integer> getBooks_ID() {
        return Books_ID;
    }

    public void setBooks_ID(ArrayList<Integer> books_ID) {
        Books_ID = books_ID;
    }

    public String getStore_Name() {
        return Store_Name;
    }

    public void setStore_Name(String store_Name) {
        Store_Name = store_Name;
    }

    public Integer getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }
}
