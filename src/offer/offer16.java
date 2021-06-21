package offer;

/**
 * int最小值是-2147483648，-2147483648*-1=-2147483648！！！
 * 要想得到2147483648，要先把-2147483648转成long,再乘以-1
 */
public class offer16 {
    public static void main(String[] args) {
        test();
        myPow(2,-2147483648);
    }
    public static double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        double res=1;
        if(n<0){
            x=1/x;
            n=n*-1;
        }
        while(n>1){
            if(n%2==1){
                res*=x;
            }
            n/=2;
            x*=x;
        }
        res=res*x;

        return res;
    }
    public static void test(){
        int x=45;
        int b;
        long stime=System.currentTimeMillis();
        for(long i=0;i<10000000000L;i++)
           b= x/2;
        long etime=System.currentTimeMillis();
        System.out.println(etime-stime);

        stime=System.currentTimeMillis();
        for(long i=0;i<10000000000L;++i)
            b= x/1;
        etime=System.currentTimeMillis();
        System.out.println(etime-stime);
    }
}
