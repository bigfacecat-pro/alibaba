package WangYi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void main (String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null) {
            int inputLength = Integer.parseInt(str);
            String[] inputStr = br.readLine().split(" ");
            int[] input = new int[inputLength];
            for (int i = 0; i < inputLength; ++i)
                input[i] = Integer.parseInt(inputStr[i]);
            int res = 0, tempSum = 0;

            for (int i = 0; i < inputLength - 1; i++) {
                int cur = input[i] - input[i + 1];
                if (tempSum + cur < 0) {
                    res = res > tempSum ? res : tempSum;
                    tempSum = 0;
                } else {
                    tempSum += cur;
                    i++;
                }
            }
            res = res > tempSum ? res : tempSum;
            res = res > input[inputLength - 1] ? res : input[inputLength - 1];


            res = res > 0 ? res : 0;
            System.out.println(res);
        }
    }
}
