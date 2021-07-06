package sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr=util.generateArr(10);

        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length-1;++i){
            for(int j=i;j< arr.length;++j){
                if(arr[i]>arr[j]){
                    util.swap(arr,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
