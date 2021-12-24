package com.practice.practice.dataStructure.trees.binaryTree;

import java.util.ArrayList;

public class BinarySearchTree {

	Node root = null;

	/*
	 * insert(value) function to add new node to a binary tree
	 */

	public void insert(int value) {

		Node newNode = new Node(value);

		if (this.root == null) {
			this.root = newNode;
		} else {

			Node current = this.root;

			while (true) {
				if (current.value < value) {
					if (current.right != null) {
						current = current.right;
					} else {
						current.right = newNode;
						break;
					}
				} else {
					if (current.left != null) {
						current = current.left;
					} else {
						current.left = newNode;
						break;
					}

				}
			}

		}

	}

	/*
	 * lookup function will return true or false based on if the given element
	 * is present in binary tree
	 */

	public boolean lookup(int value) {

		Node current = this.root;
		while (current != null) {

			if (current.value > value) {
				current = current.left;
			} else if (current.value < value) {
				current = current.right;
			} else {
				return true;
			}

		}
		return false;

	}

	/*
	 * remove function to remove the disired element and then adjusting the
	 * binary tree
	 */
	public void remove(int value) {

		if (this.root == null) {
			return;
		}

		Node current = this.root;
		Node parentNode = null;
		// while current is not null
		while (current != null) {

			if (value < current.value) { // go left
				parentNode = current;
				current = current.left;
			} else if (value > current.value) { // go right
				parentNode = current;
				current = current.right;
			}
			// value == current.value, means we found the value
			else {
				// Option 1: No right child
				if (current.right == null) {
					// if parent node is null mean we are at root level only,
					// then delete the root node and make left node as root node
					if (parentNode == null) {
						this.root = current.left;
					} else {

						// if current < parent, make current left child a left
						// child of parent
						if (current.value < parentNode.value) {
							parentNode.left = current.left;
						}
						// if current > parent, make current left child a right
						// child of parent
						else if (current.value > parentNode.value) {
							parentNode.right = current.left;
						}

					}
				}
				// Option 2: Right Child which doesn't have a left child
				else if (current.right.left == null) {
					if (parentNode == null) {
						this.root = current.right;
					} else {
						// if current < parent make the current's right child a
						// left child of parent
						if (current.value < parentNode.value) {
							parentNode.left = current.right;
						}
						// ifcurrent > parent, make current's right child a
						// right child of parent)
						else {
							parentNode.right = current.right;
						}
					}
				}
				// Option 3: Right child which have a left child
				else {
					if (parentNode == null) {
						Node leftNode = this.root.left;
						Node rightNode = this.root.left;
						// root.right.left becomes root node
						this.root = current.right.left;
						rightNode.left = rightNode.left.right;
						// set back the saved references of left and righ nodes
						// of root
						this.root.left = leftNode;
						this.root.right = rightNode;
					} else {
						if (current.value < parentNode.value) {
							parentNode.left = current.right.left;
						} else if (current.value > parentNode.value) {
							parentNode.right = current.right.left;
						}
					}

				}
				return;
			}

		}
	}

	public void preOrderTraversal(Node root) {

		if (root != null) {

			System.out.print(root.value + " ");

			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}
	}

	///////////////////////////////////////////////////////
	// breadth first search //
	// note: {this method is from algorithms section- //
	// skip this if you are in Data Structures section} //
	///////////////////////////////////////////////////////
	public ArrayList<Integer> breadthFirstSearch() {
		Node currentNode = this.root;
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(currentNode);

		while (queue.size() > 0) {

			currentNode = queue.remove(0);
			resultArray.add(currentNode.value);

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}

		}
		return resultArray;

	}

	///////////////////////////////////////////////////////
	// breadth first search recursive //
	// note: {this method is from algorithms section- //
	// skip this if you are in Data Structures section} //
	///////////////////////////////////////////////////////
	public ArrayList<Integer> breadthFirstSearchRecursive(ArrayList<Node> queue, ArrayList<Integer> resultArray) {

		if (queue.size() == 0) {
			return resultArray;
		}

		Node currentNode = queue.remove(0);
		resultArray.add(currentNode.value);

		if (currentNode.left != null) {
			queue.add(currentNode.left);
		}
		if (currentNode.right != null) {
			queue.add(currentNode.right);
		}

		return breadthFirstSearchRecursive(queue, resultArray);

	}
	
    ///////////////////////////////////////////////////////
    //////////              DFS               /////////////
    ///////////////////////////////////////////////////////
    HelperFunction hlp = new HelperFunction();

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.inOrderTraversal(this.root, answer);
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.preOrderTraversal(this.root, answer);
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> answer = new ArrayList<>();
        return hlp.postOrderTraversal(this.root, answer);
    }

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(9);
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);
		binarySearchTree.insert(20);
		binarySearchTree.insert(170);
		binarySearchTree.insert(15);
		binarySearchTree.insert(3);
		binarySearchTree.insert(2);
		binarySearchTree.insert(5);
		binarySearchTree.insert(1);
		binarySearchTree.insert(7);
		binarySearchTree.preOrderTraversal(binarySearchTree.root);
		binarySearchTree.remove(40);
		System.out.println();
		binarySearchTree.preOrderTraversal(binarySearchTree.root);
		System.out.println();
		System.out.println("bfs: " + binarySearchTree.breadthFirstSearch());
		System.out.println("look for 20: " + binarySearchTree.lookup(20));

		ArrayList<Node> queue = new ArrayList<>();
		queue.add(binarySearchTree.root);
		System.out.println("bfs recursive: " + binarySearchTree.breadthFirstSearchRecursive(queue, new ArrayList<>()));
		
        System.out.println("dfs inOrder: " + binarySearchTree.DFSInOrder());
        System.out.println("dfs preOrder: " + binarySearchTree.DFSPreOrder());
        System.out.println("dfs postOrder: " + binarySearchTree.DFSPostOrder());

        binarySearchTree.remove(20);
        System.out.println("look for 20 after removing 20: " + binarySearchTree.lookup(20));

	}

}
