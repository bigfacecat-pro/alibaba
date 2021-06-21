package learning.io.bioChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class clientChatTask implements Runnable{
    private Socket socket;
    public clientChatTask(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg="";
            while ((msg=br.readLine())!=null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
