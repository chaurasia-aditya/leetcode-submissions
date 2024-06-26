// https://leetcode.com/problems/magnetic-force-between-two-balls

class Solution {
    boolean check(int[] arr, int n, int m, int d){
        int st = arr[0];
        m--;
        for(int i=1;i<n;i++){
            if(arr[i] - st >= d){
                m--;
                st = arr[i];
            }
            if(m==0)
                return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low = 1, high = (position[n-1]-position[0])/(m-1);
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(position, n, m, mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low-1;
    }
}