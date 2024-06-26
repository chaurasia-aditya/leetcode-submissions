// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();

        int i = 0;
        Node cur = head;
        Node res = null, cur_res = null;
        while(cur!=null){
            if(res == null){
                res = new Node(cur.val);
                cur_res = res;

                hm.put(cur, res);

                cur = cur.next;
                continue;
            }
            cur_res.next = new Node(cur.val);
            cur_res = cur_res.next;
            // if(cur.random<i){
            //     cur_res.random = hm.get(cur.random);
            // }
            cur_res.random = hm.get(cur.random);
            hm.put(cur, cur_res);
            cur = cur.next;
        }
        cur = head;
        cur_res = res;
        while(cur!=null){
            if(cur.random!=null && cur_res.random == null){
                cur_res.random = hm.get(cur.random);
            }
            cur = cur.next;
            cur_res = cur_res.next;
        }
        return res;
    }
}