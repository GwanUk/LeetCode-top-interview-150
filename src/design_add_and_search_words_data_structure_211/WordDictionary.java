package design_add_and_search_words_data_structure_211;

import java.util.*;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.

 * Implement the WordDictionary class:

 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

 * Example:
     Input
     ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     Output
     [null,null,null,null,false,true,true,true]

     Explanation
     WordDictionary wordDictionary = new WordDictionary();
     wordDictionary.addWord("bad");
     wordDictionary.addWord("dad");
     wordDictionary.addWord("mad");
     wordDictionary.search("pad"); // return False
     wordDictionary.search("bad"); // return True
     wordDictionary.search(".ad"); // return True
     wordDictionary.search("b.."); // return True
 */

class WordDictionary {
    Node root = new Node();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        addRec(root, word, 0);
    }
    
    public boolean search(String word) {
        return findRec(root, word, 0);
    }

    private void addRec(Node parent, String word, int i){
        if (i == word.length()){
            parent.isEndOfWord = true;
            return;
        }

        char c = word.charAt(i);
        Node child = parent.child(c);
        addRec(child, word, i + 1);
    }

    private boolean findRec(Node parent, String word, int i) {
        if (i == word.length()) {
            return parent.isEndOfWord;
        }

        char c = word.charAt(i);

        if (c == '.') {
            List<Node> children = parent.getChildren();
            for (Node child : children) {
                boolean result = findRec(child, word, i + 1);
                if (result) return true;
            }

            return false;
        }

        Node child = parent.find(c);
        if (child == null) {
            return false;
        }

        return findRec(child, word, i + 1);
    }

    static class Node{
        private final Map<Character, Node> children = new HashMap<>();
        public boolean isEndOfWord;

        public Node child(char c) {
            if (children.containsKey(c)) {
                return children.get(c);
            }

            Node node = new Node();
            children.put(c, node);
            return node;
        }

        public Node find(char c) {
            return children.getOrDefault(c, null);
        }

        public List<Node> getChildren() {
            return new ArrayList<>(children.values());
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */