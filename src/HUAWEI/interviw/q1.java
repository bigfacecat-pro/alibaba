package HUAWEI.interviw;

public class q1 {
    public static void main(String[] args) {
        int[] input=new int[]{1,17,5,10,13,15,10,5,16,8};
        //int[] input=new int[]{1,7,4,9,2,5};
        //int[] input=new int[]{1,2,3,4,5,6,7,8,9};
        int[] sub=new int[input.length-1];
        for(int i=0;i<sub.length;++i)
            sub[i]=input[i+1]-input[i];

        int index=0;
        while(sub[index]==0)
            index++;
        int res=1;
        int last=sub[0];
        index++;
        for(;index< sub.length;++index){
            if((last<0&&sub[index]>0)||(last>0&&sub[index]<0)) {
                res++;
            }
            last=sub[index];
        }
        res+=1;
        System.out.println(res);
    }
}
