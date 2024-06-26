// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    if(head == NULL || head->next == NULL)
        return false;
    struct ListNode *slow = head, *fast = head;

    while(fast && slow){
        slow = slow->next;
        if(fast->next == NULL)
            break;
        fast = fast->next->next;
        if(slow == fast)
            return true;
    }

    return false;
}