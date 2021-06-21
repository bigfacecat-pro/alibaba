package learning.io.bioFile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class server {
    private static ThreadPoolExecutor pool;
    public static void main(String[] args) {
        pool=new ThreadPoolExecutor(3,10,120, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        try {
            ServerSocket sc=new ServerSocket(9999);
            while (true){
                Socket socket=sc.accept();
                //Thread task=new Thread(new  ServerTask(socket));
                //task.start();
                pool.execute(new ServerTask(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
