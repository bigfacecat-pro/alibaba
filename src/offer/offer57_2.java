package offer;

import java.util.ArrayList;
import java.util.List;

public class offer57_2 {
    public static void main(String[] args) {
        findContinuousSequence(10);
    }
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int[] temp;
        double dTarget=target;
        for(int i=(target+1)/2;i>=2;--i){
            double ds=dTarget/i-target/i;
            if((ds==0.0&&i%2==1)||(ds==0.5&&i%2==0)){
                int a= (int) (dTarget/i+ds-i/2);
                if(a>=1) {
                    temp = new int[i];
                    temp[0] = a;
                    for (int j = 1; j < temp.length; ++j)
                        temp[j] = temp[j - 1] + 1;
                    res.add(temp);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private int[][] fun(int tar){
        double dTarget=tar  ;
        List<int[]> list=new ArrayList<>();
        int[] temp;
        for(int i=(tar+1)/2;i>=2;--i){
            double mo=  dTarget/i-tar/i;
            if((mo==0&&i%2==1)||(mo==0.5&&i%2==0)){
                int left= (int) (tar/i+mo-i/2);
                if(left>0){
                    temp=new int[i];
                    temp[0]=left;
                    for(int j=1;j<i;j++)
                        temp[j]=temp[j-1]+1;
                    list.add(temp);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
