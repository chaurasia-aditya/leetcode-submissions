// https://leetcode.com/problems/swapping-nodes-in-a-linked-list

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = null, end = null, cur = head;
        int count=1;
        
        while(cur!=null){
            if(end!=null){
                end = end.next;
            }
            if(count == k){
                end = head;
                start = cur;
            }
            count++;
            cur = cur.next;
        }

        int temp = start.val;
        start.val = end.val;
        end.val = temp;

        return head;
    }
}