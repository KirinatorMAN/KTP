import java.util.LinkedList;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDepthPair {
    public String URL;
    public int dept;
    public static final String URL_PREFIX = "<a href=\"http";

    public URLDepthPair (String URL, int dept){
        this.URL=URL;
        this.dept=dept;
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
        return dept;
    }

    public boolean test(String line,int maxDept){
       return (line.indexOf(URL_PREFIX)>0 && dept<maxDept);
    }

    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
            if (c.toString().equals(pair.toString()))
                isAlready=false;
        return isAlready;
    }
}
