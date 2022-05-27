package Lab12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AVL {
	
private Node root;
	
	class Node{
		
		Node left;
		Node right;
		Node parent;
		int h;
		int value;
		
		public Node(int value) { this.value = value; }
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public Node min() {
	    if (isEmpty()) return null;
	    return min(this.root);
	}
	    
	private Node min(Node node) {
	    if (node.left == null) return node;
	    else return min(node.left);
	}
	
	public Node max() {
	    if (isEmpty()) { return null; }
	    return max(this.root);
	}
	
	private Node max(Node no) {
		if(no.right == null) { return no; }
		else { return max(no.right); }
	}
	
	public Node sucessor(Node node) {
	    if (node == null) return null;
	        
	    if (node.right != null)
	        return min(node.right);
	    else {
	        Node aux = node.parent;
	            
	        while (aux != null && aux.value < node.value)
	            aux = aux.parent;
	            
	        return aux;
	    }
	}
	
	public Node predecessor(Node node) {
	    if (node == null) return null;
	    
	    if (node.left != null)
	        return max(node.left);
	    else {
	        Node aux = node.parent;
	        
	        while (aux != null && aux.value > node.value)
	            aux = aux.parent;
	        
	        return aux;
	    }
	}
	
	public void preOrder() {
	    preOrder(this.root);
	}

	private void preOrder(Node node) {
	    if (node != null) {
	        System.out.println(node.value);
	        preOrder(node.left);
	        preOrder(node.right);
	    }
	}
	
	public void inOrder() {
	    inOrder(this.root);
	}

	private void inOrder(Node node) {
	    if (node != null) {
	        inOrder(node.left);
	        System.out.println(node.value);
	        inOrder(node.right);
	    }
	}
	
	public void posOrder() {
	    posOrder(this.root);
	}

	private void posOrder(Node node) {
	    if (node != null) {
	        posOrder(node.left);
	        posOrder(node.right);
	        System.out.println(node.value);
	    }
	}
	
	public String searchInWidth() {
	    Deque<Node> queue = new LinkedList<Node>();
	    String result = "";
	        
	    if (!isEmpty()) {
	        queue.addLast(this.root);
	        while (!queue.isEmpty()) {
	            Node atual = queue.removeFirst();
	                
	            result += Integer.toString(atual.value) + " ";
	                
	            if(atual.right != null) { queue.addLast(atual.right); }
	                
	            if(atual.left != null) { queue.addLast(atual.left); }
	        }
	    }
	    return result.trim();
	}
	
	public boolean isLeftPending(Node no) {
		return altura(no.left) - altura(no.right) == 1;
	}
	
	public boolean isRightPending(Node no) {
		return altura(no.left) - altura(no.right) == -1;
	}
	public boolean isBalanced(Node no) {
		return altura(no.left) - altura(no.right) == 0;
	}

	
	private int balance(Node no) {
	    if (no != null) { return altura(no.left) - altura(no.right); }
	    return 0;
	}
	
	public int altura(Node no) {
		if(no == null) { return -1; }
		else {return 1 + Math.max(altura(no.left), altura(no.right)); }
	}
	
	public void rotateRight(Node x) {
		Node pivot = x.left;

		x.left = pivot.right; 
		pivot.right = x;

		pivot.parent = x.parent;
		x.parent = pivot; 

		if (pivot.parent.left == x) { pivot.parent.left = pivot; }
		else { pivot.parent.right = pivot; }
         
	}
	
	public void rotateLeft(Node x) {
		Node pivot = x.right;
	
		x.right = pivot.left; 
		pivot.left = x;

		pivot.parent = x.parent; 
		x.parent = pivot; 

		if ( pivot.parent.right == x) { pivot.parent.right = pivot; }
		else { pivot.parent.left = pivot; }
	}
	
	public void insert(int newElement) {
		if(isEmpty()) {
			this.root = new Node(newElement);
		}else {
			
			Node aux = this.root;
			
			while(aux != null) {
				if(newElement < aux.value) {
					if(aux.left == null) {
						Node newNode = new Node(newElement);
						aux.left = newNode;
						newNode.parent = aux;
						rebalance(aux);
						return;
					}
					
					aux = aux.left;
					
				}else {
					if(aux.right == null) {
						Node newNode = new Node(newElement);
						aux.right = newNode;
						newNode.parent = aux;
						rebalance(aux);
						return;
					}
					
					aux = aux.right;
				}
			}
		}
	}
         
	
	private void rebalance(Node no) {
		if(no == null) { return; }
		
		int balance = balance(no);
		
		if(balance < -1) {
			if(altura(no.right) > altura(no.left)) {
				rotateLeft(no);
			}else {
				rotateRight(no.right);
				rotateLeft(no);
			}
			System.out.println("chegou -1");
		}else if(balance > 1) {
			if(altura(no.left) > altura(no.right)) {
				rotateRight(no);
			}else {
				rotateLeft(no.left);
				rotateRight(no);
			}
			System.out.println("chegou 1");
		}
		
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        AVL avl = new AVL();
        for (int i=0; i<nums.length; i++) {
        	avl.insert(Integer.parseInt(nums[i]));
        }
        avl.preOrder();
	}

}
