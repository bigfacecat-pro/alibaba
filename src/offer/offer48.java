package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class offer48 {
    public static void main(String[] args) {
        //lengthOfLongestSubstring("abcabcbb");
        //lengthOfLongestSubstring("pwwkew");
        //lengthOfLongestSubstring2("abcabcbb");
        lengthOfLongestSubstring2("pwwkew");
    }

    /**
     * 8mm,53
     * 38.4m,76
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<2)
            return s.length();
        int leftIndex=0,rightIndex=0;
        int res=0;
        Set<Character> charSet=new HashSet<>();

        while (rightIndex<s.length()){
            char rightChar=s.charAt(rightIndex);
            if(charSet.contains(rightChar)){
                char leftChar=s.charAt(leftIndex);
                while(leftChar!=rightChar){
                    leftIndex++;
                    charSet.remove(leftChar);
                    leftChar=s.charAt(leftIndex);
                }
                leftIndex++;
                charSet.remove(leftChar);
            }
            charSet.add(rightChar);
            rightIndex++;
            res=Math.max(res,rightIndex-leftIndex);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s.length()<2)
            return s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int leftIndex=0;
        int res=-1;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(map.containsKey(c))
                leftIndex=Math.max(leftIndex, map.get(c));
            map.put(c,i);
            res=Math.max(res,i-leftIndex);
        }
        return res;
    }
}
