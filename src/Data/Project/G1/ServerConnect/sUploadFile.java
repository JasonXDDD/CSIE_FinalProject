package Data.Project.G1.ServerConnect;

import Data.Project.G1.MainScreen.MainTest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by JASON_ on 2015/6/1.
 */
public class sUploadFile {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;
    private String cover_image_url;

    private static final int sUploadFile = 4;;

    public sUploadFile(String token, File uploadfile, int ID) throws IOException {
        System.out.println("--upload Book Head---");
        if (uploadfile == null)
            return;

        try {
            CloseableHttpClient client = HttpClients.createDefault();

            ADD_URL = new URL(urlMod.ChooseRequest(sUploadFile, ID));
            HttpPost post = new HttpPost(ADD_URL.toString());
            post.addHeader("token", token);

            FileBody upload = new FileBody(uploadfile);

            HttpEntity request = MultipartEntityBuilder.create()
                    .addPart("cover_image", upload).build();

            post.setEntity(request);


            CloseableHttpResponse response = client.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity responceEntity = response.getEntity();
                String responseStr = EntityUtils.toString(responceEntity);

                if (responceEntity != null){
                    System.out.println("Cover upload: " + responseStr);

                    JSONObject obj = new JSONObject(responseStr);
                    System.out.println("sUploadFile: Cover-upload ResponseJSONObj CoverURL = " + obj.getString("cover_image_url"));
                    cover_image_url = obj.getString("cover_image_url");

                    urlMod.SetFileData(obj, MainTest.bookData, uploadfile);
                    respondcode = response.getStatusLine().getStatusCode();
                }
                else
                    System.out.println("No Response");

            }
            finally {
                response.close();
            }
            client.close();
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

    public String getCover_image_url() {
        return cover_image_url;
    }
}
