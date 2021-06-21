package learning.sort;

public class BubbleSort1 extends Sort {
    @Override
    protected void sort(){
        for(int i=arrayI.length-1;i>0;--i){
            for(int j=0;j<i;++j)
                if(cmp(j,j+1)<0)
                    swap(j,j+1);
        }
    }
}
