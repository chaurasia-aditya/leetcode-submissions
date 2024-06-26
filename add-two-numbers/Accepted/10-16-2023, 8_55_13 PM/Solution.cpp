// https://leetcode.com/problems/add-two-numbers

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* res = new ListNode();
        ListNode* cur = res;
        int sum = 0, carry = 0;
        while(l1 && l2){
            sum = carry;
            sum+=l1->val;
            l1 = l1->next;
            sum+=l2->val;
            l2 = l2->next;

            cur->next = new ListNode(sum%10);
            carry= sum/10;
            cur = cur->next;
        }

        while(l1){
            sum = carry;
            sum+=l1->val;
            cur->next = new ListNode(sum%10);
            carry= sum/10;
            cur = cur->next;
            l1 = l1->next;
        }

        while(l2){
            sum = carry;
            sum+=l2->val;
            cur->next = new ListNode(sum%10);
            carry= sum/10;
            cur = cur->next;
            l2 = l2->next;
        }

        if(carry){
            cur->next = new ListNode(1);
        }
        return res->next;
    }
};