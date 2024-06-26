// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field

class Solution {
    int MOD = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int max_area = -1;
        if(m==n){
            return ((m-1)*(n-1))%MOD;
        }
        
        int l1 = hFences.length;
        int l2 = vFences.length;
        
        int[] h = Arrays.copyOf(hFences, l1 + 2);
        h[l1] = 1;
        h[l1+1] = m;
        
        int[] v = Arrays.copyOf(vFences, l2 + 2);
        v[l2] = 1;
        v[l2+1] = n;
        
        Arrays.sort(h);
        Arrays.sort(v);
        
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<h.length-1;i++){
            for(int j=i+1;j<h.length;j++){
                hs.add(h[j]-h[i]);
            }
        }
        
        Set<Integer> vs = new HashSet<>();
        for(int i=0;i<v.length-1;i++){
            for(int j=i+1;j<v.length;j++){
                if(hs.contains(v[j]-v[i])){
                    max_area = Math.max(max_area, v[j]-v[i]);
                }
            }
        }
        
        if(max_area == -1){
            return -1;
        }
        
        return (int) ((1L * max_area * max_area) % MOD);
    }
}