package com.learn.tree;

import java.util.TreeSet;

/**
 * @author anotheruser
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	static Node root;
	static int size = 0;
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		
		root = null;
	}
	
	public static<T> void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree<Double> bst = new BinarySearchTree();
		TreeSet<Integer> tset = new TreeSet<>();
		Double t = null;
		System.out.println("Insert into BST");
		bst.insertBST(4.0);
		bst.insertBST(2.0);
		bst.insertBST(1.0);
		System.out.println("Half");
		bst.insertBST(3.0);
		bst.insertBST(5.0);
		bst.insertBST(8.0);
		bst.insertBST(9.0);
		//bst.insertBST(90.0);
		
		// Calling Inorder
		System.out.println("Calling inorder");
		InOrder.InOrder(bst.root);
		System.out.println(" ");
		
		// To check Contains
		t = 80.0;
		//System.out.println("Contains: "+ bst.contains(t));
		bst.contains(t);
		
		// To Check clear
		//bst.clear();
		
		// To Check size
		System.out.println("Size: "+bst.size());
		
		// To Delete
		bst.remove(1.0);
		InOrder.InOrder(bst.root);;
		System.out.println();
		bst.remove(5.0);
		InOrder.InOrder(bst.root);
	}

	
	/**
	 * To Insert values into BST
	 * @param val of type <T> T
	 */
	void insertBST(T val) {
		root = insertBST(root, val);
	}
	
	private Node insertBST(Node root, T val) {
		
		if(root == null) {
			root = new Node(val);
			return root;
		}
		
		if(val.compareTo((T) root.val)<0) {
			root.left = insertBST(root.left, val);
		}else if(val.compareTo((T) root.val)>0) {
			root.right = insertBST(root.right, val);
		}
		
		return root;
	}
	
	/**
	 * To check if BST contains the Node
	 * @param val of type <T> T
	 */
	boolean contains(T t) {
		
		return contains(root, t);
	}
	
	private boolean contains(Node root, T t) {
		
		boolean isExists = false;
		try{
			//System.out.println(((Comparable<T>) t).compareTo((T) root.val));

			if(((Comparable<T>) t).compareTo((T) root.val) ==0) {
				System.out.println("Contains: "+ t);
				isExists = true;
			}
			else if(((Comparable<T>) t).compareTo((T) root.val)<0) {
				//System.out.println("less");
				contains(root.left, t);
			}else if(((Comparable<T>) t).compareTo((T) root.val)>0) {
				//System.out.println("more");
				contains(root.right, t);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Value: " + e.getMessage());
		}
		return isExists;
	}
	
	/**
	 * Returns the size of BST
	 * @param None
	 */
	int size() {
		 
		 size(root, size);
		 return size;
	}
	 
	private void size(Node root, int i) {
		 
		 if(root == null)
			 return;
		 else
			 size++;
		 size(root.left, size);
		 size(root.right, size);
	}
	 
	/**
	 * To Clear values from BST
	 * @param None
	 */
	 void clear() {
		 root = null;
	 }
	 
	 
	 /**
	  * To remove value from BST
	  * @param val of type <T> T
	  */
	 void remove(T i) {
		 
		 root = remove(root, i);
	 }
	 
	 private Node remove(Node root, T t) {
		 
		 if(root == null)
			 return null;
		 
	
		 if(((Comparable<T>) t).compareTo((T) root.val)<0) {
				//System.out.println("less");
			 root.left = remove(root.left, t);
		 }else if(((Comparable<T>) t).compareTo((T) root.val)>0) {
				//System.out.println("more");
				root.right = remove(root.right, t);
		 } else {
			 
			 if(root.left == null)
				 return root.right;
			 else if(root.right == null)
				 return root.left;
			 
			 root.val = minVal(root.right);
			 root.right = remove(root.right, (T)root.val);
		 }
		 return root;
	 }
	 
	 private T minVal(Node root) {
		 
		 T min = (T)root.val;
		 while(root.left != null) {
			 min = (T)root.left.val;
			 root = root.left;
		 }
		 return min;
	 }
}
