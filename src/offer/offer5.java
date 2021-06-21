package offer;

public class offer5 {
    public static void main(String[] args) {
        String res= longestPalindrome("ac");
        System.out.println(res);
    }
    public static   String longestPalindrome(String s) {
        if(s.length()==0)
            return null;
        char[] s2Char=s.toCharArray();
        int maxLen=0;
        int range=0;
        int tempLen=0;
        String res="";
        int lIndex=0,rIndex=0;
        while (lIndex+(maxLen-1)/2<s.length()){
            rIndex=lIndex;
            tempLen= getCurrentMax(lIndex,rIndex,s2Char);
            if(tempLen>maxLen){
                maxLen=tempLen;
                res=s.substring(lIndex-(tempLen-1)/2,lIndex+(tempLen-1)/2+1);
            }


            rIndex=lIndex+1;
            tempLen= getCurrentMax(lIndex,rIndex,s2Char);
            if(tempLen>maxLen){
                maxLen=tempLen;
                res=s.substring(lIndex-(tempLen-1)/2,rIndex+(tempLen-1)/2+1);
            }
            lIndex++;
        }
        return res;
    }
    private static int getCurrentMax(int lIndex,int rIndex,char[] s2Char){
        int  range=0;
        while (((lIndex-range)>=0) && (rIndex+range)<s2Char.length && s2Char[lIndex-range]==s2Char[rIndex+range]){
            range++;
        }
        return (range-1)*2+rIndex-lIndex+1;
    }
}
