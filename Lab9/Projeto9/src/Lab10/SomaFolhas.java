package Lab10;

import java.util.Scanner;

public class SomaFolhas {
	
class Node {
	    
	    int value;
	    Node left;
	    Node right;
	    Node parent;
	    
	    Node(int v) {
	        this.value = v;
	    }
	    
	}

	private Node root;
	
	private int soma;
	
	public boolean isEmpty() {
        return this.root == null;
    }
    
    public SomaFolhas() {
	}
	
	public void add(int element) {      
        if (isEmpty())
            this.root = new Node(element);
        else {
                
            Node aux = this.root;
                
            while (aux != null) {
                    
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                        
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                        
                    aux = aux.right;
                }
            }
        }
            
    }
	
	public void somaFolhas() {
	    somaFolhas(this.root);
	}

	private void somaFolhas(Node node) { 
	    if (node != null) {
	    	if (node.left==null && node.right==null) {
	    		this.soma+=node.value;
	    	}
	        somaFolhas(node.left);
	        somaFolhas(node.right);
	    }
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        SomaFolhas soma = new SomaFolhas();
        for (String num : (nums)) {
        	soma.add(Integer.parseInt(num));
        }
        soma.somaFolhas();
        System.out.println(soma.soma);
	}

}
