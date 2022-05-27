package Lab8;

import java.util.NoSuchElementException;

import Lab8.LinkedList.Node;

public int removeFirst() {
    
    if (isEmpty()) throw new NoSuchElementException();
        
    int num = this.head.num;
        
    if (this.head.next == null) {
        this.head = null;
        this.tail = null;
    } else {
        this.head = this.head.next;
        this.head.prev = null;
    }
        
    size -= 1;
    return num;
}
    
public int removeLast() {
        
    if (isEmpty()) throw new NoSuchElementException();
        
    int num = this.tail.num;
    
    if (this.head.next == null) {
        this.head = null;
        this.tail = null;
    } else {
        this.tail = this.tail.prev;
        this.tail.next = null;
    }           
    
    size -= 1;
    return num;

}

public int remove(int index) {
    if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
    
    if (index == 0) return removeFirst();
    if (index == size - 1) return removeLast();
    
    Node aux = this.head;
    for (int i = 0; i < index; i++)
        aux = aux.next;
    
    aux.prev.next = aux.next;
    aux.next.prev = aux.prev;
                   size -= 1;       
    return aux.num;
}
