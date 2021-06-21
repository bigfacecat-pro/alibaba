package WangYi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2 {

    public static void main(String[] args) {
        //long[][] logs=new long[][]{{1610000000000L,1620000000000L}, {1610000000000L,1610000001000L}, {1615000000000L,1620000000000L}};
        long[][] logs=new long[][]{
                {1610000031138L, 1610000035950L}, {1610000069951L, 1610000070481L}, {1610000057673L, 1610000060035L},
        {1610000054054L, 1610000055910L}, {1610000051550L, 1610000055824L}, {1610000007030L, 1610000015860L}, {1610000034848L, 1610000035743L},
        {1610000071848L, 1610000076082L}, {1610000033080L, 1610000040814L}, {1610000098830L, 1610000107163L}, {1610000072408L, 1610000077206L},
        {1610000080095L, 1610000082948L}, {1610000010690L, 1610000019809L}, {1610000095191L, 1610000102590L}, {1610000086055L, 1610000091841L},
        {1610000006655L, 1610000009243L}, {1610000079056L, 1610000088091L}, {1610000050499L, 1610000053698L}, {1610000079235L, 1610000086235L},
        {1610000091063L, 1610000095948L}, {1610000053071L, 1610000060289L}, {1610000042965L, 1610000044302L}, {1610000030261L, 1610000035735L},
        {1610000063273L, 1610000068484L}, {1610000018526L, 1610000018620L}, {1610000012080L, 1610000014595L}, {1610000054147L, 1610000061607L},
        {1610000006016L, 1610000013090L}, {1610000079415L, 1610000086677L}, {1610000043195L, 1610000046577L}, {1610000011567L, 1610000021464L},
        {1610000063727L, 1610000072752L}, {1610000092433L, 1610000098792L}, {1610000077639L, 1610000087292L}, {1610000007171L, 1610000009316L},
        {1610000099965L, 1610000105769L}, {1610000051982L, 1610000052324L}, {1610000077968L, 1610000087109L}, {1610000004921L, 1610000010201L},
        {1610000073512L, 1610000077570L}, {1610000067079L, 1610000071651L}, {1610000063038L, 1610000063040L}, {1610000040500L, 1610000042890L},
        {1610000033535L, 1610000040964L}, {1610000094686L, 1610000097926L}, {1610000007951L, 1610000016340L}};
        //long[] tss=new long[]{1610000002000L,1616000000000L,1630000000000L};
        long[] tss=new long[]{1610000085863L, 1610000063923L};
        search_log(logs,tss);
    }
    public static int[][] search_log (long[][] logs, long[] tss) {
        int[][] res=new int[tss.length][];
        List<Integer> list;

        for(int i=0;i<tss.length;++i){
            list=new ArrayList<>();
            for(int j=0;j<logs.length;++j){
                if(tss[i]>logs[j][0])
                    if(tss[i]<logs[j][1])
                        list.add(j);
            }
            res[i]=new int[list.size()];
            for(int index=0;index<res[i].length;++index)
                res[i][index]=list.get(index);
        }
        return res;
    }
}
