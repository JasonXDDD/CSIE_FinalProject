package Data.Project.G1.ServerConnect;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by JASON_ on 2015/6/1.
 */
public class sAddBook {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;
    private sUploadFile upfile;

    private static final int sAddBook = 8;
    private HttpURLConnection connection = null;

    public sAddBook(String token, String name, String ISBN,
                    String Author, String Publisher, String Publish_Date,
                    String Price, String Tag, Integer[] store_id,
                    File upload) throws IOException {
        System.out.println("------Add Book------");


        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sAddBook, 0));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("token", token);

            JSONObject user = new JSONObject();
            user.put("bookname", name);
            user.put("publisher", Publisher);
            user.put("ISBN", ISBN);
            user.put("price", Price);
            user.put("author", Author);
            user.put("publish_date", Publish_Date);
            user.put("tag", Tag);
            JSONArray stid = new JSONArray();
            for(Integer a : store_id){
                stid.put(a);
            }
            user.put("category_id", stid);

            System.out.println("sAddBook user: " + user);

            urlMod.SendToServer(connection, user, null);
            respondcode = connection.getResponseCode();

            if(respondcode/100 == 2) {
                JSONObject obj = urlMod.PrintInput(connection);
                upfile = new sUploadFile(token, upload, obj.getInt("book_id"));
                obj.put("cover_image_url", upfile.getCover_image_url());
                JSONArray objlist = new JSONArray();
                objlist.put(obj);
                urlMod.SetBookData(objlist, 0);
                urlMod.SetBookIDtoStore(objlist);
            }

            System.out.println();
            connection.disconnect();
        }
        catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getRespondcode() {
        return respondcode;
    }
}
