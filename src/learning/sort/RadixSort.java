package learning.sort;

public class RadixSort extends Sort {
    private int max;

    @Override
    protected void sort(){
        for(int x:arrayI)
            max= Math.max(max,x);

        int[] radix;
        int[] arrayCopy=new int[arrayI.length];
        for(int mod=1;max/mod>0;mod*=10){
            radix=new int[10];
            for (int x : arrayI)
                radix[x/mod%10]++;
            for (int i=1;i<10;++i)
                radix[i]+=radix[i-1];

            for (int i=arrayI.length-1;i>=0;--i)
                arrayCopy[--radix[arrayI[i]/mod%10]]=arrayI[i];
            for(int i=0;i<arrayCopy.length;++i)
                arrayI[i]=arrayCopy[i];
        }

    }
}
