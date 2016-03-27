package text_processing;

import java.util.HashMap;

public class TrieNode {
	char c;
	boolean isTerminal;
	HashMap<Character, TrieNode> children;
	
	public TrieNode(char c) {
		this.c = c;
		children = new HashMap<>();
	}
	
}
