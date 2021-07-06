package binarySearch0623;

public class offer154 {
    public static void main(String[] args) {
        int res=findMin(new int[]{2,2,2,2,2,2,2,2,2,6,2,2});
        System.out.println(res);
    }
    public static int findMin(int[] nums) {
        int left=0,right= nums.length-1;
        while(left<right&&nums[left]==nums[right])
            left++;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right])   right=mid;
            else if(nums[mid]==nums[right])   right=mid;
            else if(nums[mid]>nums[right])   left=mid+1;
        }
        return nums[left];
    }
}
