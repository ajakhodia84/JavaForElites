package com.practice.practice.dataStructure.trees.trie;

public class Trie {
	
	private final Node root = new Node();
	
	public void insert(String string){
		Node current=root;
		/*
		 * for each character in the word, check if it exists 
		 * in hashmap, if not then add the character as a key in the map
		 * and a new node as its value. Do this untill all characters are
		 * traversed
		 */
		
		for(char ch : string.toCharArray()){
			current.children.putIfAbsent(ch, new Node());
			current = current.children.get(ch);
		}
		current.isWord=true;
	}
	
	/*
	 * find word function to check if a word is present in the trie
	 */
	public boolean findWord(String string){
		
		Node current = root;
		for(char ch : string.toCharArray()){
			if(current.children.containsKey(ch)){
				current = current.children.get(ch);
			} else {
				return false;
			}
		}
		return current.isWord;
		
	}
	
	public boolean delete(String string){
		
		Node current = root;
		Node deleteAfter = root;
		
		char ch1 = string.charAt(0); // char '\0' = NULL
		
		for(int i=0; i < string.length(); i++){
			
			char ch = string.charAt(i);
			if(current.children.containsKey(ch)){
				current = current.children.get(ch);
				
				if(current.children.size()>1){
					deleteAfter = current;
					ch1=string.charAt(i+1);
				}
			} else {
				return false;
			}
			
		}
		
		if(current.children.isEmpty()){
			deleteAfter.children.remove(ch1);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("heating");
		trie.insert("heat");
		trie.insert("Anupam");
		
		trie.insert("hea");
		System.out.println(trie.root.children.get('h').children.get('e').children);
		System.out.println(trie.findWord("heating"));
		System.out.println(trie.delete("heating"));
		System.out.println(trie.findWord("heat"));
		System.out.println(trie.findWord("heating"));

	}
	
	

}
