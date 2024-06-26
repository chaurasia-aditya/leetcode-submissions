// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode prev = null, cur = head, forward = head;
        for(int i=0;i<n;i++){
            forward = forward.next;
        }
        while(forward!=null){
            prev = cur;
            cur = cur.next;
            forward = forward.next;
        }
        if(prev != null)
            prev.next = cur.next;
        else{
            head = head.next;
        }
        return head;
    }
}