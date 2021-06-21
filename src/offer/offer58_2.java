package offer;

public class offer58_2 {
    public static void main(String[] args) {
        String res=reverseLeftWords("",0);
        System.out.println(res);
    }
    public static String reverseLeftWords(String s, int n) {
        if(s.length()<n)
            return s;
        StringBuilder res=new StringBuilder();
        for(int i=n;i<s.length();++i)
            res.append(s.charAt(i));
        for(int i=0;i<n;++i)
            res.append(s.charAt(i));
        return res.toString();
    }
}
