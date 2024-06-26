// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    static char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
                                    {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public void backtrack(int pos, int n, String s, List<String> res, StringBuilder sb){
        if(pos==n){
            res.add(sb.toString());
            return;
        }

        int index = s.charAt(pos)-'0';
        for(int i=0; i<map[index].length;i++){
            sb.append(map[index][i]);
            backtrack(pos+1, n, s, res, sb);
            sb.deleteCharAt(pos);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;

        backtrack(0, digits.length(), digits, res, new StringBuilder());

        return res;
    }
}