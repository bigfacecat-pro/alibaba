package offer;

import java.util.Map;

public class offer14 {
    public int cuttingRope(int n) {
        if(n<3)
            return n-1;
        int res=0;
        int mi=n/3;
        if(n%3==0)
            res= (int) Math.pow(3,mi);
        if(n%3==1)
            res=(int)Math.pow(3,mi-1)*4;
        if(n%3==2)
            res=(int)Math.pow(3,mi)*2;
        return res;
    }
}
