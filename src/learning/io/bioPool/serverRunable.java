package learning.io.bioPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class serverRunable implements Runnable {
    private Socket socket;

    @Override
    public void run() {
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

    public serverRunable(Socket socket){
        this.socket=socket;
    }

}
