package learning.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort extends Sort{
    private static List<Integer> steps=new ArrayList<>();

    @Override
    protected void sort(){
        int len=arrayI.length;
        int step=arrayI.length>>1;
        while(step>0) {
            steps.add(step);
            step = step >> 1;
        }
        for(int stepLength:steps)
            stepSort(stepLength);
    }
    private void stepSort(int step){
        for(int column=0;column<step;++column){
            for(int row=1;row<arrayI.length/step;row++) {
                int index = step*row+column;
                int temp = arrayI[index];
                while (index >=step && temp < arrayI[index - step]){
                    arrayI[index] = arrayI[index - step];
                    index -= step;
                }
                arrayI[index]=temp;
            }
        }
    }
}
