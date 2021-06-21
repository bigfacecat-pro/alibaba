package offer;

import java.util.*;

public class offer40 {
    public static void main(String[] args) {
        int[] res=getLeastNumbers(new int[]{9,1,8,2,6,3,5,2},3);
        int[] re2s=getLeastNumbers2(new int[]{3,9,8,2,6,3,5,2},3);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k==0)
            return new int[0];
        int[] res=new int[k];
        Arrays.fill(res,Integer.MAX_VALUE);
        for(int x:arr){
            if(res[k-1]>x) {
                int index = k - 2;
                while (index >= 0 && res[index] > x) {
                    res[index+1] = res[index];
                    index--;
                }
                res[++index] = x;
            }
        }
        return res;
    }
    public static int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1,num2)-> {
                return num2 - num1;
            }
        );
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
