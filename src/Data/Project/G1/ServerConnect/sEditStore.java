package Data.Project.G1.ServerConnect;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by JASON_ on 2015/5/30.
 */
public class sEditStore {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;

    private static final int sEditStore = 7;
    private HttpURLConnection connection = null;

    public sEditStore(String token, String name, int ID) throws IOException {
        System.out.println("------Edit Store------");

        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sEditStore, ID));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "PUT");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("token", token);

            JSONObject user = new JSONObject();
            user.put("category_name", name);

            urlMod.SendToServer(connection, user, null);
            respondcode = connection.getResponseCode();

            if(respondcode/100 == 2) {
                JSONObject obj = urlMod.PrintInput(connection);
                JSONArray objlist = new JSONArray();
                objlist.put(obj);
                urlMod.SetStoreData(objlist, ID);
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
