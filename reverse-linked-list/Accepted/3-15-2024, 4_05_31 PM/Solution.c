// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {

    if(!head || !head->next){
        return head;
    }

    struct ListNode *res = head;
    head = head->next;

    res->next = NULL;

    while(head){
        struct ListNode *temp = head->next;
        head->next = res;
        res = head;
        head = temp;
    }

    return res;
}