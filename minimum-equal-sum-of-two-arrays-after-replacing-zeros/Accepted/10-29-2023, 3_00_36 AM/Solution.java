// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long c1 = 0, c2 = 0;
        long sum1=0, sum2=0;
        for(int i =0;i<nums1.length;i++){
            sum1+=nums1[i];
            if(nums1[i]==0)
                c1++;
        }
        for(int i =0;i<nums2.length;i++){
            sum2+=nums2[i];
            if(nums2[i]==0)
                c2++;
        }
        if((c1==0 && c2==0 && sum1 != sum2) || (c1 == 0 && c2!=0 && sum2+c2>sum1) || (c2==0 && c1!=0 && sum1+c1>sum2)){
            return -1;
        }
        
        return Math.max(sum1+c1, sum2+c2);
    }
}