// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    if(head == NULL)
        return false;
    struct ListNode *slow = head, *fast = head->next;

    while(fast && slow){
        if(slow == fast)
            return true;
        slow = slow->next;
        if(fast->next == NULL)
            break;
        fast = fast->next->next;
    }

    return false;
}