package learning.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class clientLoop {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            OutputStream outputStream=socket.getOutputStream();
            PrintStream ps=new PrintStream(outputStream);
            Scanner sc=new Scanner(System.in);
            while (true){
                System.out.println("请说");
                String str=sc.nextLine();
                if(str.equals("q"))
                    break;
                ps.println(str);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
