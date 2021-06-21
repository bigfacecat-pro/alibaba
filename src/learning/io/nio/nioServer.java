package learning.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class nioServer {
    public static void main(String[] args)throws Exception {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9999));
        Selector selector=Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select()>0){
            Iterator<SelectionKey> sks= selector.selectedKeys().iterator();
            while (sks.hasNext()){
                SelectionKey sk=sks.next();
                if(sk.isAcceptable()){
                    SocketChannel socketChannel=serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("connect");
                }else if(sk.isReadable()){
                    SocketChannel socketChannel=(SocketChannel) sk.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len;
                    while ((len=socketChannel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //这句话有点重要
                sks.remove();
            }
        }
    }
}
