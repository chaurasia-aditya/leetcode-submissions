// https://leetcode.com/problems/long-pressed-name

class Solution {
    public boolean isLongPressedName(String name, String typed) {      
        if(name.length()>typed.length())
            return false;
        
        int i=0, j=0;
        for(;i<typed.length() && j<name.length();){
            if(typed.charAt(i)!=name.charAt(j)){
                if(i!=0 && typed.charAt(i) == typed.charAt(i-1)){
                    while(i<typed.length() && typed.charAt(i) == typed.charAt(i-1))
                        i++;
                }else{
                    return false;
                }
            }else{
                i++;
                j++;
            }
        }
        
        if(j<name.length())
            return false;
    
        if(j == name.length() && i!=typed.length()){
            while(i<typed.length() && typed.charAt(i) == typed.charAt(i-1))
                i++;
            if(i < typed.length())
                return false;
        }
        return true;
    }
}