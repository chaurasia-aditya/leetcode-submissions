// https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment

class Solution {
    public int isPossible(int num, int div){
        int rem = num%div; // c-a
        int q = num/div; // a+b+c
        
        for(int i=0;div*i<=num;i++){
            if((num-i*div)%(div+1) == 0){
                return i+(num-i*div)/(div+1);
            }
        }
        if(num%div == 0){
            return num/div;
        }
        return -1;
    }
    private int canDivide(int n, int i) {
        // Can divide int i and i + 1, which is prioritized.
        int j = i + 1;
        for (int x = 0; x * i <= n; x++) {
            if ((n - x * i) % j == 0) {
                return x + (n - x * i) / j;
            }
        }
        
        // Can divide just by i.
        if (n % i == 0) return n / i;

        return -1;
    }
    public int gcd(int a, int b)  
    {  
     return b == 0? a:gcd(b,a%b);     
    }
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] count = new int[nums.length];
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int idx = hm.getOrDefault(nums[i],-1);
            if(idx == -1){
                hm.put(nums[i],index);
                count[index]=1;
                // idx = index;
                index++;
            }else{
                count[idx]++;
            }
            // max = Math.max(max, count[idx]);
        }
        for(int i=0;i<index;i++){
            min = Math.min(count[i], min);
        }
        
        int low = 1, high = min;
        int total;
        for(int i = min;i>=1;i--){
            total = 0;
            for(int j=0;j<nums.length;j++){
                int val = isPossible(count[j], i);
                if(val == -1){
                    total = -1;
                    break;
                }else{
                    total+=val;
                }
            }
            if(total!=-1){
                return total;
            }
        }
        return -1;
    }
}