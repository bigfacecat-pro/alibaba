package BFS广度优先;

import java.util.*;

public class offer32_1 {
    public int[] levelOrder(leet100.TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Queue<leet100.TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int layerSize= queue.size();
            while (layerSize-->0){
                leet100.TreeNode node= queue.poll();
                res.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        int[] resa = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            resa[i] = res.get(i);

        return resa;
    }
}
