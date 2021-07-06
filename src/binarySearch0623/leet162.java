package binarySearch0623;

public class leet162 {
    public static void main(String[] args) {
        int res=findPeakElement(new int[]{5,4,3,2,1});
        System.out.println(res);
    }
    public static int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1,mid=0;
        while (left<right){
            mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1])   right=mid;
            else left=mid+1;
        }
        return left;
    }
}
