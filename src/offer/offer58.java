package offer;

public class offer58 {
    public static void main(String[] args) {
        //reverseWords("the sky is   blue");
        //reverseWords("  hello world!  ");
        //reverseWords2("  hello world!  ");
        reverseWords2("a good   example");
    }

    /**
     * 7mm
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if(s.trim().length()==0)
            return "";
        String[] temp=s.split(" +");
        StringBuilder sb=new StringBuilder();
        for(int i=temp.length-1;i>=0;--i)
            if(!temp[i].equals(""))
                sb.append(temp[i]).append(" ");
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     * 3mm
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        s=s.trim();
        if(s.trim().length()==0)
            return "";
        int lIndex=s.length()-1,rIndex=lIndex;
        StringBuilder sb=new StringBuilder();
        while(lIndex>=0){
            while(lIndex>=0&&  s.charAt(lIndex)!=' ')
                lIndex--;
            sb.append(s.substring(lIndex+1,rIndex+1)).append(" ");
            while (lIndex>0&& s.charAt(--lIndex)==' ');
            rIndex=lIndex;
        }
        return sb.toString().trim();
    }
}
