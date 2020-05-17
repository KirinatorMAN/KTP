import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDepthPair {
    public static final String URL_PREFIX = "<a href=\"http";

    public String URL;
    public int depth;

    public URLDepthPair (String URL, int depth){
        this.URL=URL;
        this.depth=depth;
    }


    public String getHost() throws MalformedURLException {
        URL host = new URL(URL);
        return host.getHost();
    }
    public String getPath() throws MalformedURLException {
        URL path = new URL(URL);
        return path.getPath();
    }
    public int getDepth() {
        return depth;
    }

    public boolean test(String line,int maxDepth){
       return (line.indexOf(URL_PREFIX)>0 && depth<maxDepth);
    }

    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
            if (c.toString().equals(pair.toString()))
                isAlready=false;
        return isAlready;
    }
}
