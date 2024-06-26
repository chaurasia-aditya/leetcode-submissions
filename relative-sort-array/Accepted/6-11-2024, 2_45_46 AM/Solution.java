// https://leetcode.com/problems/relative-sort-array

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = -1;
        int[] count = new int[1001];
        int[] res = new int[arr1.length];

        for(int a:arr1){
            count[a]++;
            if(a>max)
                max = a;
        }

        int i = 0;
        for(int a:arr2){
            while(count[a]-->0){
                res[i++] = a;
            }
        }

        for(int j=0;j<=max;j++){
            while(count[j]-->0){
                res[i++] = j;
            }
        }

        return res;
    }
}