// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>(2);
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;

        for(int i=0, j=0; i<l1 || j<l2;){
            while((i<l1-1) && nums1[i] == nums1[i+1])
                i++;
            while((j<l2-1) && nums2[j] == nums2[j+1])
                j++;
            if(i<l1 && j<l2){
                if(nums1[i] == nums2[j]){
                    i++;
                    j++;
                }else if(nums1[i]<nums2[j]){
                    n1.add(nums1[i]);
                    i++;
                }else{
                    n2.add(nums2[j]);
                    j++;
                }
            }else if(i<l1){
                n1.add(nums1[i]);
                i++;
            }else{
                n2.add(nums2[j]);
                j++;
            }
        }

        res.add(n1);
        res.add(n2);

        return res;
    }
}