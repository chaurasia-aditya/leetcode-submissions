// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        
        String[] temp;
        StringBuilder sb;
        for(String s:emails){
            sb = new StringBuilder();
            temp = s.split("@");
            
            sb.append(temp[temp.length-1]);
            temp = temp[0].split("\\+");
                        
            temp = temp[0].split("\\.");

            sb.insert(0, "@");
            
            for(int i=temp.length-1;i>=0;i--){
                sb.insert(0, temp[i]);
            }
            
            hs.add(sb.toString());
        }
        
        return hs.size();
    }
}