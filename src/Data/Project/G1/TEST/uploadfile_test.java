package Data.Project.G1.TEST; /**
 * Created by Ikaros on 2015/5/28.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class uploadfile_test {
    public static void main(String[] args) throws Exception
    {
//        if (args.length != 1)  {
//            System.out.println("File path not given");
//            System.exit(1);
//        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://163.13.128.116:5000/api/upload");
            httppost.addHeader("token", "amwx069xk1i3jrayg5waoxkz7lvc4tvk");
            FileBody cover_image = new FileBody(new File("/Users/Ikaros/Downloads/2015-04-18_003503.png"));
//            StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("cover_image", cover_image)
//                    .addPart("comment", comment)
                    .build();


            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (response.getEntity().getContent())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
