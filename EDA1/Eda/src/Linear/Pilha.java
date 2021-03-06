package Linear;

import java.util.Arrays;

public class Pilha {

    private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(int n) {
        
        if (this.isFull())
            throw new RuntimeException("FullStackException");
        this.topo += 1;
        this.pilha[topo] = n;
    }
    
    public int pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }
    
    public void pop(int index) {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        int[] aux = new int[this.capacidade];
        int top = this.topo;
        for (int i=0; i<this.pilha.length; i++){
            if (i==index){
            	top -=1;
            } else {
            	aux[i] = this.pilha[top];
            }
            top--;
        }
        this.pilha = aux;
    }

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }
    
    

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        pilha.push(10);
        pilha.push(2);
        pilha.push(4);
        pilha.push(14);
        pilha.push(9);
        pilha.pop(2);
        
    }
}
