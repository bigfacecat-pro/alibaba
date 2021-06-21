package learning.io.bioFile;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try(
            InputStream is=new FileInputStream("C:\\Users\\000\\Pictures\\图片1400400.png");
            ) {
            Socket socket=new Socket("127.0.0.1",9999);
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(".png");
            byte[] data=new byte[1024];
            int len=0;
            while ((len=is.read(data))>0){
                dos.write(data);
            }
            dos.flush();
            socket.shutdownOutput();
            System.out.println("文件上传完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
