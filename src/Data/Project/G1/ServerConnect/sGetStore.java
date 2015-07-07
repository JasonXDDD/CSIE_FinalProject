package Data.Project.G1.ServerConnect;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by JASON_ on 2015/5/31.
 */
public class sGetStore {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;

    private static final int sGetStore = 6;
    private HttpURLConnection connection = null;

    public sGetStore(String token) throws IOException {
        System.out.println("------Get Store------");

        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sGetStore, 0));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "GET");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("token", token);

            respondcode = connection.getResponseCode();

            if(respondcode/100 == 2) {
                JSONArray objlist = urlMod.PrintInputArray(connection);
                urlMod.SetStoreData(objlist, 0);
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
