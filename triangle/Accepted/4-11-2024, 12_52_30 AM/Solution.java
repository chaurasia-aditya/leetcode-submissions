// https://leetcode.com/problems/triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.get(0);

        for(int i=1; i<triangle.size();i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                int min = Integer.MAX_VALUE;
                int cur = triangle.get(i).get(j);
                if(j!=0){
                    min = Math.min(min, prev.get(j-1)+cur);
                }
                if(j!=i){
                    min = Math.min(min, prev.get(j)+cur);
                }
                list.add(min);
            }
            prev = list;
        }

        int res = Integer.MAX_VALUE;

        for(Integer x: prev){
            res = Math.min(res, x);
        }

        return res;
    }
}