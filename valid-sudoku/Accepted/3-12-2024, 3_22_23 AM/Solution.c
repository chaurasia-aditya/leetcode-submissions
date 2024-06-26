// https://leetcode.com/problems/valid-sudoku

bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    bool present[3][9][9];

    memset(present, false, sizeof(present));

    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j] == '.')
                continue;
            int value = board[i][j]-'1';
            int box = (i/3)*3+j/3;

            if(present[0][i][value] || present[1][j][value] || present[2][box][value])
                return false;

            present[0][i][value] = true;
            present[1][j][value] = true;
            present[2][box][value] = true;
        }
    }
    return true;
}