
package offer;
import leetcode.zi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class offer42{
    public static void main(String[] args){
        zi z=new zi();
        int a=0;
        Integer i=10;

        Integer j=5+(i++);
        j+=i;
        System.out.println(j++);
    }
}