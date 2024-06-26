// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {
    class Log implements Comparable<Log>{
        String[] logs;
        int index;
        boolean isDigitLog;
        
        Log(String s, int i){
            logs = s.split(" ");
            index = i;
            // isDigitLog = true;
            
            if(Character.isDigit(logs[1].charAt(0)))
                isDigitLog = true;
            else
                isDigitLog = false;
            
            // try { 
            //     Integer.parseInt(logs[1]); 
            // } catch(NumberFormatException e) { 
            //     isDigitLog = false; 
            // }
        }
        
        public int compareTo(Log b){
            if(this.isDigitLog == false && b.isDigitLog == true){
                return -1;
            }
            
            if(this.isDigitLog == true && b.isDigitLog == false){
                return 1;
            }
            
            if(this.isDigitLog == false){
                int bl = b.logs.length;
                int al = this.logs.length;
                int i=1, j=1;
                while(i<al && j<bl){
                    int val = this.logs[i].compareTo(b.logs[j]);
                    if(val!=0)
                        return val;
                    i++;
                    j++;
                }
                
                if(i!=al){
                    return 1;
                }else if(j!=bl){
                    return -1;
                }else{
                    return this.logs[0].compareTo(b.logs[0]);
                }
                
            }else{
                return index - b.index;
            }
        }
    };
    
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        
        Log[] log = new Log[n];
        
        for(int i=0;i<n;i++){
            log[i] = new Log(logs[i], i);
        }
        
        Arrays.sort(log);
        
        String[] res = new String[n];
        
        for(int i=0;i<n;i++){
            // System.out.println(Arrays.toString(log[i].logs));
            res[i] = logs[log[i].index];
        }
        
        return res;
    }
}