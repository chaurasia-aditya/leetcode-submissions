// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
//         int max = 0;
//         int f = fruits[0], f_last = 0, f_count = 1;
//         int s = -1, s_last = -1, s_count = 0;;
        
//         for(int i=1;i<fruits.length;i++){
//             // System.out.println("i="+i+" f="+f+" f_last="+f_last+" f_count="+f_count+" s="+s+" s_last="+s_last+" s_count="+s_count+" max ="+max);
//             if(fruits[i] == f){
//                 f_count++;
//                 f_last = i;
//             }else if(fruits[i] == s){
//                 s_count++;
//                 s_last = i;
//             }else if(f == -1){
//                 f = fruits[i];
//                 f_count=1;
//                 f_last = i;
//             } else if(s == -1){
//                 s = fruits[i];
//                 s_count=1;
//                 s_last = i;
//             }else{
//                 max = Math.max(f_count+s_count, max);
//                 if(f_last<s_last){
//                     f = s;
//                     f_last=s_last;
//                 }
//                 f_count = (i-f_last);
//                 s = fruits[i];
//                 s_last = i;
//                 s_count = 1;
//             }
//         }
//         max = Math.max(f_count+s_count, max);
        
//         return max;
        
        int max = 0;
        int curMax = 0;
        int prev = -1;
        int prev2 = -1;
        int prevCount = 0;

        for (int fruit: fruits) {
            if (fruit == prev || fruit == prev2) {
                curMax++;
            } else {
                max = Math.max(max, curMax);
                curMax = prevCount + 1;
            }
            if (fruit == prev) {
                prevCount++;
            } else {
                prevCount = 1;
                prev2 = prev;
                prev = fruit;
            }
        }
        return Math.max(max, curMax);
    }
}