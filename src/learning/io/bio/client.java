package learning.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            OutputStream outputStream=socket.getOutputStream();
            PrintStream ps=new PrintStream(outputStream);
            ps.println("hello world");
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
