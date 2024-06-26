// https://leetcode.com/problems/car-fleet

class Solution {
    class cars implements Comparable<cars>{
        public int pos, speed;

        cars(int p, int s){
            pos = p;
            speed = s;
        }

        public int compareTo(cars y){
            return this.pos-y.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        cars arr[] = new cars[n];

        for(int i=0;i<n;i++){
            arr[i] = new cars(position[i], speed[i]);
        }

        Arrays.sort(arr);

        Stack<Float> st = new Stack<>();
        for(cars car:arr){
            float timeNeeded = (target-car.pos)/(float)car.speed;
            while(!st.isEmpty() && timeNeeded>=st.peek()){
                st.pop();
            }
            st.push(timeNeeded);
        }

        return st.size();
    }
}