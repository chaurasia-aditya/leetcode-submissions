// https://leetcode.com/problems/detect-squares

class DetectSquares {
    List<int[]> points;
    Map<String, Integer> count;

    public DetectSquares() {
        points = new ArrayList<>();
        count = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String val = point[0]+","+point[1];
        count.put(val, count.getOrDefault(val, 0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];

        for(int[] p:points){
            int cur_x = p[0], cur_y = p[1];
            if(cur_x == x || cur_y == y || (Math.abs(cur_x-x)!=Math.abs(cur_y-y)))
                continue;
            res+= count.getOrDefault(cur_x + "," + y, 0) * count.getOrDefault(x + "," + cur_y, 0);
        }

        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */