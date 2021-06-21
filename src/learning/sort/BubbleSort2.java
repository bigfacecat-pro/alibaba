package learning.sort;

public class BubbleSort2 extends Sort {
    @Override
    protected void sort(){
        for(int i=arrayI.length-1;i>0;--i){
            boolean isSorted=true;
            for(int j=0;j<i;++j){
                if(cmp(j,j+1)<0){
                    swap(j,j+1);
                    isSorted=false;
                }
            }
            if(isSorted)
                break;
        }
    }
}
