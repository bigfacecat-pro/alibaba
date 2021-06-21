package offer;

public class offer44 {
    public static void main(String[] args) {
        int res=findNthDigit(99);
        System.out.println(res);
    }
    public static int findNthDigit(int n) {

        int curNumberLength=1;
        long curMax=9;
        long curMin=0;
        long curTotalLen=0;
        while(n>0){
            curTotalLen=(curMax-curMin+1)*curNumberLength;
            if(n>curTotalLen){
                n-=curTotalLen;
                curMin=curMax+1;
                curMax=curMin*10-1;
                curNumberLength+=1;
            }else
                break;;
        }
        String curNumber=String.valueOf(curMin+n/curNumberLength) ;
        int curLocation=n%curNumberLength;
        return  curNumber.charAt(curLocation)-'0';

    }
}
