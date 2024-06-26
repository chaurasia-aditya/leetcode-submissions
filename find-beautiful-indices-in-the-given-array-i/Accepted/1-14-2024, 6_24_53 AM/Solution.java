// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();
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
        
        
        List<Integer> res = new ArrayList<>();
        System.out.println(alist);
        System.out.println(blist);
        
        for(int i=0, j=0;i<alist.size();i++){
            int ai = alist.get(i);
             
            // if(Math.abs(alist.get(i) - blist.get(j))<=k){
            //     res.add(alist.get(i));
            // }else if()
            int small = Collections.binarySearch(blist, ai-k);
            int large = Collections.binarySearch(blist, ai+k);

            // if(small>0||large>0){
            //     res.add(ai);
            //     continue;
            // }

            if(small<0){
                small = -small-1;
                if(small==blist.size()){
                    small--;
                }
            }
            if(large<0){
                large = -large-1;
                if(large == blist.size()){
                    large--;
                }
            }
            System.out.println("small ="+small+" large="+large);
            if(large!=small){
                res.add(ai);
            }else if(Math.abs(blist.get(small)-ai)<=k || Math.abs(blist.get(large)-ai)<=k){
                res.add(ai);
            }
        }

        
        // List<Integer> res = alist.stream()
        //         .filter(i -> blist.stream().anyMatch(j -> Math.abs(j - i) <= k))
        //         .collect(Collectors.toList());
        
        return res;
        
    }
}