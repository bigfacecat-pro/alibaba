package learning.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class socketThread extends Thread {
    private Socket socket;
    public socketThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public  void  run(){
        try {
            InputStream inputStream=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream) );
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
