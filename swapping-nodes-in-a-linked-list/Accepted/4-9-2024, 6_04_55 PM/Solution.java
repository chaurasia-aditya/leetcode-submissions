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
        ListNode start_prev = null, start_node = null;
        ListNode end_prev = null, end_node = null;

        //start
        int count=1;
        start_node = head;

        while(count++<k){
            start_prev = start_node;
            start_node = start_node.next;
        }
        //end

        count = 1;
        end_node = head;
        while(count++<k){
            end_node= end_node.next;
        }

        while(end_node.next!=null){
            if(end_prev == null){
                end_prev = head;
            }else{
                end_prev = end_prev.next;
            }
            end_node = end_node.next;
        }

        if(end_prev!=null)
            end_node = end_prev.next;
        else end_node = head;

        int temp = start_node.val;
        start_node.val = end_node.val;
        end_node.val = temp;
        // end_next = end_node.next;

        // if(end_node == start_node){
        //     return head;
        // }

        // //swap
        // if(start_prev != null){
        //     start_prev.next = end_node;
        // }else{
        //     head = end_node;
        // }

        // start_node.next = end_next;

        // if(end_next == start_node){
        //     start_node.next = end_node;
        // }else if(start_next == end_node){
        //     end_node.next = start_node;
        // }else{
        //     end_prev.next = start_node;
        //     end_node.next = start_next;
        // }

        return head;
    }
}