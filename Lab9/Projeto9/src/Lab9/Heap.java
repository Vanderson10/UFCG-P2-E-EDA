package Lab9;

import java.util.Arrays;
import java.util.Scanner;

class Heap {
	
	private int[] heap;
    private int tail;
    
    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }
    
    public boolean isEmpty() {
        return this.tail == -1;
    }
    
    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (index-1)/2;
    }
    
    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--)
            heapify(i); 
    }
    
    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) 
            return;
        
        int index_max = max_index(index, left(index), right(index));
        
        if (index_max != index) {
                swap(index, index_max);
                heapify(index_max);
        }
    }  
    
    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
           
            return index;
        
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] valores = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
        	valores[i] = Integer.parseInt(nums[i]);
        }
        Heap heap = new Heap(valores);
        System.out.println(Arrays.toString(heap.heap));
	}
    

}
