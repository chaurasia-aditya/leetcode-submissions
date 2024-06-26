// https://leetcode.com/problems/shortest-uncommon-substring-in-an-array

class Solution {
//     class TrieNode {
//         Map<Character, TrieNode> children;
//         public int count;
//         boolean isEnd;
        
//         public TrieNode() {
//             this.children = new HashMap<>();
//             this.isEnd = false;
//             count = 0;
//         }
        
//         public TrieNode(int count){
//             this.children = new HashMap<>();
//             this.isEnd = false;
//             count = 1;
//         }
        
//     }
    
//     void insert(TrieNode trie, String word) {
//         TrieNode node = trie;
//         for (char ch : word.toCharArray()) {
//             node.children.putIfAbsent(ch, new TrieNode(1));
//             node = node.children.get(ch);
//             node.count++;
//         }
//         node.isEnd = true;
//     }
    
//     String findShortestUniqueSubstring(TrieNode trie, String word) {
//         TrieNode node = trie;
//         StringBuilder substring = new StringBuilder();
//         for (char ch : word.toCharArray()) {
//             substring.append(ch);
//             node = node.children.get(ch);
//             if (node.isEnd) {
//                 return "";
//             }
//             if(node.count == 1)
//                 return substring.toString();
//         }
        
        
//         return "";
//     }
    
    
    public String[] shortestSubstrings(String[] arr) {
//         TrieNode trie = new TrieNode();
//         for (String word : arr) {
//             insert(trie, word);
//         }

//         String[] result = new String[arr.length];
//         for (int i = 0; i < arr.length; i++) {
//             result[i] = findShortestUniqueSubstring(trie, arr[i]);
//         }
        
        
        int n = arr.length;
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String currentString = arr[i];
            int len = currentString.length();
            String currentAnswer = "";
            for (int start = 0; start < len; start++) {
                for (int end = start + 1; end <= len; end++) {
                    String substring = currentString.substring(start, end);

                    boolean isUnique = true;

                    for (int k = 0; k < n; k++) {
                        if (k != i && arr[k].contains(substring)) {
                            isUnique = false;
                            break;
                        }
                    }

                    if (isUnique) {
                        if (currentAnswer.isEmpty() || substring.length()<currentAnswer.length() || (substring.length()==currentAnswer.length() && substring.compareTo(currentAnswer) < 0)) {
                            currentAnswer = substring;
                        }
                    }
                }
                answer[i] = currentAnswer;
            }
        }

        return answer;
        
        
        // return result;
    }
}