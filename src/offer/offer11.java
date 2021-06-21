package offer;

import java.util.Arrays;

public class offer11 {
    public static void main(String[] args) {
        int res=minArray2(new int[]{2,2,2,0,1});
        System.out.println(res);
    }
    public static int minArray(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++) {
            if( numbers[i]>numbers[i+1])
                return numbers[i+1];
        }
        return numbers[0];
    }
    public static int minArray2(int[] numbers) {
        int left=0,right=numbers.length-1;
        int mid=0;
        while(left<right) {
            mid=left+(right-left)/2;
            if(numbers[mid]<numbers[right]) right=mid;
            else if(numbers[mid]>numbers[right]) left=mid;
            else right--;
        }
        return numbers[left];
    }
}
