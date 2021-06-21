package HUAWEI.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int dllCount=Integer.parseInt( br.readLine());
        int depCount=Integer.parseInt( br.readLine());
        Map<String,String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        while ((depCount--)>0){
            String[] input=br.readLine().split(" ");
            map.put(input[0],input[1]);
            set.add(input[0]);
            set.add(input[1]);

        }
        String isDep="false";
        Set<String> depSet=new HashSet<>();
        for(Map.Entry<String,String> entry:map.entrySet()){
             String key=entry.getKey();
             String value=entry.getValue();
             if(map.get(value)==key){
                 set.add(key);
                 set.add(value);
                 isDep="true";
             }
             set.remove(key);
        }
        for(String s:set){
            HashSet<String> temp=new HashSet<>();
            for(Map.Entry<String,String> entry:map.entrySet()){
                if(entry.getValue().equals(s))
                    temp.add(s);
            }
            if(temp.size()>0){
                for(String l:temp){
                    if(temp.contains(map.get(l))){
                        map.remove(map.get(l));
                        map.remove(l);
                        isDep="true";
                    }
                }
            }
        }
        //System.out.println(isDep);
        for(String s:depSet)
            map.remove(s);
        StringBuilder sb=new StringBuilder();
        for(String s:set)
            sb.append(s).append(" ");
        while(set.size()!=0){
            Set<String> temp=new HashSet<>();
            for(String s:set){
                for(Map.Entry<String,String> entry:map.entrySet()){
                    if(entry.getValue().equals(s)) {
                        temp.add(entry.getKey());
                        sb.append(entry.getKey()).append(" ");
                        temp.add(entry.getKey());
                    }
                }
            }
            for(String s:temp)
                map.remove(s);
            set=new HashSet<>(temp);
        }
        if(map.size()!=0||isDep.equals("true"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println(sb.toString().trim());
    }
    public  static void findtroop(String node,Map<String,String> map){

    }
}

/**
 true
 libf.dll libb.dll liba.dll
 */
/*
6
5
liba.dll libb.dll
libc.dll libb.dll
libb.dll libf.dll
libe.dll libf.dll
libd.dll libe.dll

6
7
a b
c b
e f
d e
c d
e c

4
3
a b
c b
a c
 */