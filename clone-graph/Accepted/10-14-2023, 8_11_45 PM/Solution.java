// https://leetcode.com/problems/clone-graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] visited = new Node[101];
    public void dfs(Node res, Node cur){
        if(cur == null)
            return;
        visited[res.val] = res;

        for(int i=0;i<cur.neighbors.size();i++){
            int val = cur.neighbors.get(i).val;
            if(visited[val]==null)
            {
                res.neighbors.add(new Node(val));
                dfs(res.neighbors.get(i), cur.neighbors.get(i));
            }else{
                res.neighbors.add(visited[val]);
            }
        }
        return;
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        // visited = new HashMap<>();
        Node res = new Node(node.val);
        dfs(res, node);
        return res;
    }
}