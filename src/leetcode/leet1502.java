package leetcode;

import java.util.Arrays;

public class leet1502 {
    public static void main(String[] args) {
        canMakeArithmeticProgression(new int[]{1,3,5,7,9,10});
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length==0)
            return false;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;++i)
            arr[i]=arr[i+1]-arr[i];
        for(int i=0;i<arr.length-2;++i)
            arr[i]=arr[i+1]-arr[i];
        for(int i=0;i<arr.length-2;++i)
            if(arr[i]!=0)
                return false;
        return true;
    }
}
