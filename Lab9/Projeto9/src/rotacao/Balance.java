package rotacao;

import java.util.Scanner;

class Balance {
	
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
	
	public String preOrder() {
	    return preOrder(this.root);
	}
	
	 private String preOrder(Node node) {
		 String saida = ""; 
         if (node != null) {
             saida+= node.value + "," + balance(node) + " " + preOrder(node.left) + preOrder(node.right);
         }else {
             saida+="";
         }
         return saida;
     }
	
	private int balance(Node no) {
	    if (no != null) { 
	    	return altura(no.left) - altura(no.right); 
	    }
	    return 0;
	}
	
	public int altura(Node no) {
		if(no == null) { 
			return -1; 
		}
		else {
			return 1 + Math.max(altura(no.left), altura(no.right)); 
		}
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
						return;
					}
					
					aux = aux.left;
					
				}else {
					if(aux.right == null) {
						Node newNode = new Node(newElement);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					
					aux = aux.right;
				}
			}
		}
	}
         
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        Balance balance = new Balance();
        for (int i=0; i<nums.length; i++) {
        	balance.insert(Integer.parseInt(nums[i]));
        }
        System.out.println(balance.preOrder().trim());
	}
}
