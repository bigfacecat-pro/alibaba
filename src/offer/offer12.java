package offer;

import java.util.Arrays;

public class offer12 {
    public static void main(String[] args) {
        int[] t=new int[]{3,5,4,1,9};
        Arrays.sort(t);
        //exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
        exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}},"AAB");
    }
    public static boolean exist(char[][] board, String word) {
        boolean res=false;
        int[][] dp=new int[board.length][board[0].length];
        for(int i=0;i<board[0].length;++i){
            for(int j=0;j<board.length;++j)
                if(board[j][i]==word.charAt(0)){
                    char[][] myBoard=arrayCopy(board);
                    myBoard[j][i]='0';
                    if(search(i,j,1,word,myBoard))
                        return true;
                }

        }
        return res;
    }
    public static boolean search(int column,int row,int index,String word,char[][] board){
        if(index==word.length())
            return true;

        if(column-1>=0&&board[row][column-1]==word.charAt(index)){
            char[][] temp=arrayCopy(board);
            temp[row][column-1]='0';
            if(search(column-1,row,index+1,word,temp))
                return true;
        }
        if(row-1>=0&&board[row-1][column]==word.charAt(index)){
            char[][] temp=arrayCopy(board);
            temp[row-1][column]='0';
            if(search(column,row-1,index+1,word,temp))
                return true;
        }
        if(column+1<board[0].length&&board[row][column+1]==word.charAt(index)){
            char[][] temp=arrayCopy(board);
            temp[row][column+1]='0';
            if(search(column+1,row,index+1,word,temp))
                return true;
        }
        if(row+1<board.length&&board[row+1][column]==word.charAt(index)){
            char[][] temp=arrayCopy(board);
            temp[row+1][column]='0';
            if(search(column,row+1,index+1,word,temp))
                return true;
        }
        return false;
    }
    public static char[][] arrayCopy(char[][] old){
        char[][] ne=new char[old.length][old[0].length];

        for(int i=0;i<old[0].length;++i) {
            for (int j = 0; j < old.length; ++j)
                ne[j][i] = old[j][i];
        }
            return ne;
    }
}
