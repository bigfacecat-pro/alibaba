package leetcode;

import java.util.ArrayList;
import java.util.List;

public class glodon {
    public static void main(String[] args) {
        String s1="a"+"b"+"c";
        String s2="abc";
        char[] c={'a','b','c'};
        String s3=new String("abc");
        String s4=c.toString();
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        System.out.println("==========================");
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = "a" + "b";
        String str5 = str1 + str2;
        String str6 = new String("ab");

        System.out.println(str3.equals(str6));
        System.out.println(str3 == str6);
        System.out.println(str3 == str4);
        System.out.println(str4 == str5);
        System.out.println((str1+str2) == str5);

        System.out.println("===============");
        final String ss1="a";
        final String ss2="b";

        List<Integer> list=new ArrayList<>();
        String ss3="ab";
        String ss4=ss1+ss2;
        System.out.println(ss3==ss4);

    }
}
