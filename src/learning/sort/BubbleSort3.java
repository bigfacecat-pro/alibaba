package learning.sort;

public class BubbleSort3 extends Sort {
    @Override
    protected void sort() {
        int end=arrayI.length-1;
        for(int i=arrayI.length-1;i>0;--i){
            int last=0;
            for(int j=0;j<i;++j){
                if(cmp(j,j+1)<0){
                    swap(j,j+1);
                    last=j+1;
                }
            }
            i=last;
        }
    }
}
