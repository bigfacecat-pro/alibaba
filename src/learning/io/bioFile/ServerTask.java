package learning.io.bioFile;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerTask implements Runnable{
    private Socket socket;
    public ServerTask(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            String suffix= dis.readUTF();
            OutputStream os=new FileOutputStream("C:\\Users\\000\\Pictures\\"+UUID.randomUUID().toString()+suffix);
            byte[] data=new byte[1024];
            int len=0;
            while ((len=dis.read(data))>0){
                os.write(data);
            }
            System.out.println("文件接受完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
