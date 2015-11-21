/**
 * Created by lukasz on 11.11.15.
 */
public class DomainParser {

    public String getDomain(String webPage)
    {

        String[] temp = webPage.split("\\.");
        return temp[1];
    }

}
