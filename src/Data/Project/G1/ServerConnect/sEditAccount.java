package Data.Project.G1.ServerConnect;

import Data.Project.G1.MainScreen.MainTest;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by JASON_ on 2015/5/27.
 */
public class sEditAccount {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;

    private static final int sEditAccount = 3;
    private HttpURLConnection connection = null;

    private sUploadHead suphead;

    public sEditAccount(String token, String name, String password, int ID, File uploadfile) throws IOException {
        System.out.println("------Edit Account------");

        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sEditAccount, ID));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "PUT");

            connection.setRequestProperty("Content-Type", "application/json");

            JSONObject user = new JSONObject();
            user.put("username", name);
            user.put("password", password);

            urlMod.SendToServer(connection, user, null);

            JSONObject obj = urlMod.PrintInput(connection);
            respondcode = connection.getResponseCode();

            if(respondcode/100 == 2) {
                if(uploadfile == null){
                    urlMod.SetAccountData(obj, MainTest.accountData);
                }
                else {
                    suphead = new sUploadHead(token, uploadfile);
                    System.out.println("sEditAccount uploadfile = " + uploadfile.toString());
                    if (suphead.getRespondcode() / 100 == 2) {
                        obj.put("head_image_url", suphead.getHead_image_url());
                        urlMod.SetAccountData(obj, MainTest.accountData);
                        System.out.println("sEditAccount JSONObj headURL = " + obj.getString("head_image_url"));
                    }
                }
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
