package HUAWEI.zhengweifeng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] in= br.readLine().split(" ");
        int times=Integer.parseInt(in[0]);
        int capacity=Integer.parseInt(in[1]);
        int[] record=new int[24];
        while (times-- >0){
            String[] order=br.readLine().split(" ");
            int o1=Integer.parseInt(order[0]);
            int o2=Integer.parseInt(order[1]);
            int o3=Integer.parseInt(order[2]);
            boolean isValidOrder=true;
            for(int i=o1;i<o2;++i){
                if(record[i]+o3>capacity)
                    isValidOrder=false;
            }
            if(isValidOrder){
                for(int i=o1;i<o2;++i)
                    record[i]+=o3;
            }


        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<24;++i)
            sb.append(record[i]).append(" ");
        System.out.println(sb.toString());
    }

}
