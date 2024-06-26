// https://leetcode.com/problems/open-the-lock

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs  = new HashSet<>();
        for(String s:deadends)
            hs.add(s);

        if(hs.contains("0000"))
            return -1;

        HashSet<String> visited  = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add("0000");
        visited.add("0000");
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String s = q.poll();
                visited.add(s);
                if(target.equals(s))
                    return count;
                
                char[] cur = s.toCharArray();

                for(int i=0;i<4;i++){
                    char og = cur[i];

                    cur[i] = (char)(((og-'0'+1))%10+'0');
                    String str = new String(cur);

                    if(!hs.contains(str) && visited.add(str))
                        q.offer(str);
                    
                    cur[i] = og;
                    
                    cur[i] = (char) ((og - '0' + 9) % 10 + '0');
                    str = new String(cur);

                    if(!hs.contains(str) && visited.add(str))
                        q.offer(str);

                    cur[i] = og;
                }
            }
            count++;
        }

        return -1;
    }
}