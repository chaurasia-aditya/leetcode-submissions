// https://leetcode.com/problems/implement-trie-prefix-tree

class Node{
    public Node[] children;
    boolean isEnd;
    public Node(){
        children = new Node[26];
        isEnd = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        if(root == null)
            return;
        Node cur = root;
        for(int i=0;i<word.length();i++){
            int ch = word.charAt(i)-'a';
            if(cur.children[ch] == null){
                cur.children[ch] = new Node();
            }
            cur = cur.children[ch];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
  
        for (char c : word.toCharArray()) {
            int index = c-'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
  
        for (char c : prefix.toCharArray()) {
            int index = c-'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */