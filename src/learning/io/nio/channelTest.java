package learning.io.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class channelTest {
    @Test
    public void testwrite(){
        try {
            FileOutputStream fos=new FileOutputStream("nio.txt");
            FileChannel fc=fos.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            buffer.put("dsdsd".getBytes());
            buffer.flip();
            fc.write(buffer);
            fc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRead(){
        try {
            FileInputStream fos=new FileInputStream("nio.txt");
            FileChannel fc=fos.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);

            fc.read(buffer);
            buffer.flip();
            String rs=new String(buffer.array(),0,buffer.remaining());
            System.out.println(rs);
            fc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void copy(){
        try {
            FileInputStream fis=new FileInputStream("C:\\Users\\000\\Pictures\\图片1400400.png");
            FileOutputStream fos=new FileOutputStream("C:\\Users\\000\\Pictures\\1111111111.png");

            FileChannel inChannel=fis.getChannel();
            FileChannel outChannel=fos.getChannel();

            ByteBuffer bf=ByteBuffer.allocate(1024);
            while (true){
                bf.clear();
                int flag=inChannel.read(bf);
                if(flag==-1)
                    break;
                bf.flip();
                outChannel.write(bf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
