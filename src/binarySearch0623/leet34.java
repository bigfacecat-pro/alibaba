package binarySearch0623;

import java.util.Arrays;

public class leet34 {
    public static void main(String[] args) {
        int[] res=searchRange(new int[]{5,7,7,8,8,10},10);
        System.out.printf(Arrays.toString(res));
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new  int[]{-1,-1};
        int left=0,right= nums.length;
        int[] res=new int[2];
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)   right=mid;
            else if(nums[mid]>target)    right=mid;
            else if(nums[mid]<target)    left=mid+1;
        }
        if(left>= nums.length||nums[left]!=target)
            return new  int[]{-1,-1};
        res[0]=left;
        left=0;
        right= nums.length-1;
        while (left<right){
            int mid=left+(right+1-left)/2;
            if(nums[mid]==target)   left=mid;
            else if(nums[mid]>target)    right=mid-1;
            else if(nums[mid]<target)    left=mid;
        }
        res[1]=left;

        return  res;
    }
}
