// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars

class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int pos;
        
        public Pair(char c, int p){
            ch = c;
            pos = p;
        }
            
        public int compareTo(Pair b){
            if(ch!=b.ch){
                return ch-b.ch;
            }else{
                return b.pos-pos;
            }
        }
            
    }
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue();
        ArrayList<Integer> toDelete = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // int i = 0;
        for(char ch:s.toCharArray()){
            if(ch == '*'){
                Pair p = pq.poll();
                // sb.deleteCharAt(p.pos);
                toDelete.add(p.pos);
            }else{
                sb.append(ch);
                pq.add(new Pair(ch, sb.length()-1));
            }
            // i++;
        }
        
        Collections.sort(toDelete);
        
        for(int i=toDelete.size()-1;i>=0;i--){
            sb.deleteCharAt(toDelete.get(i));
        }

        return sb.toString();
    }
}