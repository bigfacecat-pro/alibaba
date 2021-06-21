package learning.io.bioChat;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            OutputStream outputStream=socket.getOutputStream();
            Thread clientTask=new Thread(new clientChatTask(socket));
            clientTask.start();
            PrintStream ps=new PrintStream(outputStream);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String msg="";
            while ((msg=br.readLine())!=null){
                if("q".equals(msg))
                    break;
                ps.println(msg);
                ps.flush();
            }
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
