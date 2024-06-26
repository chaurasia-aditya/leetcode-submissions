// https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                nums[i] = 1;
            }else if(nums[i]>nums[i+1]){
                nums[i] = 2;
            }else{
                nums[i] = 0;
            }
            s.append(nums[i]);
        }
        s.append(3);
        
        int res = 0;
        
        for(int i=0;i<pattern.length;i++){
            if(pattern[i] == -1)
                pattern[i] = 2;
            p.append(pattern[i]);
        
        }
        // p.append(".");
        
        String str = s.toString();
        String pat = p.toString(); 
        
        System.out.println(str);
        System.out.println(pat);
        
        // Pattern patt = Pattern.compile(pat);
        // Matcher matcher = patt.matcher(str);
        
        // while (matcher.find()) {
        //     res++;
        // }
        
        int lastIndex = 0;
        
        while (lastIndex != -1 && lastIndex+pat.length()!=str.length()) {
            
            lastIndex = str.indexOf(pat, lastIndex);

            if (lastIndex != -1 && lastIndex+pat.length()!=str.length()) {
                System.out.print(lastIndex+" ");
                res++;
                lastIndex++;
            }
        }
        System.out.println();
        
        return res;
    }
}