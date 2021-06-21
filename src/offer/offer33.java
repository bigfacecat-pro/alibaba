package offer;

import java.util.Arrays;

public class offer33 {
    public static void main(String[] args) {
        //verifyPostorder(new int[]{1,6,3,2,5});
        //verifyPostorder(new int[]{1,3,2,6,5});
        verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61});
    }
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0)
            return true;
        int root=postorder[postorder.length-1];
        int rightIndex=0;
        while(postorder[rightIndex]<root)
            rightIndex++;

        for(int i=rightIndex;i<postorder.length;++i)
            if(postorder[i]<root)
                return false;
        if(!verifyPostorder(Arrays.copyOfRange(postorder,0,rightIndex)))
            return false;
        if(!verifyPostorder(Arrays.copyOfRange(postorder,rightIndex,postorder.length-1)))
            return false;
        return true;
    }
}
