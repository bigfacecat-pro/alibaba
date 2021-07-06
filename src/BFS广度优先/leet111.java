package BFS广度优先;

import java.util.LinkedList;

public class leet111 {
    public int minDepth(leet100.TreeNode root) {
        LinkedList<leet100.TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            res++;
            int layerSize= queue.size();
            while (layerSize-->0){
                leet100.TreeNode node=queue.removeFirst();
                if(node.left==null&&node.right==null)
                    return res;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

            }
        }
        return 0;
    }
}
