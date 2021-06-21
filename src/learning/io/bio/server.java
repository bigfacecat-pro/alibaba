package learning.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            //定义一个serversocket进行端口注册
            ServerSocket serverSocket=new ServerSocket(9999);
            //调用accept方法，监听socket连接请求
            Socket socket= serverSocket.accept();
            //从socket管道中获得一个字节输入流对象
            InputStream inputStream=socket.getInputStream();
            //把字节输入流包装成缓存字符输入流
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String msg;
            while ((msg= bufferedReader.readLine())!=null){
                System.out.println("服务端接收到: "+msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
