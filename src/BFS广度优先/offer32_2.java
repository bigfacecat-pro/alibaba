package BFS广度优先;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_2 {
    public  List<List<Integer>> levelOrder(leet100.TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<Integer> layerRes;
        Queue<leet100.TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int layerSize= queue.size();
            layerRes=new ArrayList<>();
            while (layerSize-->0){
                leet100.TreeNode node= queue.poll();
                layerRes.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(layerRes);
        }

        return res;
    }
}
