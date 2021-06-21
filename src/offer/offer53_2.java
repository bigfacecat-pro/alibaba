package offer;

public class offer53_2 {
    public static void main(String[] args) {
        int res=missingNumber(new int[]{0,1,3,4,5,6,7,8});
        System.out.println(res);
    }
    public static int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==mid)
                left = mid + 1;
            else if(nums[mid]>mid) {
                if (mid==0||nums[mid - 1] == mid-1)
                    return mid;
                else
                    right = mid - 1;
            }
        }
        return left;
    }
}
