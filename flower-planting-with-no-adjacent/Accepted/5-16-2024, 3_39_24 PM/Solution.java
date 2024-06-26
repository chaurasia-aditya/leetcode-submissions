// https://leetcode.com/problems/flower-planting-with-no-adjacent

class Solution {
    
    boolean isSafe(int node, int c, List<Integer> list, int[] colour){
        for(int i:list){
            if (colour[i]==c)
                return false;
        }
        return true;
    }
    
    boolean colouring(int node, int n, List<List<Integer>> grid, int[] colour){
        if(node == n)
            return true;
        
        for (int c = 1; c <= 4; c++) {
            if (isSafe(node, c, grid.get(node), colour)) {
                colour[node] = c;
                if (colouring(node+1, n, grid, colour))
                    return true;
                colour[node] = 0;
            }
        }

        return false;
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] colour = new int[n];
        
        List<List<Integer>> grid = new ArrayList<>();
        for(int i=0;i<n;i++)
            grid.add(new ArrayList<>());
        for(int i=0;i<paths.length;i++){
            grid.get(paths[i][0]-1).add(paths[i][1]-1);
            grid.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        
        colouring(0, n, grid, colour);
        
        return colour;
    }
}