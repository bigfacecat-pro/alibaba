package HUAWEI.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] size=br.readLine().split(" ");
        int[][] maxi=new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        for(int i=0;i<maxi.length;++i){
            String[] rowData= br.readLine().split(" ");
            for(int j=0;j<maxi[0].length;++j)
                maxi[i][j]= Integer.parseInt(rowData[j]);
        }
        int res=search(0,0,maxi[0][0],maxi[0][0],maxi);
        System.out.println(res);
    }
    public static int search(int rowIndex,int columnIndex,int res,int last,int[][] maxi){
        if(rowIndex== maxi.length-1&&columnIndex==maxi[0].length-1) return res;
        if(rowIndex==maxi.length-1){
            int me=maxi[rowIndex+1][columnIndex];
            if(me==last)
                me--;
            res+=me;
            return search(rowIndex+1,columnIndex,res,me,maxi);
        }
        if(columnIndex==maxi[0].length-1){
            int me=maxi[rowIndex][columnIndex+1];
            if(me==last)
                me--;
            res+=me;
            return search(rowIndex+1,columnIndex,res,me,maxi);
        }
        int l=maxi[rowIndex][columnIndex+1];
        int ld=maxi[rowIndex+1][columnIndex+1];
        int d=maxi[rowIndex+1][columnIndex];

        if(l==last) l--;
        if(ld==last) ld--;
        if(d==last) d--;


        if(l<ld-1&&l<d){
            res+=l;
            return search(rowIndex,columnIndex+1,res,maxi[rowIndex][columnIndex+1],maxi);
        }
        else if(d<ld-1&&d<l) {
            res+=d;
            return search(rowIndex + 1, columnIndex, res, maxi[rowIndex+1][columnIndex], maxi);
        }
        else {
            res+=ld;
            return search(rowIndex + 1, columnIndex + 1, res, maxi[rowIndex+1][columnIndex+1], maxi);
        }
    }
}
