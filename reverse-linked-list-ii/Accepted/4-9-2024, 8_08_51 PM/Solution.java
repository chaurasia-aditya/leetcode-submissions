// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head == null)
            return head;
        ListNode prev = null, start = head, end = head, cur, last;
        int swaps = right-left;

        while(--left!=0){
            prev = start;
            start = start.next;
        }
        while(--right!=0){
            end = end.next;
        }
        
        last = end.next;
        cur = start.next;

        while(swaps-->0){
            ListNode temp = cur.next;
            if(prev == null){
                cur.next = head;
            }
            else{
                cur.next = prev.next;
            }
            start.next = temp;

            if(prev == null){
                head = cur;
                // start = head;
            }else{
                prev.next = cur;
            }
            cur = start.next;
        }
        
        return head;
    }
}