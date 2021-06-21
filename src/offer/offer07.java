package offer;

import java.util.Arrays;

public class offer07 {
    public static void main(String[] args) {
        //buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        buildTree2(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        //buildTree2(new int[]{1,2},new int[]{1,2});
        //buildTree(new int[]{0,1},new int[]{1,0});
    }
    public static myTreeNode buildTree(int[] preorder, int[] inorder) {
        myTreeNode root=new myTreeNode(preorder[0]);
        if(preorder.length==1)
            return root;
        int rootIndex=0;
        while(inorder[rootIndex]!=preorder[0])
            rootIndex+=1;
        int leftLen=rootIndex;
        root.left=buildTree(Arrays.copyOfRange(preorder,1,1+leftLen),Arrays.copyOfRange(inorder,0,leftLen));
        root.right=buildTree(Arrays.copyOfRange(preorder,1+leftLen,preorder.length),Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        return root;
    }

    public static myTreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        myTreeNode root=myTreeNode2(0,preorder.length,0,preorder.length,preorder[0],preorder,inorder);
        return root;
    }
    public static myTreeNode myTreeNode2(int preStart,int preEnd,int inStart,int inEnd,int rootValue,int[] preorder, int[] inorder){
        if((preEnd-preStart)==0)
            return null;
        myTreeNode root=new myTreeNode(preorder[preStart]);
        if((preEnd-preStart)==1)
            return root;
        int rootIndex=preStart;
        while(inorder[rootIndex]!=preorder[preStart])
            rootIndex+=1;
        int leftLen=rootIndex-preStart;
        root.left=  myTreeNode2(rootIndex,rootIndex+leftLen,inStart,inStart+leftLen,preorder[rootIndex],preorder,inorder);
        root.right=myTreeNode2(preStart+leftLen+1,preEnd,rootIndex+1,inEnd,preorder[rootIndex],preorder,inorder);
        return root;
    }
}
 class myTreeNode {
     int val;
     myTreeNode left;
     myTreeNode right;
     myTreeNode(int x) { val = x; }
 }