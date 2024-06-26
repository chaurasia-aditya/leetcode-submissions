// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
    /*
        int i = 0, j = nums.length-1, temp;
        while(i<j){
            if(nums[i]!=val)
                i++;
            if(nums[j]==val)
                j--;
            if(nums[i] == val && nums[j]!=val && i<j){
                System.out.println("i="+i+" j="+j);
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j--;
            }
        }
        System.out.println("Final: i="+i+" j="+j);
        if(i==j && nums[i]==val)
            return i;
        if(i==j)
            return i+1;
        else
            return j+1;
    */
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}