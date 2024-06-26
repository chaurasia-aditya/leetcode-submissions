// https://leetcode.com/problems/middle-of-the-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* middleNode(struct ListNode* head) {
    struct ListNode *prev = head, *cur = head;

    while(cur && cur->next){
        cur = cur->next->next;
        prev = prev->next;
    }

    return prev;
}