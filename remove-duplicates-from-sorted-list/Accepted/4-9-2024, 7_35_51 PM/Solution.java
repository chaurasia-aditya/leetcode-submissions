// https://leetcode.com/problems/remove-duplicates-from-sorted-list

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head.next, prev = head;
        while(cur!=null){
            if(cur.val == prev.val){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = prev.next;
                cur = prev.next;
            }
        }
        return head;
    }
}