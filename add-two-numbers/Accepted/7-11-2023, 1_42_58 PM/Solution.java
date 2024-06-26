// https://leetcode.com/problems/add-two-numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int carry=0, sum=0;
        while(l1!=null || l2!=null|| carry!=0){
            sum = 0;
            sum+=(l1!=null)?l1.val:0;
            l1 = (l1!=null)?l1.next:null;

            sum+=(l2!=null)?l2.val:0;
            l2 = (l2!=null)?l2.next:null;

            sum+=carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
        }

        return res.next;
    }
}