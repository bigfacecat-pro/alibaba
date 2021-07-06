package BFS广度优先;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class offer28 {
    public static void main(String[] args) {
        leet100.TreeNode root=new leet100.TreeNode(3);
        root.left=new leet100.TreeNode(9);
        root.right=new leet100.TreeNode(9);
        root.left.left=new leet100.TreeNode(3);
        root.left.right=new leet100.TreeNode(4);
        root.right.left=new leet100.TreeNode(4);
        root.right.right=new leet100.TreeNode(3);
        isSymmetric(root);
    }
    public static boolean isSymmetric(leet100.TreeNode root) {
        LinkedList<leet100.TreeNode> queue=new LinkedList<>();
        ArrayList<leet100.TreeNode> tempQueue;
        queue.offer(root);
        while (!queue.isEmpty()){
            int layerSize= queue.size();
            int leftIndex=0,rightIndex=layerSize-1;
            tempQueue=new ArrayList<>(queue);
            while (leftIndex<rightIndex){
                leet100.TreeNode lNode= tempQueue.get(leftIndex);
                leet100.TreeNode rNode= tempQueue.get(rightIndex);
                if(lNode==null&&rNode==null) {}
                else if(lNode==null||rNode==null) return false;
                else if(lNode.val!=rNode.val) return false;
                leftIndex++;
                rightIndex++;
            }
            while (layerSize-->0){
                leet100.TreeNode node=queue.removeFirst();
                if(node!=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
