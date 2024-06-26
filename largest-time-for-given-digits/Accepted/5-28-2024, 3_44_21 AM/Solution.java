// https://leetcode.com/problems/largest-time-for-given-digits

class Solution {
    public String largestTimeFromDigits(int[] arr) {       
        StringBuilder sb = new StringBuilder();
        
        int hh = -1;
        int mm = -1;
        int h_i=-1, h_j=-1, m_k=-1, m_l=-1;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i == j)
                    continue;
                
                int val = arr[i]*10+arr[j];
                if(val<24){
                    for(int k=0;k<4;k++){
                        if(k==i || k==j){
                            continue;
                        }
                        for(int l = 0;l<4;l++){
                            if(l==i || l==j || l==k)
                                continue;
                            
                            int val2 = arr[k]*10+arr[l];
                            if(val2<60 && ((val>hh) || (val==hh && val2>mm))){
                                hh = val;
                                mm = val2;
                                h_i = i;
                                h_j = j;
                                m_k = k;
                                m_l = l;
                            }
                        }
                    }
                }
            }
        }
        
        if(hh == -1 || mm == -1)
            return "";
        
        sb.append(arr[h_i]);
        sb.append(arr[h_j]);
        sb.append(":");
        sb.append(arr[m_k]);
        sb.append(arr[m_l]);
        
        return sb.toString();
        
        
    }
}