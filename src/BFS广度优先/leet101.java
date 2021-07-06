package BFS广度优先;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet101 {
    public boolean isSymmetric(leet100.TreeNode root) {
        Queue<leet100.TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int layerLength= queue.size();
            while (layerLength-->0) {
                leet100.TreeNode node= queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else
                    list.add(null);
            }
            int listIndex=0;
            layerLength=list.size();
            while (listIndex<(layerLength+1)/2){
                if(list.get(listIndex)!=list.get(layerLength-listIndex-1))
                    return false;
                listIndex++;
            }
            list.clear();
        }
        return true;
    }

    public boolean isSymmetric2(leet100.TreeNode root) {
        LinkedList<leet100.TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int len=1;
        while (!queue.isEmpty()){
            LinkedList<leet100.TreeNode> queueTemp=new LinkedList<>();
            if(queue.size()!=len)
                return false;
            for(leet100.TreeNode node:queue) {
                if(node!=null) {
                    queueTemp.offer(node.left);
                    queueTemp.offer(node.right);
                }
            }
            while (!queue.isEmpty()) {
                leet100.TreeNode nodeL= queue.removeFirst();
                leet100.TreeNode nodeR= queue.removeLast();
                if(nodeL.val!= nodeR.val)
                    return false;
            }
            queue=queueTemp;
            len*=2;
        }
        return true;
    }
}
