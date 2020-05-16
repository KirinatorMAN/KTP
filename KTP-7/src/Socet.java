import java.net. *;
import java.io. *;

public class Socet {
    private int port;
    private String host;
    Socket my_socket;




    public Socet(String host,int port){
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

    }

    public void close(){

    }

}
