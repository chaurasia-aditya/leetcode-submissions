// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        char[][] order = new char[][]{
                                        {'I','V','X'},
                                        {'X','L','C'},
                                        {'C','D','M'}
                                    };
        while(num>0){
            arr.add(num%10);
            num/=10;
        }
        for(int i = arr.size()-1;i>=0;i--){
            int cur = arr.get(i);
            switch(i){
                case 3:{
                    for(int j=0;j<cur;j++){
                        res.append('M');
                    }
                    break;
                }
                case 0:
                case 1:
                case 2:{
                    char min = order[i][0];
                    char mid = order[i][1];
                    char max = order[i][2];

                    if(cur == 4){
                        res.append(min);
                        res.append(mid);
                    }else if(cur == 9){
                        res.append(min);
                        res.append(max);
                    }else if(cur<4){
                        for(int j=0;j<cur;j++){
                            res.append(min);
                        }
                    }else{
                        res.append(mid);
                        cur-=5;
                        for(int j=0;j<cur;j++){
                            res.append(min);
                        }
                    }
                    break;
                }
            }
        }
        return res.toString();
    }
}