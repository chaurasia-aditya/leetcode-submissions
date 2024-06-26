// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();
        // int b_min = Integer.MAX_VALUE, b_max = Integer.MIN_VALUE;
        int index = 0;
        while(index != -1){
            index = s.indexOf(a, index);
            if (index != -1) {
                alist.add(index);
                index++;
            }
        }
        
        index = 0;
        
        while(index != -1){
            index = s.indexOf(b, index);
            if (index != -1) {
                blist.add(index);
                index++;
            }
        }
        
        if(alist.size()==0 || blist.size()==0){
            return new ArrayList<Integer>();
        }
        
        
//         List<Integer> res = new ArrayList<>();
        
//         for(int i=0, j=0;i<alist.size();i++){
//             if(Math.abs(alist.get(i) - blist.get(j))<=k){
//                 res.add(alist.get(i));
//             }else if()
//         }
        
        List<Integer> res = alist.stream()
                .filter(i -> blist.stream().anyMatch(j -> Math.abs(j - i) <= k))
                .collect(Collectors.toList());
        
        return res;
        
    }
}