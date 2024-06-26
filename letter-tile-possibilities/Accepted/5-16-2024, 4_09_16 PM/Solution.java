// https://leetcode.com/problems/letter-tile-possibilities

class Solution {
    int res = 0;
    void backtrack(int size, int n, char[] s, boolean[] visited){
        if(size == n){
            return;
        }

        for(int i=0;i<n;){
            if(!visited[i]){
                res++;
                visited[i] = true;
                backtrack(size+1, n, s, visited);
                visited[i] = false;
                i++;
                while(i<n && s[i] == s[i-1])
                    i++;
                continue;
            }
            i++;
        }
    }
    public int numTilePossibilities(String tiles) {
        char[] s = tiles.toCharArray();
        int n = s.length;
        Arrays.sort(s);

        boolean[] visited = new boolean[n];
                
        backtrack(0, s.length, s, visited);
        
        return res;
    }
}