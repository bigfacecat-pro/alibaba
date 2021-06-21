package offer;

import java.util.*;

public class offer51 {
    public static void main(String[] args) {
        int res=reversePairs(new int[]{7,5,6,4,1,3,5,0});
        int res2=reversePairs3(new int[]{7,5,6,4,1,3,5,0});
        System.out.println(res);
        System.out.println(res2);
    }
    public static int reversePairs(int[] nums) {
        Map<Integer,Integer> distinct=new TreeMap();
        for(int x:nums)
            distinct.put(x,distinct.getOrDefault(x,0)+1);
        int[][] record=new int[2][distinct.size()];
        int i=0;
        for(int x: distinct.keySet()){
            record[0][i]=x;
            record[1][i]=distinct.get(x);
            i++;
        }
        for(i=1;i<record[0].length;++i)
            record[1][i]+=record[1][i-1];
        int res=0;
        int left=0,right=record[0].length-1;
        for(int x:nums){
            i=bfs(record,x);
            if(i==left&&record[1][i]==0)
                left++;
            else if(i==right&&record[1][right]==0)
                right--;
            if(i!=0)
                res+=record[1][i-1];
            for(;i<right;++i)
                record[1][i]--;


        }
        return  res;
    }
    private static int bfs(int[][] record,int target){
        int right=record[0].length-1,left=0;
        int mid=(left+right)/2;
        while (true){
            if(record[0][mid]==target)
                return mid;
            else if(record[0][mid]<target){
                left=mid+1;
                mid=(left+right)/2;
            }else if(record[0][mid]>target){
                right=mid-1;
                mid=(left+right)/2;
            }
        }
    }
    private static int reversePairs2(int nums[]){
        if(nums.length<2)
            return 0;
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;++i)
            temp[i]=nums[i];
        return reverse(nums,0,nums.length-1,temp);
    }
    private static int reverse(int[] nums,int left,int right,int[] temp){
        if(left==right)
            return 0;
        int mid=(left+right)/2;
        int leftCount= reverse(nums,left,mid,temp);
        int rightCount=reverse(nums,mid+1,right,temp);
        int crossCount=merge(nums,left,right,mid,temp);
        return  leftCount+rightCount+crossCount;
    }
    public static int merge(int[] nums,int left,int right,int mid,int[] temp){
        for (int i=left;i<=right;++i)
            temp[i]=nums[i];
        int leftPtr=left,rightPtr=mid+1;
        int res=0;
        for(int i=left;i<=right;++i){
            if(leftPtr==mid+1){
                nums[i]=temp[rightPtr];
                rightPtr++;
            }else if(rightPtr==right+1){
                leftPtr++;
            }else if(temp[leftPtr]<=temp[rightPtr]){
                nums[i]=temp[leftPtr];
                leftPtr++;
            }else{
                nums[i]=temp[rightPtr];
                res+=(mid-leftPtr+1);
                rightPtr++;
            }
        }
        return res;
    }

    public static int reversePairs3(int nums[]){
        if(nums.length<2)
            return 0;
        int[] copy=new int[nums.length];
        for(int i=0;i<nums.length;++i)
            copy[i]=nums[i];
        int[] temp = new int[nums.length];
        int res= reverse3(copy,0,nums.length-1,temp);
        return res;
    }
    public static int reverse3(int[] nums,int left,int right,int[] temp){
        if(left==right)
            return 0;
        int mid=left+(right-left)/2;
        int leftCount=reverse3(nums,left,mid,temp);
        int rightCount=reverse3(nums,mid+1,right,temp);

        int merge=merge3(nums,left,mid,right,temp);
        return leftCount+rightCount+merge;
    }
    public static int merge3(int[] nums,int left,int mid,int right,int[] temp){
        for(int i=left;i<=right;++i)
            temp[i]=nums[i];
        int leftIndex=left,rightIndex=mid+1;
        int res=0;
        for(int i=left;i<=right;++i){
            if(leftIndex==mid+1){
                nums[i]=temp[rightIndex];
                rightIndex++;
            }else if(rightIndex==right+1){
                nums[i]=temp[leftIndex];
                leftIndex++;
            }else if(temp[leftIndex]<=temp[rightIndex]){
                nums[i]=temp[leftIndex];
                leftIndex++;
            }else{
                res+=(mid-leftIndex+1);
                nums[i]=temp[rightIndex];
                rightIndex++;
            }
        }
        return res;
    }
}
