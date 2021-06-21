package offer;

import java.util.ArrayList;
import java.util.List;

public class offer66 {
    public static void main(String[] args) {
        int s=Integer.MAX_VALUE;
        constructArr(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13});
        int i=1*2*3*4*5*6*7*8*9*10*11*12*13;
        int b=0;
    }
    public static int[] constructArr(int[] a) {
        if(a.length==0)
            return a;
        int[] res=new int[a.length];
        res[0]=1;
        for (int i=1;i<a.length;++i){
            res[i]= res[i-1]*a[i-1];
        }
        int tmp=1;
        for (int i=a.length-2;i>=0;--i){
            tmp*=a[i+1];
            res[i]*=tmp;
        }
        return res;
    }
}
