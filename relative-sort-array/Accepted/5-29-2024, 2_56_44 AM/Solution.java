// https://leetcode.com/problems/relative-sort-array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1= arr1.length;
        int n2 = arr2.length;
        
        int[] count = new int[n2];
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0;i<n2;i++)
            hm.put(arr2[i], i);
        
        int total = 0;
        for(int x:arr1){
            if(hm.containsKey(x)){
                count[hm.get(x)]++;
                total++;
            }
        }
        int i = 0;
        int k = 0;
        
        int[] res = new int[n1];
        
        for(int x:count){
            while(x-->0){
                res[k++] = arr2[i];
            }
            i++;
        }
        
        for(int x:arr1){
            if(!hm.containsKey(x)){
                res[k++] = x;
            }
        }
        
        Arrays.sort(res, total, n1);
        
        return res;
    }
}