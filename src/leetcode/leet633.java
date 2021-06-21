package leetcode;

public class leet633 {
    public static void main(String[] args) {
        judgeSquareSum(0);
    }
    public static boolean judgeSquareSum(int c) {
        double s=Math.pow(c,0.5);
        for(int i=0;i<=s;++i){
            double k=Math.pow(c-i*i,0.5);
            int m=(int)k/1;
            if((k-m)==0.0)
                return true;
        }
        return false;
    }
}
