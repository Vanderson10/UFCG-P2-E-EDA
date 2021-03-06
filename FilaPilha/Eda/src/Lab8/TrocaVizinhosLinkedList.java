package Lab8;

import java.util.NoSuchElementException;
import java.util.Scanner;

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

class LinkedList {
	
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
    
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
            
        Node aux = this.head;
            
        for (int i = 0; i < index; i++)
            aux = aux.next;
            
        return aux.num;
    }
    
//    public void trocaVizinhoIndex(int index) {
//    	Node pri = this.get(index);
//    	Node prox = this.get(index+1);
//    	pri.next = prox.next
//    	pri.prev.next = aux.next;
//    	aux.next.prev = aux.prev;
//    }
    
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] elementos = sc.nextLine().split(" ");
		LinkedList linked = new LinkedList();
		for(int n = 0; n < elementos.length; n++) {
    		linked.addLast(Integer.parseInt(elementos[n]));
    	}
		int index = sc.nextInt();
		System.out.println(linked.get(index));
	}

}




