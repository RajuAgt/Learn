package com.learn.tree;

public class Node<T extends Comparable<T>>{

	T val;
	Node left, right;
	
	public Node(T val){
		this.val = val;
		left = null;
		right = null;
	}
	/*public static void main(String[] as) {
		
		Node t1 = new Node(1);
	}*/

}
