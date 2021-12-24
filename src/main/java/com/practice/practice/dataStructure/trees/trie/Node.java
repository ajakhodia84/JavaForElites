package com.practice.practice.dataStructure.trees.trie;

import java.util.HashMap;

public class Node {
	
	HashMap<Character, Node> children = new HashMap<>();
	boolean isWord = false;

}
