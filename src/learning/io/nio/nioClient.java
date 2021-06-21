package learning.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class nioClient {
    public static void main(String[] args)throws Exception {
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
        socketChannel.configureBlocking(false);
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        Scanner sc=new Scanner(System.in);
        while (true){
            buffer.clear();
            System.out.println("say");
            buffer.put(("asas:"+sc.nextLine()).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
        }
    }
}
