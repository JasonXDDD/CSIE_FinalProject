package Data.Project.G1.ServerConnect;

import org.json.JSONObject;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;

/**
 * Created by JASON_ on 2015/5/25.
 */
public class sGetToken {
    public String ADD_URL = "http://163.13.128.116:5000/api/token";
    public JSONObject obj;
    public Global gbl;

    public sGetToken() throws IOException{
        HttpURLConnection connection = null;

        try {
            URL url = new URL(ADD_URL);
            connection = (HttpURLConnection)url.openConnection();


            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");

            while ((lines = reader.readLine()) != null){
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            obj = new JSONObject(sb.toString());
            System.out.println(sb);
            reader.close();


            gbl.setToken(obj.getString("token"));
            System.out.println("GetToken: " + gbl.getToken());


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


    public static void main(String[] args) throws IOException{
        sGetToken gt = new sGetToken();
    }
}
