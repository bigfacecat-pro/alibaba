package offer;

public class offer20 {
    public static void main(String[] args) {
        double s=.3;
        double s1=-.3;
        double s2=3.;
        //double s3=e9;
        boolean res=isNumber("1a3.14");
        System.out.println(res);
    }
    public static boolean isNumber(String s) {
        s=s.trim();
        if(s.length()==0||s.charAt(0)=='e'||s.charAt(0)=='E'||s.charAt(s.length()-1)=='e'||s.charAt(s.length()-1)=='E')
            return false;
        String[] sp=s.split("e|E");
        if(sp.length>2)
            return false;
        if(verifyNum(sp[0])==0)
            return false;
        if(sp.length>1&&verifyNum(sp[1])<2)
            return false;
        return true;

    }
    public static int  verifyNum(String in){
        if(in.equals(".")||in.equals("+.")||in.equals("-.")||in.equals("+")||in.equals("-"))
            return 0;
        int index=0;
        boolean containPoint=false;
        if(in.charAt(0)=='+'||in.charAt(0)=='-')
            index = 1;
        while (index<in.length()){
            if(in.charAt(index)=='.'){
                if(containPoint||index==in.length()-1)
                    return 0;
                else
                    containPoint=true;
            }
            else if(in.charAt(index)<'0'||in.charAt(index)>'9')
                return 0;
            index++;
        }
         return containPoint?1:2;
    }
}
