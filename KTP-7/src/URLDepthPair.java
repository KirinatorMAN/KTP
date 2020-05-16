import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDepthPair {
    public String URL;
    public int dept;

    public URLDepthPair (String URL, int dept){
        this.URL=URL;
        this.dept=dept;
    }


    public String getHost() throws MalformedURLException {
        URL host = new URL(URL);
        return host.getHost();
    }

    public int getDepth() {
        return dept;
    }

    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
            if (c.toString().equals(pair.toString()))
                isAlready=false;
        return isAlready;
    }
}
