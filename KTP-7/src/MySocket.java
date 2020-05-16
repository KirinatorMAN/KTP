import java.net. *;
import java.io. *;
import java.util. *;

public class MySocket {
    private int port;
    private String host;
    Socket my_socket;
    LinkedList <URLDepthPair> myList = new LinkedList <URLDepthPair>();
    LinkedList <URLDepthPair> resultLink = new LinkedList <URLDepthPair>();
    public static void showResult(LinkedList<URLDepthPair> resultLink){

    }



    public MySocket(String host,int port){
        try {
            my_socket =new Socket(host, port);
        } catch (IOException e) {
        }
        this.port=port;
        this.host=host;
    }

    public void setSoTimeout(int timeout){

    }

    public InputStream getInputStream(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public OutputStream getOutputStream(){
        try {
            PrintWriter out = new PrintWriter (my_socket.getOutputStream(),true);
        } catch (IOException e) {
        }

    }

    public void close(){

    }

}
