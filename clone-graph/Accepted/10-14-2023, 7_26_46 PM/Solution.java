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
    HashMap<Integer, Node> visited;
    public void dfs(Node res, Node cur){
        if(cur == null)
            return;
        visited.put(res.val, res);

        for(int i=0;i<cur.neighbors.size();i++){
            // System.out.println("i = "+i);
            // Node add = visited.getOrDefault(cur.neighbours.get(i).val, );
            if(!visited.containsKey(cur.neighbors.get(i).val))
            {
                res.neighbors.add(new Node(cur.neighbors.get(i).val));
                dfs(res.neighbors.get(i), cur.neighbors.get(i));
            }else{
                res.neighbors.add(visited.get(cur.neighbors.get(i).val));
            }
        }
        return;
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        visited = new HashMap<>();
        Node res = new Node(node.val);
        dfs(res, node);
        return res;
    }
}