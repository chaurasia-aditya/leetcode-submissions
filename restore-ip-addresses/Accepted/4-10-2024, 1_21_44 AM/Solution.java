// https://leetcode.com/problems/restore-ip-addresses

class Solution {
    void backtrack(int count, int index, StringBuilder sb, int n, List<String> res){
        if(count == 3){
            String ans = sb.toString();
            String[] arr = ans.split("\\.");
            if(arr.length!=4){
                return;
            }
            for(int i=0;i<4;i++){
                if(arr[i].length()>3 || arr[i].length()==0 || Integer.parseInt(arr[i])>255 || (arr[i].charAt(0) == '0' && arr[i].length()!=1))
                    return;
            }
            res.add(ans);
            return;
        }

        for(int i = index;i<=index+3 && i<sb.length();i++){
            if(sb.substring(index, i).startsWith("0") && (i-index != 1))
                continue;
            sb.insert(i,'.');
            backtrack(count+1, i+1, sb, n, res);
            sb.deleteCharAt(i);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        int[] pos = new int[4];
        backtrack(0, 0, new StringBuilder(s), s.length(), res);

        return res;
    }
}