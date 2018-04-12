package specials;

import java.util.*;

public class Trie {
	
	TriNode root;
	
	Trie(){
		root = new TriNode('$');
	}
	
	public void insert(String word){
		
		if(word == null || word.length() == 0){
			return;
		}
		
		TriNode tmp ;
		Map<Character,TriNode> nodes = root.children;
		
		for (int i =0;i<word.length();i++) {
			
			char ch = word.charAt(i);
		
			if(nodes.containsKey(ch)){
				tmp = nodes.get(ch);
			} else {
				tmp = new TriNode(ch);
				nodes.put(ch,tmp);
			}
			if( i == word.length()){
				tmp.isWord = true;
			}
			nodes = tmp.children;
		}
		
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		
		if(word == null || word.length() == 0){
			return false;
		}
		
		TriNode tmp;
		Map<Character, TriNode> nodes = root.children;
		for (int i = 0;i<word.length();i++){
			
			
			if(nodes.containsKey(word.charAt(i))){
				tmp = nodes.get(word.charAt(i));
			} else {
				return false;
			}
			
			nodes = tmp.children;
			
			if(i == word.length() - 1 && tmp.isWord){
				return true;
			}
			
			
		}
		
		return false;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		
		if(prefix == null || prefix.length() == 0){
			return false;
		}
		
		TriNode tmp;
		Map<Character, TriNode> nodes = root.children;
		for (int i = 0 ; i<prefix.length();i++){
			char c = prefix.charAt(i);
			if(nodes.containsKey(c)){
				tmp = nodes.get(c);
			} else {
				return false;
			}
			
			nodes = tmp.children;
		}
		
		return true;
	}
	
	
}


class TriNode {
	char c;
	Map<Character , TriNode> children;
	boolean isWord;
	
	TriNode(char ch) {
		this.c = ch;
		children = new HashMap<>();
		isWord = false;
	}
	
}