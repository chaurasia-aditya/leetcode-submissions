// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i

class Solution {
    public int maximumLength(String s) {
        Map<Character, ArrayList<Integer>> count = new HashMap<>();
        int cur_len=1;
        char ch;
        ch = s.charAt(0);
        // count.add(new String(ch),1);
        for(int i=1;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur!=ch){
                // System.out.print("i="+i+" ");
                if(count.containsKey(ch)){
                    ArrayList<Integer> a = count.get(ch);
                    // System.out.print("a.size()="+a.size());
                    for(int j=0;j<cur_len;j++){
                        if(j<a.size()){
                            // System.out.println(" Here1");
                            a.set(j, a.get(j)+cur_len-j);
                        }
                        else{
                            // System.out.println("Here2");
                            a.add(cur_len-j);
                        }
                    }
                }else{
                    // System.out.println("Here3");
                    ArrayList<Integer> a = new ArrayList<>();
                    for(int j=0;j<cur_len;j++){
                        a.add(cur_len-j);
                    }
                    count.put(ch, a);
                }
                cur_len = 1;
                ch = cur;
            }else{
                cur_len++;
            }
        }
        
        if(count.containsKey(ch)){
            ArrayList<Integer> a = count.get(ch);
            for(int j=0;j<cur_len;j++){
                if(j<a.size())
                    a.set(j, a.get(j)+cur_len-j);
                else
                    a.add(cur_len-j);
            }
        }else{
            ArrayList<Integer> a = new ArrayList<>();
            for(int j=0;j<cur_len;j++){
                a.add(cur_len-j);
            }
            count.put(ch, a);
        }
        
        
        // for (Map.Entry<Character, ArrayList<Integer>> entry : count.entrySet()) {
        //     Character key = entry.getKey();
        //     ArrayList<Integer> value = entry.getValue();
        //     System.out.println(key+" "+value);
        // }
        
        // int res = -1;
        int max_len = -1;
        for (Map.Entry<Character, ArrayList<Integer>> entry : count.entrySet()) {
            // String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            for(int i=0;i<value.size();i++){
                if(value.get(i)>=3 && i+1>=max_len){
                    max_len = i+1;
                    // res=value.get(i);
                }
            }
        }
        return max_len;
    }
}