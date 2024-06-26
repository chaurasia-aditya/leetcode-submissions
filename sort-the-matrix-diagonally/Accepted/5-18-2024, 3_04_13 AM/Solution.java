// https://leetcode.com/problems/sort-the-matrix-diagonally

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        ArrayList<Integer> cur;
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        
        for(int i=0;i<m;i++){
            int k=i, j = 0;
            cur = new ArrayList<>();
            while(k<m && j<n){
                cur.add(mat[k][j]);
                k++;
                j++;
            }
            Collections.sort(cur);
            
            k=i; 
            j=0;
            
            while(j!=cur.size()){
                res[k][j] = cur.get(j);
                k++;
                j++;
            }
        }
        
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i=1;i<n;i++){
            int k=0, j = i;
            cur = new ArrayList<>();
            while(k<m && j<n){
                cur.add(mat[k][j]);
                k++;
                j++;
            }
            Collections.sort(cur);
            
            k=0; 
            j=i;
            
            while(k!=cur.size()){
                res[k][j] = cur.get(k);
                k++;
                j++;
            }
        }
        
        return res;
    }
}