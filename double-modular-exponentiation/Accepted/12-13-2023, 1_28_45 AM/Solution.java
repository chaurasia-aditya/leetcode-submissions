// https://leetcode.com/problems/double-modular-exponentiation

class Solution {
    public static long powerModulo(long base, long exponent, long modulus) {
        long result = 1;
        // base = base % modulus;  // Take modulo of base to handle large bases

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent / 2;
            base = (base * base) % modulus;
        }

        return result;
    }
    
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new LinkedList<>();
        
        List<List<Integer>> last = new ArrayList<>();
        
        last.add(Arrays.asList(0));
        last.add(Arrays.asList(1));
        last.add(Arrays.asList(2,4,8,6));
        last.add(Arrays.asList(3,9,7,1));
        last.add(Arrays.asList(4,6));
        last.add(Arrays.asList(5));
        last.add(Arrays.asList(6));
        last.add(Arrays.asList(7,9,3,1));
        last.add(Arrays.asList(8,4,2,6));
        last.add(Arrays.asList(9,1));
        
        for(int i=0;i<variables.length;i++){
            int a = variables[i][0]%10;
            // System.out.print(a+" ");
            int x = last.get(a).get((variables[i][1]-1)%last.get(a).size());//a^b%10
            // System.out.print(x+" ");
            
            String c = String.valueOf(variables[i][2]);
            // System.out.print(c+" ");
            
            long m = variables[i][3];
            
            long z = powerModulo(x, variables[i][2], m);

            // System.out.println(z);
            
            if(z == target){
                res.add(i);
            }
        }
        return res;
    }
}