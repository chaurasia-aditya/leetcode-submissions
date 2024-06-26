// https://leetcode.com/problems/find-the-grid-of-region-average

class Solution {
    public int[][] resultGrid(int[][] nums, int threshold) {
        // System.out.println("New");
        int m = nums.length;
        int n = nums[0].length;
        int[][] regions = new int[m][n];
        int[][] res = new int[m][n];
        int[][] count = new int[m][n];
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                int center = nums[i][j];
                
                boolean topleft = ((Math.abs(nums[i-1][j-1] - nums[i-1][j])<=threshold) && (Math.abs(nums[i-1][j-1] - nums[i][j-1])<=threshold));
                
                boolean topright = ((Math.abs(nums[i-1][j+1] - nums[i-1][j])<=threshold) && (Math.abs(nums[i-1][j+1] - nums[i][j+1])<=threshold));
                boolean bottomleft = ((Math.abs(nums[i+1][j-1] - nums[i+1][j])<=threshold) && (Math.abs(nums[i+1][j-1] - nums[i][j-1])<=threshold));
                boolean bottomright = ((Math.abs(nums[i+1][j+1] - nums[i+1][j])<=threshold) && (Math.abs(nums[i+1][j+1] - nums[i][j+1])<=threshold));
                
                int one = Math.abs(center - nums[i-1][j-1]);
                int two = Math.abs(center - nums[i-1][j]);
                int thr = Math.abs(center - nums[i-1][j+1]);
                int fou = Math.abs(center - nums[i][j-1]);
                int fiv = Math.abs(center - nums[i][j+1]);
                int six = Math.abs(center - nums[i+1][j-1]);
                int sev = Math.abs(center - nums[i+1][j]);
                int eig = Math.abs(center - nums[i+1][j+1]);
                
                
                if(two<=threshold && fou<=threshold && fiv<=threshold && sev<=threshold && topleft && bottomleft && topright && bottomright/*(one+thr+six+sev)<=(8*threshold)*/){
                    // System.out.println("i="+i+" j ="+j);
                    regions[i][j] = (nums[i-1][j-1] + nums[i-1][j]+ nums[i-1][j+1]+nums[i][j-1]+nums[i][j]+nums[i][j+1]+nums[i+1][j-1]+nums[i+1][j]+nums[i+1][j+1])/9;
                    
                    // res[i-1][j-1] = (res[i-1][j-1] * count[i-1][j-1] + regions[i][j])/(++count[i-1][j-1]);
                    // res[i-1][j] = (res[i-1][j] * count[i-1][j] + regions[i][j])/(++count[i-1][j]);
                    // res[i-1][j+1] = (res[i-1][j+1] * count[i-1][j+1] + regions[i][j])/(++count[i-1][j+1]);
                    // res[i][j-1] = (res[i][j-1] * count[i][j-1] + regions[i][j])/(++count[i][j-1]);
                    // res[i][j] = (res[i][j] * count[i][j] + regions[i][j])/(++count[i][j]);
                    // res[i][j+1] = (res[i][j+1] * count[i][j+1] + regions[i][j])/(++count[i][j+1]);
                    // res[i+1][j-1] = (res[i+1][j-1] * count[i+1][j-1] + regions[i][j])/(++count[i+1][j-1]);
                    // res[i+1][j] = (res[i+1][j] * count[i+1][j] + regions[i][j])/(++count[i+1][j]);
                    // res[i+1][j+1] = (res[i+1][j+1] * count[i+1][j+1] + regions[i][j])/(++count[i+1][j+1]);   
                    
                    ++count[i-1][j-1];
                    ++count[i-1][j];
                    ++count[i-1][j+1];
                    ++count[i][j-1];
                    ++count[i][j];
                    ++count[i][j+1];
                    ++count[i+1][j-1];
                    ++count[i+1][j];
                    ++count[i+1][j+1];
                    
                    // for(int k=0;k<m;k++){
                    //     for(int l=0;l<n;l++){
                    //         System.out.print(res[k][l]+" ");
                    //     }
                    //     System.out.println();
                    // }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j] == 0){
                    res[i][j] = nums[i][j];
                    continue;
                }
                
                res[i][j]+=regions[i][j];                
                if(i>0){
                    res[i][j] += regions[i-1][j];
                    if(j>0){
                        res[i][j]+=regions[i][j-1];
                        res[i][j] += regions[i-1][j-1];
                    }
                    if(j<n-1){
                        res[i][j]+=regions[i-1][j+1];
                        res[i][j]+=regions[i][j+1];
                    }
                }
                if(i<m-1){
                    res[i][j] += regions[i+1][j];
                    if(j>0){
                        res[i][j]+=regions[i+1][j-1];
                    }
                    if(j<n-1){
                        res[i][j]+=regions[i+1][j+1];
                    }
                }
                
                res[i][j]/=count[i][j];
            }
        }
        
        return res;
    }
}