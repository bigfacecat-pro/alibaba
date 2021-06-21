package leetcode;

import java.util.*;

public class leet1190 {
    public static void main(String[] args) {
        String res= reverseParentheses("(u(love)i)");
        //String res= reverseParentheses("(ed(et(oc))el)");
        //String res= reverseParentheses("a(bcdefghijkl(mno)p)q");
        //String res= reverseParentheses("f(ul)ao(t(y)qbn)()sj");
        //String res= reverseParentheses("wnb(((z()qw)eyt)(bx(()ye)))");
        System.out.println(res);
    }
    public static String reverseParentheses(String s) {
        char[] res=new char[s.length()];
        char[] temp=new char[s.length()];
        int index=0;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            switch (c){
                case ')':
                    int m=0;
                    int rescount=index-1;
                    while (res[rescount]!='(') {
                        temp[m++] = res[rescount];
                        rescount--;
                    }
                    rescount--;
                    for(int n=0;n<m;++n)
                        res[rescount+n]=temp[n];
                    break;
                default:
                    res[index]=c;
                    index++;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<index;i++)
            sb.append(res[i]);
        return sb.toString();
    }
}
