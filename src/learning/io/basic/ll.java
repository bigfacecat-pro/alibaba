package learning.io.basic;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ll {
    @Test
    public void file()  {
        String fileSeparator = System.getProperty("file.separator");
        System.out.println(fileSeparator);
        File file=new File("2.txt");
        try {
            if(file.createNewFile()){
                System.out.println(file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
