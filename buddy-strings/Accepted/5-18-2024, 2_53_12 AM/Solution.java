// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        
        int i1 = -1, i2= -1;
        int count = 0;
        int[] counts = new int[26];
        
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            if(s.charAt(i)!=goal.charAt(i)){
                if(count == 0){
                    i1 = i;
                }else if(count == 1){
                    i2 = i;
                    if(!(s.charAt(i1) == goal.charAt(i2) && s.charAt(i2) == goal.charAt(i1))){
                        System.out.println("Here2");
                        return false;
                    }
                }else{
                    System.out.println("Here3");
                    return false;
                }
                count++;
            }
        }
        
        if(count == 1)
            return false;
        if(count == 2)
            return true;
        if(count == 0){
            for(int i:counts){
                if(i>=2)
                    return true;
            }
        }
        return false;
    }
}