package offer;

import java.util.Arrays;

public class offer17 {
    public static void main(String[] args) {
        int[] res= printNumbers(3);
        System.out.println(Arrays.toString(res));
    }
    public static int[] printNumbers(int n) {
        int len= (int) (Math.pow(10,n)-1);
        int[] res=new int[len];
        for(int i=0;i<len;++i)
            res[i]=i+1;
        return res;
    }
}
