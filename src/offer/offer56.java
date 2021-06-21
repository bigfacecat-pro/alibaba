package offer;

import java.util.HashMap;
import java.util.Map;

public class offer56 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        for(int x:map.keySet()){
            if(map.get(x)==1)
                return x;
        }
        return 0;
    }
}
