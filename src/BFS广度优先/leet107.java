package BFS广度优先;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet107 {
    public List<List<Integer>> levelOrderBottom(leet100.TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<>();
        List<Integer> list;
        LinkedList<leet100.TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            list=new ArrayList<>();
            int layerSize=queue.size();
            while (layerSize-->0){
                leet100.TreeNode node =queue.removeFirst();
                if(node!=null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(list.size()!=0)
                res.addFirst(list);
        }
        return new ArrayList<>(res);
    }
}
