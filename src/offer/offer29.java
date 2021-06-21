package offer;

import java.util.Arrays;

public class offer29 {
    public static void main(String[] args) {
        int[] res=spiralOrder(new int[][]{});
        System.out.println(Arrays.toString(res));
    }
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int[] res=new int[matrix.length*matrix[0].length];
        int rowIndex=0,columnIndex=0;
        int loop=0,direction=0;
        for(int x=0;x<res.length;x++){
            res[x]=matrix[rowIndex][columnIndex];
            switch(direction) {
                case 0:
                    if (columnIndex == matrix[0].length - 1 - loop) {
                        direction = 1;
                        rowIndex++;
                    } else
                        columnIndex++;
                    break;
                case 1:
                    if (rowIndex == matrix.length - 1 - loop) {
                        direction = 2;
                        columnIndex--;
                    } else
                        rowIndex++;
                    break;
                case 2:
                    if (columnIndex == loop) {
                        direction = 3;
                        rowIndex--;
                    } else
                        columnIndex--;
                    break;
                case 3:
                    if (rowIndex == loop+1) {
                        direction = 0;
                        loop++;
                        columnIndex++;
                    } else
                        rowIndex--;
                    break;
            }
        }
        return res;
    }
}
