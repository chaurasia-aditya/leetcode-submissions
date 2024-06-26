// https://leetcode.com/problems/word-search

class Solution {
    boolean[][] visited;
    boolean helper(int i, int j, char[][] board, int index, String word){
        if((i<0)|| (i==board.length)|| (j<0)|| (j==board[0].length))
            return false;

        if(index == word.length()-1){
            return true;
        }

        boolean ret = false;

        visited[i][j] = true;

        if(i>0 && !visited[i-1][j] && board[i-1][j] == word.charAt(index+1)){
            ret=ret|helper(i-1,j, board,index+1, word);
        }
        if(i<board.length-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(index+1)){
            ret=ret|helper(i+1,j, board, index+1, word);
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1] == word.charAt(index+1)){
            ret=ret|helper(i,j-1, board,index+1, word);
        }
        if(j<board[0].length-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(index+1)){
            ret=ret|helper(i,j+1, board,index+1, word);
        }

        visited[i][j] = false;
        return ret;
    }
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        boolean ret;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    // System.out.println("i="+i+" j="+j);
                    visited = new boolean[board.length][board[0].length];
                    // visited[i][j] = true;
                    ret = helper(i, j, board, 0, word);//|(helper(i-1, j, board, 1, word))|helper(i, j+1, board, 1, word)|helper(i, j-1, board, 1, word);
                    if(ret == true)
                        return true;
                }
            }
        }
        return false;
    }
}