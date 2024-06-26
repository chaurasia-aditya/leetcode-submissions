// https://leetcode.com/problems/sequential-digits

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> nums = new ArrayList<>();

        int start = 0, max=0, delta = 0, mod = 0;
        for(int i=1;i<=9;i++){
            start = 0;
            max = 0;
            delta = 0;
            for(int j=0;j<=i;j++){
                start = start*10+(j+1);
            }

            for(int j=0;j<=i;j++){
                max = max*10+9;
            }

            for(int j=0;j<=i;j++){
                delta = delta*10+1;
            }

            mod = (int)Math.pow(10, i);

            // System.out.print(delta+" ");

            while(start<=max){
                nums.add(start);
                start+=delta;
                if(start/mod > (9-i))
                    break;
            }

            if(max>high)
                break;
        }

        List<Integer> res = new ArrayList<>();

        for(Integer i:nums){
            if(i>high)
                break;
            if(i<low)
                continue;
            res.add(i);
        }

        return res;
    }
}