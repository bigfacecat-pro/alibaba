package learning.sort;

public class SelectionSort extends Sort {
    @Override
    protected  void sort(){
        for(int i=arrayI.length-1;i>0;--i){
            int maxIndex=0;
            for(int j=0;j<i;++j){
                if(cmp(j,maxIndex)<0)
                    maxIndex=j;

            }
            swap(maxIndex,i);
        }
    }
}
