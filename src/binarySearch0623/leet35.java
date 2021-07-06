package binarySearch0623;

public class leet35 {
    public static void main(String[] args) {
        int res=searchInsert(new int[]{1,3,5,6},0);
        System.out.println(res);
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        int left=0,right= nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]) left=mid+1;
            else if(target<nums[mid]) right=mid;
        }

        return  left;
    }
}
