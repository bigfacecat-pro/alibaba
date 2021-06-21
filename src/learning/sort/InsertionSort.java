package learning.sort;

public class InsertionSort extends Sort {
    @Override
    protected void sort() {
        for(int i=1;i<arrayI.length;++i){
            int index=i;
            int temp = arrayI[index];
            while(index>0&&temp<arrayI[index-1]) {
                arrayI[index]=arrayI[index-1];
                index--;
            }
            arrayI[index]=temp;
        }
    }
}
