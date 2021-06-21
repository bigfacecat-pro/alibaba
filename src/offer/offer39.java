package offer;

import java.util.HashMap;
import java.util.Map;

public class offer39 {
    public static void main(String[] args) {
        int res=majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println( res);
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> record=new HashMap<>();
        for(int x:nums)
            record.put(x, record.getOrDefault(x,0)+1);
        for(int x: record.keySet())
            if(record.get(x)>=(nums.length+1)/2)
                return x;
        return 0;
    }
    public static int majorityElement2(int[] nums) {
        int[] record=new int[nums.length];
        for(int x:nums)
            record[x]++;
        return 0;
    }
}
