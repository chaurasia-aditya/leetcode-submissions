// https://leetcode.com/problems/rotting-oranges

class Solution {
    class Pair{
        int r, c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair> rotten = new LinkedList<>();
        
        int res = 0, countOne = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    rotten.add(new Pair(i, j));
                }else if(grid[i][j] == 1)
                    countOne++;
            }
        }
        
        while(!rotten.isEmpty()){
            int size = rotten.size();
            boolean change = false;
            
            for(int i=0;i<size;i++){
                Pair cur = rotten.poll();
                
                int r = cur.r;
                int c = cur.c;
                
                if(r>0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    rotten.add(new Pair(r-1, c));
                    countOne--;
                    change = true;
                }
                
                if(c>0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    rotten.add(new Pair(r, c-1));
                    countOne--;
                    change = true;
                }
                
                if(r<m-1 && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    rotten.add(new Pair(r+1, c));
                    countOne--;
                    change = true;
                }
                
                if(c<n-1 && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    rotten.add(new Pair(r, c+1));
                    countOne--;
                    change = true;
                } 
            }
            if(change)
                res++;
        }
        
        return countOne == 0?res:-1;
    }
}