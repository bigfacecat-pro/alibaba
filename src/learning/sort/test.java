package learning.sort;

public class test {
    private static int len=100;
    private static int[] array=new int[len];
    public static void main(String[] args) {
        for(int i=0;i<array.length;++i)
            array[i]=(int)(Math.random()*len);
        /*for(int i=1;i< array.length;++i){
            int index=i;
            int current=array[index];
            while (index>0&&current<array[index-1])
                array[index]=array[--index];
            array[index]=current;
        }
        int a=0;*/
        int max=array[0];
        int[] radix;
        int[] arrayCopy;
        for(int x:array)
            max=max>x?max:x;
        for(int mod=1;max/mod>0;mod*=10){
            radix=new int[10];
            arrayCopy=new int[array.length];
            for(int x:array)
                radix[x/mod%10]++;
            for(int i=1;i<10;++i)
                radix[i]+=radix[i-1];
            for(int i=arrayCopy.length-1;i>=0;--i)
                arrayCopy[--radix[array[i]/mod%10]]=array[i];
            for(int i=0;i<arrayCopy.length;++i)
                array[i]=arrayCopy[i];
        }
        int a=0;
    }
}
