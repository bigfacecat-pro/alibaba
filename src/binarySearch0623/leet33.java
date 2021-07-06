package binarySearch0623;

public class leet33 {
    public static void main(String[] args) {
        int res=search(new int[]{1},1);
        System.out.println(res);
    }
    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;

        while (left<right){
            mid=left+(right-left)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else if(nums[mid]<nums[right])
                right=mid;
        }
        int min=left;
        left=target>nums[nums.length-1]?0:left;
        right=target>nums[nums.length-1]?min: nums.length-1;
        while (left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else if(nums[mid]<target)
                left=mid+1;
        }
        return -1;
    }
}
