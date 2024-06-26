// https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        
        
        for(int i=1;i<=1000;i++){
            for(int j=1;j<1000;j++){
                int f=customfunction.f(i,j); 
                if(f==z){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
                if(f>z)
                    break;
            }
        }
        
        return res;
    }
}