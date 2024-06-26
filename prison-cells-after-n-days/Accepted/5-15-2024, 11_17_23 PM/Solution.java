// https://leetcode.com/problems/prison-cells-after-n-days

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        List<int[]> al = new LinkedList<>();
        int[] temp = new int[8];
        int[] first = new int[8];
        while(n-->0){
            for(int i=1;i<7;i++){
                temp[i] = (cells[i-1]==cells[i+1]?1:0);
            }
            cells = temp.clone();
            if(al.size() == 0){
                first = temp.clone();
            } else if(Arrays.equals(cells, first)){
                return al.get(n%al.size());
            }
            al.add(temp.clone());
        }
        return cells;
    }
}