package HUAWEI.other;

import learning.string.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class zipWord {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        Map<Integer,String> map=new TreeMap<>();

        StringBuilder sb=new StringBuilder();
        int lastEnd=0, leftIndex=0,rightIndex=0;
        while(rightIndex<input.length()){
            char c=input.charAt(rightIndex);
            while(c>'9'||c<'0'){
                rightIndex++;
                c=input.charAt(rightIndex);
            }
            leftIndex=rightIndex;
            while(c<='9'&&c>='0'&&(rightIndex<input.length())) {
                rightIndex++;
                if(rightIndex!=input.length())
                    c=input.charAt(rightIndex);
            }
            int count=Integer.parseInt(input.substring(leftIndex,rightIndex));
            String str=input.substring(lastEnd,leftIndex);
            sb=new StringBuilder();
            for(int i=0;i<count;++i)
                sb.append(str);
            String oldStr=map.getOrDefault(count,"");
            if( oldStr.compareTo(sb.toString())<0)
                map.put(count  ,oldStr +sb.toString()  );
            else
                map.put(count  , sb.toString()+ oldStr );
            lastEnd=rightIndex;
        }
        sb=new StringBuilder();
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            sb.append(entry.getValue());
        }
        System.out.println(sb.toString());
    }
}
//a11b2bac3bad3abcd2