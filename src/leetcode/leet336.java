package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet336 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<words.length;++i){
            for(int j=0;j<words.length;++j){
                if(i!=j){
                    if(isAns(words[i]+words[j]))
                        res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public static boolean isAns(String temp){
        int len=temp.length();
        for(int i=0;i<len/2;++i)
            if(temp.charAt(i)!=temp.charAt(len-1-i))
                return false;
        return true;
    }
}
