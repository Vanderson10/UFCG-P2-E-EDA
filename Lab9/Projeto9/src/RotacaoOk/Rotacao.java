package RotacaoOk;

import java.util.Scanner;

class Rotacao {
	
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
	
	private int balance(Node no) {
	    if (no != null) { return altura(no.left) - altura(no.right); }
	    return 0;
	}
	
	public int altura(Node no) {
		if(no == null) { return -1; }
		else {return 1 + Math.max(altura(no.left), altura(no.right)); }
	}
	
	public void rotateRight(Node x) {
		System.out.println("chegou 1");
		Node pivot = x.left;

		x.left = pivot.right; 
		pivot.right = x;

		pivot.parent = x.parent;
		x.parent = pivot; 

		if (pivot.parent.left == x) { pivot.parent.left = pivot; }
		else { pivot.parent.right = pivot; }
         
	}
	
	public void rotateLeft(Node x) {
		System.out.println("chegou 1");
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
		}else if(balance > 1) {
			if(altura(no.left) > altura(no.right)) {
				rotateRight(no);
			}else {
				rotateLeft(no.left);
				rotateRight(no);
			}
		}
		
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        Rotacao rot = new Rotacao();
        for (int i=0; i<nums.length; i++) {
        	rot.insert(Integer.parseInt(nums[i]));
        }
        rot.preOrder();
	}


}
