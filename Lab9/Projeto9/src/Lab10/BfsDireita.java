package Lab10;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class BfsDireita {

	
	private Node root;
	
	private ArrayList<Integer> nums;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public BfsDireita() {
    	nums = new ArrayList<>();
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
    
    public void printBFS() {
        Deque<Node> queue = new LinkedList<Node>();
            
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                    
                this.nums.add(current.value);
                    
                if(current.right != null) 
                    queue.addLast(current.right);
                if(current.left != null) 
                    queue.addLast(current.left);   
            }
        }
    }
    
    public void saida() {
    	String saida = "";
    	for (int num : this.nums) {
    		saida += Integer.toString(num)+" ";
    	}
    	System.out.println(saida.trim());
    }
	    
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        BfsDireita bfs = new BfsDireita();
        for (String num : (nums)) {
        	bfs.add(Integer.parseInt(num));
        }
        bfs.printBFS();
        bfs.saida();
	}
}
