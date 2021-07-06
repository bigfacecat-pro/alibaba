package binarySearch0623;

public class leet540 {
    public static void main(String[] args) {
        int res=singleNonDuplicate(new int[]{1,1,3,3,4,4,5,5,6,6,7});
        System.out.println(res);
    }
    public static int singleNonDuplicate(int[] nums) {
        int left=0,right= nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(mid%2==0){
                if(nums[mid]!=nums[mid+1]) right=mid-1;
                else left=mid+2;
            }
            else {
                if (nums[mid] == nums[mid + 1]) right = mid - 1;
                else  left=mid+1;
            }
        }
        return nums[left];
    }
}
