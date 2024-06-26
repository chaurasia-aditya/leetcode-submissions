// https://leetcode.com/problems/merge-intervals

class Solution {
    void mergearr(int arr[][], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[][] = new int[n1][2];
        int R[][] = new int[n2][2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] < R[j][0]) {
                arr[k] = L[i];
                i++;
            }
            else if(L[i][0] == R[j][0] && L[i][1]<R[j][1]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[][], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            mergearr(arr, l, m, r);
        }
    }
    public int[][] merge(int[][] intervals) {
        int r = intervals.length;
        sort(intervals, 0, r-1);

        // int[][] res=new int[r][2];
        List<List<Integer>> ans = new ArrayList<>();

        int cur_min = intervals[0][0], cur_max = intervals[0][1];
        int index = 0;
        for(int i=1;i<r;i++){
            if(cur_max>=intervals[i][0]/* && cur_max<=intervals[i][1]*/){
                cur_max = Math.max(cur_max, intervals[i][1]);
            }else{
                ans.add(Arrays.asList(cur_min, cur_max));
                // res[index][0] = cur_min;
                // res[index][1] = cur_max;
                // index++;
                cur_min = intervals[i][0];
                cur_max = intervals[i][1];
            }
        }
        ans.add(Arrays.asList(cur_min, cur_max));
        // res[index][0] = cur_min;
        // res[index][1] = cur_max;
        int[][] res = ans.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        return res;
    }
}