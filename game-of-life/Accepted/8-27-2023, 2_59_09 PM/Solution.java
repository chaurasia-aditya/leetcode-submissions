// https://leetcode.com/problems/game-of-life

class Solution {
    int m,n;
    public int count(int[][] a, int i, int j){
        int cur = 0;
        //up
        if(i>0){
            if(a[i-1][j] == 1)
                cur++;
            if(j<n-1 && a[i-1][j+1] == 1){
                    cur++;
            }
            if(j>0){
                if(a[i-1][j-1] == 1)
                    cur++;
            }
        }
        if(i<m-1){
            if(a[i+1][j] == 1)
                cur++;
            if(j<n-1){
                if(a[i+1][j+1] == 1)
                    cur++;
            }
            if(j>0 && a[i+1][j-1] == 1){
                    cur++;
            }   
        }
        if(j<n-1 && a[i][j+1] == 1){
            cur++;
        }
        if(j>0 && a[i][j-1] == 1){
            cur++;
        }
        return cur;
    }
    public void gameOfLife(int[][] board) {
        ArrayList<Pair<Integer, Integer>> change = new ArrayList<>();
        m = board.length;
        n = board[0].length;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int c = count(board,i,j);
                // System.out.print("i="+i+" j="+j+" c = "+c);
                if(board[i][j] == 0 && c==3){
                    change.add(new Pair(i,j));
                    // System.out.println(" switch 1!");
                }else if(board[i][j] ==1 && (c<2 || c>3)){
                    change.add(new Pair(i,j));
                    // System.out.println(" switch!");
                }
            }
        }

        for(Pair x:change){
            int i = (Integer)x.getKey();
            int j = (Integer)x.getValue();

            board[i][j] ^=1;
            // if(board[i][j] == 1){
            //     board[i][j] = 0;
            // }else{
            //     board[i][j] = 1;
            // }
        }    
    }
}