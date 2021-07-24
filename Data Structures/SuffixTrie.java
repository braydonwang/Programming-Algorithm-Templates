package DMOJ;
import java.util.*;

public class Suffix{ 
    static class SuffixTrieNode{ 
        static final int MAX_CHAR = 26; 
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR]; 
  
        SuffixTrieNode(){ 
            for (int i = 0; i < MAX_CHAR; i++) { 
                children[i] = null; 
            }
        } 
  
        void insertSuffix(String s){ 
            if (s.length() > 0) { 
                char cIndex = (char) (s.charAt(0) - 'a'); 
  
                if (children[cIndex] == null) { 
                    children[cIndex] = new SuffixTrieNode(); 
                }
                children[cIndex].insertSuffix(s.substring(1)); 
            } 
        } 
    } 
      
    static class Suffix_trie { 
        static final int MAX_CHAR = 26; 
        SuffixTrieNode root; 
        
        Suffix_trie(String s) { 
            root = new SuffixTrieNode(); 
            for (int i = 0; i < s.length(); i++) {
                root.insertSuffix(s.substring(i));
            }
        } 
  
        int _countNodesInTrie(SuffixTrieNode node) { 
            if (node == null) {
                return 0; 
            }
  
            int count = 0; 
            for (int i = 0; i < MAX_CHAR; i++) { 
                if (node.children[i] != null) { 
                    count += _countNodesInTrie(node.children[i]); 
                }
            } 
            return (1 + count); 
        } 
  
        int countNodesInTrie() { 
            return _countNodesInTrie(root); 
        } 
    }  
  
    static int countDistinctSubstring(String str) { 
        Suffix_trie sTrie = new Suffix_trie(str); 
        return sTrie.countNodesInTrie(); 
    } 
  
    public static void main(String args[]) {
    	Scanner sc = new Scanner (System.in);
    	int n = sc.nextInt();
    	for (int i = 0; i < n; i++) {
    		String str = sc.next(); 
            System.out.println(countDistinctSubstring(str));
    	}
    } 
} 
