package BFS广度优先;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet103 {
    public static void main(String[] args) {
        leet100.TreeNode root=new leet100.TreeNode(3);
        root.left=new leet100.TreeNode(9);
        root.right=new leet100.TreeNode(20);
        root.left.left=new leet100.TreeNode(6);
        root.left.right=new leet100.TreeNode(4);
        root.right.left=new leet100.TreeNode(15);
        root.right.right=new leet100.TreeNode(7);
        zigzagLevelOrder(null);
    }
    public static List<List<Integer>> zigzagLevelOrder(leet100.TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list;
        LinkedList<leet100.TreeNode> queue=new LinkedList<>();
        LinkedList<leet100.TreeNode> tempQueue;
        queue.offer(root);
        boolean isL2R=false;
        while (!queue.isEmpty()){
            tempQueue=new LinkedList<>();
            list=new ArrayList<>();

            while (!queue.isEmpty()){
                leet100.TreeNode node = queue.removeLast();
                if(node!=null){
                    list.add(node.val);
                    if(isL2R) {
                        tempQueue.offer(node.right);
                        tempQueue.offer(node.left);
                    }
                    else {
                        tempQueue.offer(node.left);
                        tempQueue.offer(node.right);

                    }
                }
            }
            isL2R=!isL2R;
            if(list.size()!=0)
                res.add(list);
            queue=tempQueue;
        }
        return res;
    }
}
