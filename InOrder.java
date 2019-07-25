package com.learn.tree;

/*
 *Pre-order traversal : Left -> Root -> Right 
 */
public class InOrder {

	public static void InOrder(Node root) {
		
		try{
		
			//System.out.println("Inside inorder method");
			InOrder(root.left);
			System.out.print(root.val+" ");
			InOrder(root.right);
		}
		catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Exception");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree bTree = new BinaryTree();
		bTree.root = new Node(1);
		bTree.root.left = new Node(3);
		bTree.root.right = new Node(5);
		bTree.root.left.left = new Node(8);
		bTree.root.left.right = new Node(2);
		bTree.root.right.left = new Node(5);
		bTree.root.right.right = new Node(9);
		
		InOrder(bTree.root);
	}

	
}
