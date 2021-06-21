package offer;

public class offer13 {
    public static void main(String[] args) {
        int res=movingCount(16,8,4);
        System.out.println(res);
    }
    public static int movingCount(int m, int n, int k) {
        int res=0;
        int[][] record=new int[m][n];
        for(int i=0;i<m;++i){
            int sum=getSum(i);
            for(int j=0;j<n;++j){
                int temp=sum+getSum(j);
                if(temp<=k)
                    record[i][j]=1;
            }
        }
        return res;
    }
    public static int getSum(int num){
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
