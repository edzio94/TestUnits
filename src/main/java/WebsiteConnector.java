import org.jsoup.Connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lukasz on 08.11.15.
 */
public class WebsiteConnector {
    URL url;
    URLConnection myURLConnection;
    public WebsiteConnector()
    {
        try {
            url = new URL("http://www.wykop.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void getConnection(String URL)
    {
        try {
            this.url =new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            myURLConnection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            myURLConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
