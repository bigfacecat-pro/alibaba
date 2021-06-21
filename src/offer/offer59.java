package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class offer59 {
    public static void main(String[] args) {
        //maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7,9,7,5,0,4},3);
        maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7,9,7,5,0,4},3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] tempArr=new int[k];
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<k;++i)
            tempArr[i]=nums[i];
        Arrays.sort(tempArr);
        res[0]=tempArr[tempArr.length-1];
        for(int i=1;i<nums.length-k+1;++i){
            int needRemove=nums[i-1];
            int needInsert=nums[i-1+k];
            boolean haveInsert=false;

            if(needRemove<needInsert){
                int j=0;
                while(tempArr[j]!=needRemove)
                    j++;
                for(;j<k-1;++j){
                    if(tempArr[j+1]>needInsert){
                        tempArr[j]=needInsert;
                        haveInsert=true;
                        break;
                    }
                    else{
                        tempArr[j]=tempArr[j+1];
                    }

                }
                if(!haveInsert)
                    tempArr[tempArr.length-1]=needInsert;
            }else{
                int j=tempArr.length-1;
                while(tempArr[j]!=needRemove)
                    j--;
                for(;j>0;--j){
                    if(tempArr[j-1]<needInsert){
                        tempArr[j]=needInsert;
                        haveInsert=true;
                        break;
                    }
                    else{
                        tempArr[j]=tempArr[j-1];
                    }
                }
                if(!haveInsert)
                    tempArr[0]=needInsert;
            }
            res[i]=tempArr[tempArr.length-1];
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if(nums.length==0)
            return new int[0];
        int[] res=new int[nums.length-k+1];
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(nums[0]);
        for(int i=0;i<k;++i){
            if(deque.size()!=0&&deque.peekFirst()<nums[i])
                deque.addFirst(nums[i]);
            while(deque.peekLast()<nums[i])
                deque.removeLast();
        }

        res[0]=deque.peekFirst();
        for(int i=1;i<nums.length-k+1;++i){
            if(deque.peekFirst()==nums[i-1])
                deque.removeFirst();
            while(!deque.isEmpty()&&deque.peekLast()<nums[i+k-1])
                deque.removeLast();
            deque.addLast(nums[i+k-1]);
            res[i]=deque.peekFirst();
        }
        return res;
    }
}
