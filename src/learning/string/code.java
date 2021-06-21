package learning.string;

import java.io.UnsupportedEncodingException;

public class code {
    public static void main(String[] args) {
        String s1 = "你好";
        String s2="";
        try {
            s2 = new String(s1.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
