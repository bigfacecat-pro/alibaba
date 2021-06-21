package learning.io.bioChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatTask implements  Runnable{
    private Socket socket;
    public ServerChatTask(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String Msg;
            while ((Msg= br.readLine())!=null) {
                System.out.println(Msg);
                sendMsgToAll(Msg);
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println(socket.getPort()+"下线");
            servera.map.remove(socket.getPort());
        }
    }
    private boolean sendMsgToAll(String Msg){

        for(Socket client:servera.map.values()){
            try {
                PrintStream ps = new PrintStream(client.getOutputStream());
                ps.println(Msg);
                ps.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
