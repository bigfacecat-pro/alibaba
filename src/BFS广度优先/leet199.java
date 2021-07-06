package BFS广度优先;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet199 {
    public List<Integer> rightSideView(leet100.TreeNode root) {
        if(root==null) return null;
        List<Integer> res=new ArrayList<>();
        Queue<leet100.TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int layerSize= queue.size();
            while (layerSize-->0){
                leet100.TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(layerSize==0)
                    res.add(node.val);
            }
        }
        return res;
    }
}
