// https://leetcode.com/problems/middle-of-the-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* middleNode(struct ListNode* head) {
    struct ListNode *prev = NULL, *cur = head;

    if(cur->next == NULL)
        return cur;

    prev = cur;
    cur = cur->next;

    while(cur->next!=NULL && cur->next->next!=NULL){
        cur = cur->next->next;
        prev = prev->next;
    }

    return prev->next;
}