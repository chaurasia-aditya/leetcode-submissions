// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        ListNode res = null;
        ListNode small = null, large = null;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val>=x){
                if(large!=null){
                    large.next = new ListNode(cur.val);
                    large = large.next;
                }else if(small!=null){
                    small.next = new ListNode(cur.val);
                    large = small.next;
                }else{
                    res = new ListNode(cur.val);
                    large = res;
                }
            }else{
                if(small!=null){
                    ListNode temp = new ListNode(cur.val, small.next);
                    small.next = temp;
                    small = temp;
                }else if(res!=null){
                    ListNode temp = new ListNode(cur.val, res);
                    res = temp;
                    small = temp;
                }else{
                    res = new ListNode(cur.val);
                    small = res;
                }
            }
            cur = cur.next;
        }

        return res;
    }
}