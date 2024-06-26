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
    public void dfs(Node res, Node cur, Node[] visited){
        if(cur == null)
            return;
        visited[res.val] = res;

        for(Node n: cur.neighbors){
            if(visited[n.val]==null)
            {
                Node nn = new Node(n.val);
                res.neighbors.add(nn);
                dfs(nn, n, visited);
            }else{
                res.neighbors.add(visited[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Node[] visited = new Node[101];
        // visited = new HashMap<>();
        Node res = new Node(node.val);
        dfs(res, node, visited);
        return res;
    }
}