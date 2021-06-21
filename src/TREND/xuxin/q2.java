package TREND.xuxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            int[] groups = new int[input.length];
            int sum=0;
            for (int i = 0; i < input.length; ++i) {
                groups[i] = Integer.parseInt(input[i]);
                sum+=groups[i];
            }
            int count = Integer.parseInt(br.readLine());
            int avg=sum/count;
            Arrays.sort(groups);
            int[] res = new int[count];
            int index = 0;
            for (int i = 0; i < res.length; ++i)
                    res[i] += groups[groups.length - 1 - i];
            Arrays.sort(res);
            int valid=0;

            while ((index+valid) <=(groups.length - count)) {
                valid=0;
                for (int i = 0; i < res.length; ++i) {
                    if(res[res.length-1-i]<(avg+1)) {
                        res[res.length-1-i] += groups[index+valid ];
                        valid++;
                    }
                }
                index += valid;
                Arrays.sort(res);
            }
            valid=0;
            for (int i = 0; i < res.length; ++i) {

                if(res[res.length-1-i]<(avg+1)&&(index+valid)<(groups.length-count)) {
                    res[res.length-1-i] += groups[index+valid++ ];
                }
            }
            Arrays.sort(res);
            System.out.println(Arrays.toString(res));
        }
    }
}
/*
1 2 3 4 5 6 7
5
1 2 3 4 5 6 7 8 9 10
3
1 2 3 4 5 6 7 8 9 10
4
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
3
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
4
4 6 78 12 46 7 9 23 1 56 4
3
 */