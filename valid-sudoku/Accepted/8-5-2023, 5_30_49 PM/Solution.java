// https://leetcode.com/problems/valid-sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //3 = row, col, box
        //row,col,box number
        //value
        int[][][] found = new int[3][9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int val = board[i][j]-'0'-1;
                if(val == -3)
                    continue;
                int box = (i/3)*3 + j/3;
                //System.out.println("i = "+i+" j = "+j+"Box = "+box);
                if(found[0][i][val]!=0){ //|| found[1][j][val]!=0 || found[2][box][val]!=0){
                    return false;
                }
                if(found[1][j][val]!=0){
                    return false;
                }
                if(found[2][box][val]!=0){
                    return false;
                }
                found[0][i][val]=1;
                found[1][j][val]=1;
                found[2][box][val]=1;
            }
        }
        return true;
    }
}