// https://leetcode.com/problems/distribute-candies

class Solution {
    public int distributeCandies(int[] candyType) {
        int count = candyType.length/2;
        Set<Integer> hs = new HashSet<>();
        
        for(int i:candyType)
            hs.add(i);
        
        return (count<hs.size()?count:hs.size());
    }
}