package BFS广度优先;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class leet100 {
    public static void main(String[] args) {
        isSameTree(null,null);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> queueQ=new LinkedList<>();
        queue.add(p);
        queueQ.add(q);
        while (!queue.isEmpty()){
            if(queueQ.isEmpty()) return false;

            TreeNode node= queue.poll();
            TreeNode nodeQ=queueQ.poll();
            if(node==null||nodeQ==null){
                if(nodeQ==null&&node==null){
                    continue;
                }else
                    return false;
            }else if(node.val!= nodeQ.val)
                return false;

            queue.add(node.left);
            queueQ.add(nodeQ.left);
            queue.add(node.right);
            queueQ.add(nodeQ.right);

        }
        return queueQ.isEmpty();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
