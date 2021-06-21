package offer;

import java.util.Arrays;

public class offer61 {
    public static void main(String[] args) {
        boolean res= isStraight(new int[]{0,0,1,2,5});
        System.out.println(res);
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0=0;
        for(int i=0;i<nums.length-1;++i) {
            if (nums[i] == 0)
                count0++;
            else if(nums[i+1]-nums[i]==0)
                return false;
            else if(nums[i+1]-nums[i]>1){
                count0-=(nums[i+1]-nums[i]-1);
                if(count0<0)
                    return false;
            }
        }
        return true;
    }
}
