package leetcode;

public class leet1309 {
    public static void main(String[] args) {
        //String res= freqAlphabets("10#11#12");
        //String res= freqAlphabets( "1326#");
        //String res= freqAlphabets( "25#");
        //String res= freqAlphabets(  "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        //String res= freqAlphabets(  "26#11#418#5");
        String res= freqAlphabets(  "10#11#12");
        System.out.println(res);
    }
    public static String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
        if(s.length()<3){
            for(int i=0;i<s.length()-2;++i) {
                sb.append((char)(s.charAt(i)+48));
            }
            return sb.toString();
        }
        int i=0;
        for(;i<s.length()-2;++i){
            char c=s.charAt(i);
            if(s.charAt(i+2)=='#'&&((c=='1')||(c=='2'))) {
                int x=((c - '0') * 10 + (s.charAt(i + 1) - '0'));
                if (x<= 26) {
                    sb.append((char) (x + 96));
                    i+=2;
                }else
                    sb.append((char)(c+48));

            }else
                sb.append((char)(c+48));
        }
        for(;i<s.length();++i){
            char c=s.charAt(i);
            sb.append((char)(c+48));
        }
        return sb.toString();
    }
}
