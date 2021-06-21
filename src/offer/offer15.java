package offer;

import jdk.jfr.Unsigned;

public class offer15 {
    public static void main(String[] args) {
        int res=hammingWeight(00000000000000000000000000001011);
    }
    public static int hammingWeight(int n) {
        int res=0;
        for(int i=0;i<32;++i){
            if((1<<i&n)!=0)
                res++;
        }
        return res;
    }
}
