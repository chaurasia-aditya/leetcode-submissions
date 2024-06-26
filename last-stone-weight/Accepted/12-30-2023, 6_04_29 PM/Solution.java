// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        int len=stones.length;
        if(len==1){
            return stones[0];
        }
        for(int i=0;i<len-1;i++){
        Arrays.sort(stones);
        int x=len-1;
        int y=len-2;
        
            if(stones[x]==stones[y]){
                stones[x]=0;
                stones[y]=0;
            }else{
                stones[x]=stones[x]-stones[y];
                stones[y]=0;
            }
        }
        return stones[len-1];
    }
}