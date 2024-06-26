// https://leetcode.com/problems/design-add-and-search-words-data-structure

class Node{
    Node children[];
    boolean isEnd;
    public Node(){
        children = new Node[26];
        isEnd = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        if(root == null)
            return;
        Node cur = root;
        for(char ch: word.toCharArray()){
            if(cur.children[ch-'a'] == null){
                cur.children[ch-'a'] = new Node();
            }
            cur = cur.children[ch-'a'];
        }
        cur.isEnd = true;
    }
    
    private boolean searchLoop(Node cur, int i, String word){
        for (;i<word.length();i++) {
            char c = word.charAt(i);

            if(c == '.'){
                for(int j=0;j<26;j++){
                    if(cur.children[j]!=null){
                        boolean res = searchLoop(cur.children[j],i+1, word);
                        if(res == true){
                            return res;
                        }
                    }
                }
                return false;
            }

            int index = c-'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEnd;
    }

    public boolean search(String word) {
        return searchLoop(root, 0, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */