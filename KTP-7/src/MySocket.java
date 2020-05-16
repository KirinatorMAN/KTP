import java.net. *;
import java.io. *;
import java.util. *;

public class MySocket {
    private int port;
    private String host;

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


    public void close(){

    }

}
