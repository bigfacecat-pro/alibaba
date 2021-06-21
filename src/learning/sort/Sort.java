package learning.sort;

import java.util.Arrays;

public abstract class Sort {

    protected int[] arrayI;
    protected  int cmpCount=0;
    protected  int swapCount=0;
    protected  long spentTime=0;

    public void sort(int[] array){
        if(array==null||array.length<2) return;
        this.arrayI=array;
        long startTime=System.currentTimeMillis();
        sort();
        long endTime=System.currentTimeMillis();
        spentTime=endTime-startTime;
        printNums(arrayI);
    }
    protected abstract  void sort();


    protected int cmp(int o1,int o2){
        cmpCount++;
        return arrayI[o2]-arrayI[o1];
    }
    protected void swap(int o1,int o2){
        swapCount++;
        int temp=arrayI[o1];
        arrayI[o1]=arrayI[o2];
        arrayI[o2]=temp;
    }








    /**
     * 希尔排序
     * @param nums
     */
    public static void shellSort(int[] nums){
        for(int i=nums.length-1;i>0;--i){
            int maxIndex=0;
            for(int j=0;j<i;++j){
                if(nums[j]>nums[maxIndex]){
                    maxIndex=j;
                }
            }
            int temp=nums[maxIndex];
            nums[maxIndex]=nums[i];
            nums[i]=temp;
        }
    }

    public  void printNums(int[] nums){
        String out = Arrays.toString(nums);
        System.out.println(this.getClass().getName());
        System.out.println("用时:"+spentTime+"mm");
        System.out.println("比较次数："+cmpCount);
        System.out.println("交换次数："+swapCount);
        //System.out.println(out);
        System.out.println("=========================================================================================================");
        System.out.println();
    }

}
