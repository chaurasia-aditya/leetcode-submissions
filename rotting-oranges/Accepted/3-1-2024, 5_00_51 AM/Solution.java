// https://leetcode.com/problems/rotting-oranges

class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // cost = new int[m][n];

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j] == 2){
        //             continue;
        //         }
        //         cost[i][j] = Integer.MAX_VALUE;
        //     }
        // }

        Queue<Pair> rotten = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) 
                    rotten.add(new Pair(i,j));
            }
        }

        while(!rotten.isEmpty()){
            int round = rotten.size();
            boolean change = false;
            while(round-->0){
                Pair cur = rotten.poll();
                int r=cur.r, c=cur.c;

                if(r>0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    rotten.add(new Pair(r-1,c));
                    change = true;
                }
                if(r<m-1 && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    rotten.add(new Pair(r+1,c));
                    change = true;
                }
                if(c>0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    rotten.add(new Pair(r,c-1));
                    change = true;
                }
                if(c<n-1 && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    rotten.add(new Pair(r,c+1));
                    change = true;
                }
            }
            if(change){
                res++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return res;
    }
}