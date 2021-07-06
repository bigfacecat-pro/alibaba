package sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr={5,3,6,9,2,1,5,6,7,15};
        int minIndex=0;
        for(int i=0;i<arr.length-1;++i){
            minIndex=i;
            for(int j=i+1;j<arr.length;++j){
                minIndex=arr[minIndex]<arr[j]?minIndex:j;
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
