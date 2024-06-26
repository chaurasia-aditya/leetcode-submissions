// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets

class Solution {
    boolean check(int[] arr, int n, int m, int k, int days){
        int st = -1;
        for(int i=0;i<n;i++){
            if(arr[i]<=days){
                if(st == -1)
                    st = i;
                if((i-st+1)==k){
                    m--;
                    st = -1;
                }
                if(m <= 0)
                    return true;
            }else{
                if(st!=-1)
                    st = -1;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long)m*k>n)
            return -1;

        int low = 1, high = (int)1e9;

        while(low<high){
            int mid = low+(high-low)/2;

            if(check(bloomDay, n, m, k, mid))
                high = mid;
            else
                low = mid+1;
        }
        
        return low;
    }
}