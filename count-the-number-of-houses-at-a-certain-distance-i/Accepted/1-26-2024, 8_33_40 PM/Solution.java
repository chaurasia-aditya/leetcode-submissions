// https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] dist = new int[n][n];
        int[] count = new int[n];
        
        boolean same = false;
        
        if(x==y)
            same = true;
        
        // count[0] = n-1;
        // if(!same && Math.abs(x-y)!=1){
        //     count[0]++;
        // }
        
        dist[x-1][y-1] = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i){
                    continue;
                }
                dist[i][j] = Math.min(Math.abs(i-j), Math.min(Math.abs(i-(x-1))+1+Math.abs((y-1)-j), Math.abs(i-(y-1))+1+Math.abs((x-1)-j)));
                count[dist[i][j]-1]++; 
                // System.out.println(i+","+j+" ="+dist[i][j]);
            }
        }
        return count;    
    }
}