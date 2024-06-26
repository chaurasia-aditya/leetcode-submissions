// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            
            switch(ch){
                case 'I':{
                    res++;
                    break;
                }
                case 'V':{
                    res+=5;
                    if(i>0 && s.charAt(i-1) == 'I')
                        res-=2;
                    break;
                }
                case 'X':{
                    res+=10;
                    if(i>0 && s.charAt(i-1) == 'I')
                        res-=2;
                    break;
                }
                case 'L':{
                    res+=50;
                    if(i>0 && s.charAt(i-1) == 'X')
                        res-=20;
                    break;
                }
                case 'C':{
                    res+=100;
                    if(i>0 && s.charAt(i-1) == 'X')
                        res-=20;
                    break;
                }
                case 'D':{
                    res+=500;
                    if(i>0 && s.charAt(i-1) == 'C')
                        res-=200;
                    break;
                }
                case 'M':{
                    res+=1000;
                    if(i>0 && s.charAt(i-1) == 'C')
                        res-=200;
                    break;
                }
            }
        }
        return res;
    }
}