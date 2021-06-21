package learning.sort;

public class mian {
    private static int len=10000;
    private static int[] array=new int[len];

    public static void main(String[] args) {
        for(int i=0;i<array.length;++i)
            array[i]=(int)(Math.random()*len);


        new BubbleSort1().sort(array.clone());
        new BubbleSort2().sort(array.clone());
        new BubbleSort3().sort(array.clone());
        new ShellSort().sort(array.clone());
        new SelectionSort().sort(array.clone());
        new InsertionSort().sort(array.clone());
        new CountingSort().sort(array.clone());
        new RadixSort().sort(array.clone());
    }
}


