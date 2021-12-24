package com.practice.practice.dataStructure.trees.binaryTree;

import java.util.ArrayList;

public class HelperFunction {

	// In order traversal
	public ArrayList<Integer> inOrderTraversal(Node node, ArrayList<Integer> array) {

		if (node.left != null) {
			inOrderTraversal(node.left, array);
		}
		array.add(node.value);
		if (node.right != null) {
			inOrderTraversal(node.right, array);
		}
		return array;
	}

	// Pre order traversal
	public ArrayList<Integer> preOrderTraversal(Node node, ArrayList<Integer> array) {

		array.add(node.value);
		if (node.left != null) {
			inOrderTraversal(node.left, array);
		}

		if (node.right != null) {
			inOrderTraversal(node.right, array);
		}
		return array;
	}

	// Pre order traversal
	public ArrayList<Integer> postOrderTraversal(Node node, ArrayList<Integer> array) {

		if (node.left != null) {
			inOrderTraversal(node.left, array);
		}

		if (node.right != null) {
			inOrderTraversal(node.right, array);
		}
		array.add(node.value);
		return array;
	}

}
