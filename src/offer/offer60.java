package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class offer60 {
    public static void main(String[] args) {
        dicesProbability2(2);
    }
    public static double[] dicesProbability(int n) {
        Map<Integer,Double> resMap=new HashMap<>();
        for(int i=0;i<6;++i)
            resMap.put(i+1,1/6.0);

        for(int i=2;i<=n;++i){
            Map<Integer,Double> temp=new HashMap<>();
            for(int a=i;a<(i*6+1);++a){
                double value=0;
                int baseNum=1;
                while(baseNum<a&&baseNum<=6){
                    if(resMap.containsKey(a-baseNum))
                        value+=resMap.get(a-baseNum)*(1/6.0);
                    baseNum++;
                }
                temp.put(a,value);
            }
            resMap=temp;
        }
        double[] res=new double[resMap.size()];
        int i=0;
        for(double x: resMap.values()) {
            res[i] = x;
            i++;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    public static double[] dicesProbability2(int n) {
        double[] dp=new double[7];
        Arrays.fill(dp,1/6.0);

        for(int i=2;i<=n;++i){
            double[] temp=new double[6*i+1];
            for(int a=i;a<(i*6+1);++a){
                double value=0;
                int baseNum=1;
                while(baseNum<a&&baseNum<=6){
                    if(a-baseNum<=dp.length-1)
                        value+=1/6.0*dp[a-baseNum];
                    baseNum++;
                }
                temp[a]=value;

            }
            dp=temp;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(dp,n,dp.length)));
        return Arrays.copyOfRange(dp,n,dp.length);
    }
}
