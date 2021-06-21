package offer;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer54 {
    public int kthLargest(myTreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        findTree(root,list);
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();++i)
            res[i]=list.get(i);
        Arrays.sort(res);
        return res[res.length-k];
    }
    public static void findTree(myTreeNode root,ArrayList<Integer> list){
        if(root==null)
            return;
        findTree(root.right,list);
        list.add(root.val);
        findTree(root.left,list);
    }

    class myTreeNode {
        int val;
        myTreeNode left;
        myTreeNode right;
        myTreeNode(int x) { val = x; }
    }
}
