package HUAWEI.zhengweifeng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int moduleCount=Integer.parseInt(br.readLine());
        Map<Integer,ArrayList<Integer>> moduleSet =new HashMap<>();
        boolean[] useful=new boolean[moduleCount];
        Set<Integer> beDepend=new HashSet<>();
        int res=10;

        for(int i=0;i<moduleCount;++i){
            String[] order=br.readLine().split(" ");
            int o1=Integer.parseInt(order[0]);
            useful[o1]=true;
            ArrayList<Integer> list=moduleSet.getOrDefault(o1,new ArrayList<>());
            if(order.length>1){

                int o2=Integer.parseInt(order[1]);
                list.add(o2);
                beDepend.add(o2);
            }
            moduleSet.put(o1,list);
        }
        ArrayList<Integer> tempSet;
        for(int i=0;i<moduleCount;++i) {
            if(!useful[i])
                continue;
            //无用检测
            if (moduleSet.get(i).size()==0) {
                if(!beDepend.contains(i))
                    res--;
            }else{
                //循环依赖检测
                tempSet=new ArrayList<>();
                tempSet.add(i);
                int S=i;
                ArrayList<Integer> list=findLoop(moduleSet,i,i,tempSet);
                if(list!=null){
                    res-=2;
                    for(int x:list)
                        useful[x]=false;
                }

            }

        }
        res=res<0?0:res;
        System.out.println(res);
    }
    public static ArrayList<Integer> findLoop(Map<Integer, ArrayList<Integer>> map, int start,int toWhere, ArrayList<Integer> Road){

        ArrayList<Integer> list=map.get(toWhere);
        if(list==null)
            return null;
        for(int x:list){
            ArrayList<Integer> myRoad= new ArrayList<>(Road);
            if(x==start){
                return myRoad;
            }else if(Road.contains(x)){
                return null;

            }
            else{
                myRoad.add(x);
                ArrayList<Integer> ans= findLoop(map,start,x,myRoad);
                if(ans!=null)
                    return ans;
            }

        }
        return null;
    }
}
