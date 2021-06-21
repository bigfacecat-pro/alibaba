package leetcode;

public class leet413 {
    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{1,2,3,4});
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int res=0;
        for(int i=nums.length-1;i>0;--i)
            nums[i]=nums[i]-nums[i-1];
        for(int i=nums.length-1;i>1;--i)
            nums[i]=nums[i]-nums[i-1];
        int count=0;
        for(int i=nums.length-1;i>1;--i){
            if(nums[i]==0)
                count++;
            else{
                res+=calculateZero(count);
                count=0;
            }
        }
        res+=calculateZero(count);
        return res;
    }
    public static int calculateZero(int n){
        return n*(n+1)/2;
    }
}
