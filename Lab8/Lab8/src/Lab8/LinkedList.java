package Lab8;

import java.util.NoSuchElementException;
import java.util.Scanner;

class LinkedList {
	
	class Node {
		
		int num;
	    Node next;
	    Node prev;
	    
	    public Node(int num) {
	        this.num = num;
	        this.prev = null;
	        this.next = null;
	    }   

	}
	
	private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void addLast(int num) {
        Node newNode = new Node(num);
            
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }

        this.size += 1;
    }
    
    public Node get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
            
        Node aux = this.head;
            
        for (int i = 0; i < index; i++)
            aux = aux.next;
            
        return aux;
    }
    
    public void trocaVizinhoIndex(int index) {
    	Node elemento = get(index);
    	Node prox = get(index+1);
    	
    	if (index==0) {
    		elemento.next = prox.next;
    		elemento.next.prev = prox;
    		elemento.prev = prox;
    		prox.next = elemento;
  		    this.head = prox;
    	} else if(index == size-2) {
    		elemento.next = prox.next;
    		prox.prev = elemento.prev;
    		prox.prev.next = prox;
    		elemento.prev = prox;
  		  	prox.next = elemento; 
  		  	this.tail = prox;
    	} else {
    		prox.next.prev = elemento;
        	elemento.prev.next = prox;
        	elemento.next = prox.next;
        	prox.next = elemento;
        	prox.prev = elemento.prev;
        	elemento.prev = prox;
    	}
   }
    
    public int getSize() {
    	return this.size;
    }
    
    
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] elementos = sc.nextLine().split(" ");
		LinkedList linked = new LinkedList();
		for(int n = 0; n < elementos.length; n++) {
    		linked.addLast(Integer.parseInt(elementos[n]));
    	}
		int index = sc.nextInt();
		linked.trocaVizinhoIndex(index);
		String saida = "";
		for (int i=0; i<linked.getSize();i++) {
			saida+=linked.get(i).num+" ";
		}
		System.out.println(saida.trim());
	}

}





