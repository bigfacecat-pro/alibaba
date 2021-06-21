package leetcode;

import java.util.ArrayList;
import java.util.List;

public class
leet204 {
    public static void main(String[] args) {
        countPrimes(150);
    }
    public static int countPrimes(int n) {
        List<Integer> list=new ArrayList<>();
        int res=0;
        if(n>2)
            res++;
        for(int i=3;i<n;i+=2){
            if(isPrime(i)) {
                res++;
                list.add(i);
            }

        }
        return res;
    }
    public static boolean isPrime(int n){
        if(n==3||n==5||n==7)
            return true;
        if(n%3==0)
            return false;
        if(n%5==0)
            return false;
        if(n%7==0)
            return false;
        double sq=Math.sqrt(n);
        if(sq==(int)sq)
            return false;
        return true;
    }
}
