package sort;

import java.util.Arrays;

public class Injection {
    public static void main(String[] args) {
        int[] arr=util.generateArr(20);

        System.out.println(Arrays.toString(arr));
        for(int i=1;i<arr.length;++i){
            int j=i-1;
            while (j>=0 && arr[i]<arr[j]){

            }
                j--;
            util.swap(arr,i,++j);
        }
        System.out.println(Arrays.toString(arr));
    }
}
