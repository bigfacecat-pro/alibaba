package offer;

public class offer57 {
    public static void main(String[] args) {
        int res=search2(new int[]{5,7,8,8,8,9},8);
        System.out.println( res);
    }
    public static int search(int[] nums, int target) {
        int index=bfs(nums, target);
        if(index==-1)
            return 0;
        int left=index;
        while (left-1>=0&&nums[left-1]==target)
            left--;
        while ((index+1<nums.length)&&(nums[index+1]==target))
            index++;
        return index-left+1;
    }
    public static int bfs(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else
                return mid;
        }
        return -1;
    }
    public static int search2(int[] nums, int target) {
        int l=0,r=0;
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        r=left-1;
        left=0;
        right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        l=right;
        return r-l;
    }

}
