package text_processing;

public class Trie {
	TrieNode root;
	int wordCount;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	private static void insert(TrieNode node, String word) {
		if (word.length() == 0) {
			node.isTerminal = true;
			return;
		}
		
		TrieNode child = node.children.get(word.charAt(0));
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			node.children.put(word.charAt(0), child);
		}
		insert(child, word.substring(1));
	}
	
	private static void remove(TrieNode node, String word) {
		if (word.length() == 0) {
			node.isTerminal = false;
			return;
		}
		
		TrieNode child = node.children.get(word.charAt(0));
		if (child == null) {
			return;
		}
		remove(child, word.substring(1));
		if (!child.isTerminal && child.children.isEmpty()) {
			node.children.remove(word.charAt(0));
		}
	}
	
	public void remove(String word) {
		if (!contains(word))
			return;
		remove(root, word);
		wordCount--;
	}
	
	public void insert(String word) {
		if (contains(word)) {
			return;
		}
		insert(root, word);
		wordCount++;
	}
	
	public boolean contains(String word) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode child = temp.children.get(word.charAt(i));
			if (child == null) {
				return false;
			}
			temp = child;
		}
		return temp.isTerminal;
	}
	
	public int size() {
		return wordCount;
	}
	
	public boolean isEmpty() {
		if (wordCount == 0)
			return true;
		return false;
	}
	
	
}
