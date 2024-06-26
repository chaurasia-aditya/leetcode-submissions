// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head, prev = null, nxt = head.next;
        while(cur!=null){
            cur.next = prev;
            if(nxt == null){
                head = cur;
                break;
            }
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        return head;
    }
}