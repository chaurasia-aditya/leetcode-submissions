// https://leetcode.com/problems/merge-two-sorted-lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int val1, val2;
        while(list1!=null || list2!=null){
            val1 = list1!=null?list1.val:200;
            val2 = list2!=null?list2.val:200;
            cur.next = (val1<=val2?list1:list2);
            if(val1<=val2){
                list1 = list1.next;
            }else{
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}