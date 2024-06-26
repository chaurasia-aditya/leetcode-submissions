// https://leetcode.com/problems/triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());

        dp.get(0).add(triangle.get(0).get(0));

        for(int i=1; i<triangle.size();i++){
            int size = i+1;

            List<Integer> cur = triangle.get(i);
            List<Integer> prev = dp.get(i-1);
            List<Integer> list = new ArrayList<>();

            for(int j=0;j<size;j++){
                int min = Integer.MAX_VALUE;
                if(j!=0){
                    min = Math.min(min, prev.get(j-1)+cur.get(j));
                }
                if(j!=size-1){
                    min = Math.min(min, prev.get(j)+cur.get(j));
                }
                list.add(min);
            }
            dp.add(list);
        }

        int res = Integer.MAX_VALUE;

        for(Integer x:dp.get(triangle.size()-1)){
            res = Math.min(res, x);
        }

        return res;
    }
}