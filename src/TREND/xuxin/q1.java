package TREND.xuxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] num= br.readLine().toCharArray();
        String number=br.readLine();
        int x=Integer.parseInt(br.readLine());
        for(int i=0;i<x;++i){
            int index=0;
            while (index<num.length-1&& num[index]<num[index+1]){
                index++;

            }
        }
    }
}
