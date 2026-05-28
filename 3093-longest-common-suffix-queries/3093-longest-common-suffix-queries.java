class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    void insert(String word, int index) {

        TrieNode node = root;

        // update root
        if(word.length() < node.len) {
            node.len = word.length();
            node.idx = index;
        }

        for(int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);

            if(node.child[ch - 'a'] == null) {
                node.child[ch - 'a'] = new TrieNode();
            }

            node = node.child[ch - 'a'];

            // keep shortest word
            if(word.length() < node.len) {
                node.len = word.length();
                node.idx = index;
            }
        }
    }

    int search(String word) {

        TrieNode node = root;

        for(int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);

            if(node.child[ch - 'a'] == null) {
                break;
            }

            node = node.child[ch - 'a'];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for(int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for(int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}