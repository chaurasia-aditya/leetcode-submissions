// https://leetcode.com/problems/most-frequent-prime

class Solution {
    int max = 999999;
//     void sieveOfEratosthenes(int n)
//     {
//         boolean prime[] = new boolean[n + 1];
//         for (int i = 0; i <= n; i++)
//             prime[i] = true;
 
//         for (int p = 2; p * p <= n; p++) {
//             if (prime[p] == true) {
//                 for (int i = p * p; i <= n; i += p)
//                     prime[i] = false;
//             }
//         }
 
//         // Print all prime numbers
//         for (int i = 2; i <= n; i++) {
//             if (prime[i] == true)
//                 System.out.print(i + " ");
//         }
//     }
    public int mostFrequentPrime(int[][] mat) {
        boolean prime[] = new boolean[max + 1];
        int count[] = new int[max+1];
        for (int i = 0; i <= max; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= max; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= max; i += p)
                    prime[i] = false;
            }
        }
        
        int m = mat.length;
        int n = mat[0].length;
        
        int res = -1;
        int c = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // System.out.print("i= "+i+" j= "+j);
                int cur = mat[i][j];
                
                // if(prime[cur]){
                //     count[cur]++;
                //     if(count[cur]>c || (count[cur]==c && cur>res)){
                //         res = cur;
                //         c = count[cur];
                //     }
                // }
                
                //east
                int k = j+1;
                while(k<n){
                    cur = cur*10+mat[i][k];
                    // if(prime[cur] && cur>res){
                    //     // System.out.print("i= "+i+" j= "+j);
                    //     res = cur;
                    // }
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k++;
                }
                
                //south-east
                cur = mat[i][j];
                k = i+1;
                int l = j+1;
                
                while(k<m && l<n){
                    cur = cur*10+mat[k][l];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k++;
                    l++;
                }
                
                //south
                cur = mat[i][j];
                k = i+1;
                while(k<m){
                    cur = cur*10+mat[k][j];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k++;
                }
                
                //south-west 
                cur = mat[i][j];
                
                k = i+1;
                l = j-1;
                
                while(k<m && l>=0){
                    cur = cur*10+mat[k][l];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k++;
                    l--;
                }
                
                //west
                cur = mat[i][j];
                k = j-1;
                while(k>=0){
                    cur = cur*10+mat[i][k];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k--;
                }
                
                //north-west
                cur = mat[i][j];
                k = i-1;
                l = j-1;
                
                while(k>=0 && l>=0){
                    cur = cur*10+mat[k][l];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k--;
                    l--;
                }
                
                //north
                cur = mat[i][j];
                k = i-1;
                while(k>=0){
                    cur = cur*10+mat[k][j];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k--;
                }
                
                //north-east
                cur = mat[i][j];
                k = i-1;
                l = j+1;
                
                while(k>=0 && l<n){
                    cur = cur*10+mat[k][l];
                    if(cur>10 && prime[cur]){
                        count[cur]++;
                        if(count[cur]>c || (count[cur]==c && cur>res)){
                            res = cur;
                            c = count[cur];
                        }
                    }
                    k--;
                    l++;
                }
            }
        }
        return res;
    }
}