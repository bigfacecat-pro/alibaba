package learning.io.bioChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class servera {

    public static Map<Integer,Socket> map=new HashMap<>();
    public static void main(String[] args) {
        try {
            ServerSocket sc=new ServerSocket(9999);
            while (true) {
                Socket socket = sc.accept();
                map.put(socket.getPort(), socket);
                System.out.println(socket.getPort()+" is online");
                Thread thread=new Thread(new ServerChatTask(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
