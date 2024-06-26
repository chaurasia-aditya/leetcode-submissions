// https://leetcode.com/problems/surrounded-regions

class Solution {
    void dfs(int i, int j, char[][] board, int m, int n){
        if(i<0||j<0||i==m||j==n|| board[i][j] == 'X' || board[i][j] == '1')
            return;
        if(board[i][j] == 'O')
            board[i][j] = '1';

        dfs(i-1, j, board, m, n);
        dfs(i+1, j, board, m, n);
        dfs(i, j-1, board, m, n);
        dfs(i, j+1, board, m, n);        
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, m, n);
            }
            if(board[i][n-1] == 'O'){
                dfs(i, n-1, board, m, n);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board, m, n);
            }
            if(board[m-1][j] == 'O'){
                dfs(m-1, j, board, m, n);
            }
        }

        // for(int i=0;i<m;i++){
        //     for(int j=0; j<n;j++){
        //         if((i==0||j==0||i==m-1||j==n-1) && board[i][j] == 'O'){
        //             dfs(i, j, board, m, n);
        //         }
        //     }
        // }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '1')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}