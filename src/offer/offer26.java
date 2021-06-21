package offer;

import leetcode.treenode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class offer26 {
    private static boolean res;
    public static boolean isSubStructure(treenode A, treenode B) {
        if(A==null||B==null)
            return false;
        res=true;
        List<treenode> list=new ArrayList<>();
        findStart(A,B.val,list);
        if(list.size()==0)
            return false;
        for(treenode node:list) {
            verifyTree(node, B);
            if(res) return res;
        }
        return res;
    }
    public static void findStart(treenode root,int value,List<treenode> list){
        if(root==null) return ;
        if(root.val==value) {
            list.add(root);

        }
        findStart(root.left,value,list);
        findStart(root.right,value,list);
    }
    public static void verifyTree(treenode rootA,treenode rootB){
        if(rootB==null) return;
        if(rootA==null) {
            res= false;
            return;
        }
        if(rootA.val!=rootB.val) res= false;
        verifyTree(rootA.left,rootB.left);
        verifyTree(rootA.left,rootB.left);

    }
}
