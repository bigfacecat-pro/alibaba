package offer;

import java.util.ArrayList;
import java.util.List;

public class offer46 {
    public static void main(String[] args) {
        translateNum(25);
    }
    public static int translateNum(int num) {
        if(num<10)
            return 1;
        List<Integer> list=new ArrayList<>();
        for(int n=1;num/n>0;n*=10)
            list.add(num/n%10);
        int p=1,q=1;
        int res=0;
        for(int i=list.size()-2;i>=0;--i){
            if((list.get(i+1)*10+ list.get(i))>25){
                p=res;
                q=1;
            }else {
                res = p + q;
                p = q;
                q = res;
            }
        }
        System.out.println(res);
        return res;
    }
}
