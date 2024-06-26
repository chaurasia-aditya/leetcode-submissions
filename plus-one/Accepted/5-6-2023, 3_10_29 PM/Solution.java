// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        Deque<Integer> a = new ArrayDeque<>();
        int carry = 1, cur =0;
        for(int i=digits.length-1;i>=0;i--){
            cur=digits[i]+carry;
            a.addFirst(cur%10);
            carry = cur/10;
        }
        if(carry!=0)
            a.addFirst(carry);
        int[] arr = new int[a.size()];
        for(int i=0;i<arr.length;i++)
            arr[i] = a.remove();
        return arr;
    }
}