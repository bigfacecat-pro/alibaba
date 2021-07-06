package sort;

import java.util.Random;

public class util {
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int[] generateArr(int length){
        Random random=new Random();
        int[] arr=new int[length];
        for(int i=0;i<length;++i)
            arr[i]= random.nextInt(length);
        return arr;
    }
}
