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



    public void Process(URLDepthPair pair) throws IOException {
        findLink.add(pair);
        while (!findLink.isEmpty()){
            URLDepthPair currentPair = findLink.removeFirst();
            int dept = currentPair.getDepth();

            Socket my_socket =new Socket(currentPair.getHost(), 80)



        }



    }




}
