package HUAWEI.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class newQ2 {

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int dllCount=Integer.parseInt( br.readLine());
        int depCount=Integer.parseInt( br.readLine());
        Map<String, List<String>> map=new HashMap<>();
        Map<String,Integer> count=new HashMap<>();
        while ((depCount--)>0){
            String[] input=br.readLine().split(" ");
            if(map.containsKey(input[1])) {
                List<String> list =new ArrayList<>(map.get(input[1])) ;
                list.add(input[0]);
                map.put(input[1], list);
            }
            else
                map.put(input[1],Arrays.asList(input[0]));
            map.put(input[0],map.getOrDefault(input[0],new ArrayList<String>()));
            count.put(input[1],count.getOrDefault(input[1],0));
            count.put(input[0],count.getOrDefault(input[0],0)+1);
        }
        Queue<String> queue=new LinkedList<>();
        for(Map.Entry<String, Integer> entry:count.entrySet()){
            if(entry.getValue()==0)
                queue.add(entry.getKey());
        }


        StringBuilder sb=new StringBuilder();
        int validCount=0;
        while(!queue.isEmpty()){
            String p=queue.poll();
            validCount++;
            sb.append(p).append(" ");
            for(String s:map.get(p)){
                count.put(s, count.get(s)-1);
                if(count.get(s)==0)
                    queue.offer(s);
            }
        }
        System.out.println(validCount!=dllCount);
        System.out.println(sb.toString());
    }
}
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
b f

4
3
a b
c b
a c
 */