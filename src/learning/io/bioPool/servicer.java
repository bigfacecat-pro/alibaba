package learning.io.bioPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servicer {
    public static void main(String[] args) {
        try {
            HandlerSocketServerPool pool=new HandlerSocketServerPool(6,6);
            ServerSocket sc=new ServerSocket(9999);
            while (true){
                Socket socket=sc.accept();
                serverRunable target=new serverRunable(socket);
                pool.execute(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
