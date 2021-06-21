package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class leetcode90 {
    private static List<Integer> t = new ArrayList<Integer>();
    private static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        //subsets(new int[]{1,2,2});
        wordSubsets(new String[]{"dcbddbbbeb","edeabaedbc","beecbdbabe","bacadddbda","ecbdebddbb","abeabbcaaa","eabbdbadbb","aacabeacde","bcceeaccae","ebbdebbcad"},new String[]{"add","b","ba","ada","dcd"});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }



        public static List<String> wordSubsets(String[] A, String[] B) {
            List<String> res=new ArrayList<>();
            Map<Character,Integer> set=new HashMap<>();
            Map<Character,Integer> setT=new HashMap<>();
            for(String s:B){
                for(int i=0;i<s.length();++i){
                    setT.put(s.charAt(i),setT.getOrDefault(s.charAt(i),0)+1);
                }
                for(Map.Entry<Character,Integer> entry:setT.entrySet())
                    set.put(entry.getKey(),Math.max(entry.getValue(),set.getOrDefault(entry.getKey(),0)));
                setT.clear();
            }

            for(String s:A){
                Map<Character,Integer> temp=new HashMap<>(set);
                for(int i=0;i<s.length();++i){
                    char c=s.charAt(i);
                    if(temp.containsKey(c)){
                        int count=temp.get(c);
                        if(count==1)
                            temp.remove(c);
                        if(count>1)
                            temp.put(s.charAt(i),count-1);
                    }

                }
                if(temp.size()==0)
                    res.add(s);
            }
            return res;
        }



}
