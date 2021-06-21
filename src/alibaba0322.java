import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
3 210
100 100 110
YES
3 210
100 100 120
NO
4 500
125 100 100 100
NO
4 500
125 125 250 10
YES
6 30
4 4 4 4 4 4
NO
6 30
5 5 5 5 5 5
YES
 */
public class alibaba0322 {
    private static  boolean res=false;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=br.readLine())!=null){
            String[] base=input.split(" ");
            int peopleCount=Integer.parseInt(base[0]);
            int weightLimit=Integer.parseInt(base[1]);
            input=br.readLine();
            base=input.split(" ");
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<peopleCount;++i)
                map.put(Integer.parseInt(base[i]), map.getOrDefault(Integer.parseInt(base[i]),0)+1);

            res=false;
            check(weightLimit,map);
            if(res)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public  static  void check(int weightLimit, HashMap<Integer,Integer> map){
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int currLimit=weightLimit;
            HashMap<Integer,Integer> currMap=new HashMap<>();
            for(Map.Entry<Integer,Integer> entry1:map.entrySet())
                currMap.put(entry1.getKey(), entry1.getValue());

            if(!res) {
                currLimit=weightLimit - entry.getKey();
                if(currLimit<=0){
                    res=currLimit==0?true:false;
                    return;
                }else{
                    if (entry.getValue()> 1)
                        currMap.put(entry.getKey(), entry.getValue() - 1);
                    else
                        currMap.remove(entry.getKey());
                    check(currLimit,currMap);
                }
            }else
                return;
        }

    }
}
