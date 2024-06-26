// https://leetcode.com/problems/remove-nth-node-from-end-of-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    if(head == NULL)
        return NULL;

    struct ListNode *prev = NULL, *cur = head, *next = head;

    for(int i=0;i<n;i++){
        next = next->next;
    }

    while(next){
        prev = cur;
        cur = cur->next;
        next = next->next;
    }

    if(prev == NULL){
        head = head->next;
    }else{
        prev->next = cur->next; 
    }

    return head;
}