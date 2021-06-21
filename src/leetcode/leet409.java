package leetcode;

public class leet409 {
    public static void main(String[] args) {
        //longestPalindrome("abccccdd");
        countSubstrings("a");
    }
    public static int longestPalindrome(String s) {
        int res=0;
        for(int i=0;i<s.length();++i){
            for(int j=i;j<i+2;++j){
                int temp=0;
                int left=i,right=j;
                while(left>=0&&right<s.length()&&s.charAt(left--)==s.charAt(right++)) {
                    temp++;
                }
                res=res>temp?res:temp;
            }
        }
        return res;
    }
    public static int countSubstrings(String s) {
        int res=0;
        for(int i=0;i<s.length();++i){
            for(int j=0;j<2;++j){

                int left=i,right=i+j;
                while(left>=0&&right<s.length()&&s.charAt(left--)==s.charAt(right++)) {
                    res=res>(right-left+2)?res:(right-left+2);
                }

            }
        }
        return res;
    }
}
