package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet207 {
    public static void main(String[] args) {
        //canFinish(2,new int[][]{{1,0}});
        canFinish(2,new int[][]{{0,1}});
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList=new ArrayList<>();
        int[] dep=new int[numCourses];
        for(int i=0;i<numCourses;++i)
            courseList.add(new ArrayList<Integer>());
        for(int[] pre:prerequisites){
            courseList.get(pre[1]).add(pre[0]);
            dep[pre[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<dep.length;++i){
            if(dep[i]==0)
                queue.offer(i);
        }

        while(queue.size()!=0){
            int p=queue.poll();
            for(int x:courseList.get(p)){
                dep[x]--;
                if(dep[x]==0)
                    queue.offer(x);
            }
        }
        for(int x:dep){
            if(x>0)
                return false;
        }
        return true;
    }
}
