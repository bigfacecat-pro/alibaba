package WangYi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1518 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int dataCount=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        int res=0;
        boolean flag=false;
        while (dataCount-->0){
            String str=br.readLine();
            res=0;
            flag=false;
            for(int i=0;i<str.length();++i){

                char c=str.charAt(i);
                switch (c){
                    case 's': res+=flag?3:3;flag=false;break;
                    case 'd': res+=flag?4:3;flag=false;break;
                    case 'u': res+=flag?5:3;flag=false;break;
                    case 'p': res+=flag?6:3;flag=false;break;
                    case 'f': res+=flag?7:3;flag=false;break;
                    case '%':
                        if(!flag) {
                            res += 3;
                            flag=true;
                        }
                        else {
                            res += 9;
                            flag=false;
                        }
                            break;
                    default:
                        if(flag) {
                            if (c >= '0' && c <= '9')
                                res += 8;
                            else {
                                res += 10;
                                flag = false;
                            }
                        }else
                            res+=3;
                }

            }
            if(!"".equals(str)) res+=1;
            sb.append(res).append("\n\r");
            //System.out.println(res);
        }

        System.out.print(sb.toString());
    }
}
/*
6
%2d
123pqr
123pqr%
%123pqr
%s%u%p%d%f%%
%%%%%
 */