package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class leet42 {
    public static void main(String[] args) {
        int res= coinChange(new int[]{1},0);
        int a=0;
    }
    public static  int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+10);
        dp[0]=0;
        for(int i=1;i<=amount;++i){
            for(int j=0;j<coins.length;++j){
                if(i>=coins[j])
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

}
