package com.javaForElites.practice;

public class PreOrderTraversalBT {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static TreeNode createBinaryTree() {
		TreeNode rootNode = new TreeNode(10);

		TreeNode node20 = new TreeNode(20);
		TreeNode node30 = new TreeNode(30);
		TreeNode node40 = new TreeNode(40);
		TreeNode node50 = new TreeNode(50);
		TreeNode node60 = new TreeNode(60);
		TreeNode node70 = new TreeNode(70);
		TreeNode node80 = new TreeNode(80);
		TreeNode node90 = new TreeNode(90);
		TreeNode node100 = new TreeNode(100);
		TreeNode node110 = new TreeNode(110);

		rootNode.left = node20;
		rootNode.right = node30;

		node20.left = node40;
		node20.right = node50;

		node30.left = node60;
		node30.right = node70;

		node40.left = node80;

		node50.right = node90;

		node60.left = node100;

		node70.right = node110;

		return rootNode;
	}

	public void preOrderTraversal(TreeNode rootNode) {

		if (rootNode != null) {
			System.out.print(rootNode.data+ " ");

			preOrderTraversal(rootNode.left);
			preOrderTraversal(rootNode.right);
		}

	}
	
	
	public void inOrderTraversal(TreeNode root){
		
		if(root != null){
			inOrderTraversal(root.left);
			System.out.print(root.data+" ");
			inOrderTraversal(root.right);
		}
		
	}
	
	
public void postOrderTraversal(TreeNode root){
		
		if(root != null){
			postOrderTraversal(root.left);			
			postOrderTraversal(root.right);
			System.out.print(root.data+" ");
		}
		
	}

	public static void main(String[] args) {
		PreOrderTraversalBT potb = new PreOrderTraversalBT();
		TreeNode rootNode = createBinaryTree();

		potb.preOrderTraversal(rootNode);
		System.out.println();
		potb.inOrderTraversal(rootNode);
		System.out.println();
		potb.postOrderTraversal(rootNode);

	}

}
