// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        char[] store = new char[]{'I','V','X','L','C','D','M'};
        while(num>0){
            arr.add(num%10);
            num/=10;
        }
        for(int i = arr.size()-1;i>=0;i--){
            int cur = arr.get(i);
            switch(i){
                case 0:{
                    if(cur == 4){
                        res.append("IV");
                    }else if(cur == 9){
                        res.append("IX");
                    }else if(cur<4){
                        for(int j=0;j<cur;j++){
                            res.append('I');
                        }
                    }else{
                        res.append("V");
                        cur-=5;
                        for(int j=0;j<cur;j++){
                            res.append('I');
                        }
                    }
                    break;
                }
                case 1:{
                    if(cur == 4){
                        res.append("XL");
                    }else if(cur == 9){
                        res.append("XC");
                    }else if(cur<4){
                        for(int j=0;j<cur;j++){
                            res.append('X');
                        }
                    }else{
                        res.append("L");
                        cur-=5;
                        for(int j=0;j<cur;j++){
                            res.append('X');
                        }
                    }
                    break;
                }
                case 2:{
                    if(cur == 4){
                        res.append("CD");
                    }else if(cur == 9){
                        res.append("CM");
                    }else if(cur<4){
                        for(int j=0;j<cur;j++){
                            res.append('C');
                        }
                    }else{
                        res.append("D");
                        cur-=5;
                        for(int j=0;j<cur;j++){
                            res.append('C');
                        }
                    }
                    break;
                }
                case 3:{
                    for(int j=0;j<cur;j++){
                        res.append('M');
                    }
                    break;
                }
            }
        }
        return res.toString();
    }
}