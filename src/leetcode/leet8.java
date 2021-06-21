package leetcode;

public class leet8 {
    public static void main(String[] args) {
        myAtoi("9223372036854775808");
    }
    public static int myAtoi(String s) {
        s=s.trim();
        char c=s.charAt(0);
        if((c>'9'||c<'0')&&c!='-'&&c!='+')
            return 0;
        long res=0;
        int i=0;
        boolean isSub=false;
        if(c=='-'||c=='+') {
            if(c=='-')
                isSub=true;
            i = 1;
        }
        while(i<s.length() ){
            c=s.charAt(i);
            if(c>='0'&&c<='9') {
                res = res * 10 + (c - '0');
                i++;
                if(res>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if(res<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else
                break;
        }
        if(isSub)
            res*=-1;

        return (int)res;
    }
}
