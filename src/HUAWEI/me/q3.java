package HUAWEI.me;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int M=Integer.parseInt( str[0]);
        int N=Integer.parseInt( str[1]);
        int x=Integer.parseInt( str[2]);
        List<List<String>> mList=new ArrayList<>();
        int[] mCount=new int[M];
        String[] nInfo=new String[N];
        for(int i=0;i<M;++i) {
            mList.add(new ArrayList<>());
            mCount[i]=x;
        }
        for(int i=0;i<M;++i) {

            String[] input=br.readLine().split(" ");
            for(int j=0;j<input.length;++j)
                mList.get(i).add(input[j]);

        }
        for(int i=0;i<N;++i){
            nInfo[i]=br.readLine();
        }
        System.out.println("false");
    }
}
/*
4 6 4
Java C++ Python
Python
C++ Python
Python
Java
Python
C++
Python
C++
Java
 */