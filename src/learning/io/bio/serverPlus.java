package learning.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverPlus {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(9999);
            while (true){
                Socket socket= serverSocket.accept();
                socketThread st=new socketThread(socket);

                st.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
