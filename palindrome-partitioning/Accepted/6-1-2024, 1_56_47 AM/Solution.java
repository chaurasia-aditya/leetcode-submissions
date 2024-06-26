// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    boolean check(String str){
        int i=0, j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void solve(int i, int n, String s, ArrayList<String> cur, List<List<String>> res){
        if(i == n){
            res.add(new ArrayList(cur));
            return;
        }

        for(int j = i+1; j<=n;j++){
            String sub = s.substring(i, j);
            if(check(sub)){
                cur.add(sub);
                solve(j, n, s, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        solve(0, s.length(), s, new ArrayList<>(), res);

        return res;
    }
}