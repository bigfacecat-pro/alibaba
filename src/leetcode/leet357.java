package leetcode;

public class leet357 {
    public static void main(String[] args) {
        countNumbersWithUniqueDigits(3);
    }
    public static int countNumbersWithUniqueDigits(int n) {
        if(n<2)
            return (n-1)*9;
        int[] dp=new int[n+1];
        for(int i=2;i<=n;++i){
            dp[i]=(9*(int)Math.pow(10,i-2)-dp[i-1])*(i-1)+dp[i-1]*10;
        }
        int res=0;
        for(int x:dp)
            res+=x;
        return (int)Math.pow(10,n)-res;
    }
}
