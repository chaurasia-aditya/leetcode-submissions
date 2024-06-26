// https://leetcode.com/problems/add-two-numbers-ii

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
        
        ListNode cur = l1;
        ListNode next = l1.next;
        while(next!=null){
            if(cur == l1)
                cur.next = null;
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        l1 = cur;
        
//         cur = l1;
//         while(cur!=null){
//             System.out.print(cur.val+"->");
//             cur = cur.next;
//         }
        
//         System.out.println();
        
        cur = l2;
        next = l2.next;
        while(next!=null){
            if(cur == l2)
                cur.next = null;
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        l2 = cur;
        
        
        // cur = l2;
        // while(cur!=null){
        //     System.out.print(cur.val+"->");
        //     cur = cur.next;
        // }
        // System.out.println();
        
        int carry = 0;
        int sum = 0;
        cur = res;
        while(l1!=null || l2!=null || carry!=0){
            sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            
            cur.next=new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
        }
        
        // cur = res.next;
        // while(cur!=null){
        //     System.out.print(cur.val+"->");
        //     cur = cur.next;
        // }
        // System.out.println();
        
        cur = res.next;
        next = cur.next;
        while(next!=null){
            if(cur == res.next)
                cur.next = null;
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        res = cur;
        return res;
    }
}