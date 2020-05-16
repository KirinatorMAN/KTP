import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Crawler {

    LinkedList <URLDepthPair> findLink = new LinkedList <URLDepthPair>();
    LinkedList <URLDepthPair> viewedLink = new LinkedList <URLDepthPair>();

//    public void getSites() {
//        for (var elem : m_Processed)
//            System.out.println(elem.getURL());
//        System.out.println("Links visited: " + m_Processed.size());
//    }

    public static void getSites(LinkedList<URLDepthPair> viewedLink){
        for (URLDepthPair c : viewedLink)
            System.out.println("Depth : "+c.getDepth() + "\tLink : "+c.toString());
    }

    public void getInputStream(Socket my_socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
    }

    public void getOutputStream(Socket my_socket) throws IOException {
        PrintWriter out = new PrintWriter (my_socket.getOutputStream(),true);
    }

    public static void request(PrintWriter out,URLDepthPair pair) throws MalformedURLException {
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
    }

    public void Process(URLDepthPair pair,int maxDept) throws IOException {
        findLink.add(pair);
        while (!findLink.isEmpty()){
            URLDepthPair currentPair = findLink.removeFirst();
            Socket my_socket =new Socket(currentPair.getHost(), 80);
            my_socket.setSoTimeout(1000);
            BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
            PrintWriter out = new PrintWriter (my_socket.getOutputStream(),true);
            request(out, currentPair);
            String line=in.readLine();
            while(line!=null){
                if(currentPair.test(line,maxDept)){
                    boolean isLinkFound = false;
                    StringBuilder currentLink = new StringBuilder();
                    char c = line.charAt(line.indexOf(currentPair.URL_PREFIX)+9);
                    currentLink.append(c);
                    for (int i = line.indexOf(currentPair.URL_PREFIX) + 10; c != '"'; i++) {
                        c = line.charAt(i);
                        if (c == '"')
                            isLinkFound = true;
                        else
                            currentLink.append(c);
                    }
                    if (isLinkFound) {
                        URLDepthPair newPair = new URLDepthPair(currentLink.toString(), depth + 1);
                        if (check(findLink, newPair)) {
                            findLink.add(newPair);
                        }
                    }


                }

            }

        }



    }




}
