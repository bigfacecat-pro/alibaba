package learning.sort;

public class CountingSort extends Sort {
    private  int max;
    private  int min;
    protected void sort(){
        max=min=arrayI[0];
        for(int x:arrayI) {
            max = max < x ? x : max;
            min = min > x ? x : min;
        }

        int[] temp=new int[max-min+1];
        for(int x:arrayI)
            temp[x-min]++;
        int index=0;
        for(int i=0;i<temp.length;++i)
            while (temp[i]-->0)
                arrayI[index++]=i+min;
    }
}
