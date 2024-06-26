// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //3 = row, col, box
        //row,col,box number
        //value
        // int[][][] found = new int[3][9][9];

        // for(int i=0;i<9;i++){
        //     for(int j=0;j<9;j++){
        //         int val = board[i][j]-'0'-1;
        //         if(val == -3)
        //             continue;
        //         int box = (i/3)*3 + j/3;
        //         if(found[0][i][val]!=0 || found[1][j][val]!=0 || found[2][box][val]!=0){
        //             return false;
        //         }
        //         found[0][i][val]=1;
        //         found[1][j][val]=1;
        //         found[2][box][val]=1;
        //     }
        // }
        // return true;
        boolean [][][] present = new boolean[3][9][9];//row, col, box
        int box, num;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                box = (i/3)*3+(j/3);
                if(board[i][j] == '.')
                    continue;
                num = board[i][j] - '0' - 1;
                // System.out.println("num = "+num+" val="+board[i][j]);
                if(present[0][i][num] || present [1][j][num] || present[2][box][num]){
                    return false;
                }
                present[0][i][num] = true;
                present[1][j][num] = true;
                present[2][box][num] = true;
            }
        }
        return true;
    }
}