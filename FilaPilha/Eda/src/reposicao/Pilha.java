package reposicao;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

//OrdenaPilhaInvertendo

class Pilha {
	
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

    public void push(int n) {
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

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }
    
    public int size() {
        return this.topo + 1;
    }

    public int getMax() {
    	if (isEmpty()) throw new EmptyStackException();
    	
    	Pilha aux = new Pilha(this.size());
        int maior = this.pop();
        int ultimo = this.pop();
        aux.push(maior);
        int indexMaior = 0;
        int cont = size()-1;
        while (!isEmpty()) {
            int elemento = this.pop();
            if (elemento>maior) {
                maior = elemento;
                indexMaior = cont;
            }
            aux.push(elemento);
            cont--;
        }

        while(!aux.isEmpty()) {
            this.push(aux.pop());
        }

        if(maior == ultimo) {
            return -1;
        }
        return indexMaior; 
    }
    
    public int[] invertePilhaIndex(int index) {
    	int cont = 0;
    	int[] aux = new int[this.capacidade-index];
    	Pilha pilhaAux = new Pilha(this.capacidade);
  
    	while(cont <= index) {
    		aux[cont] = this.pop();
    		cont++;
    	}
    	
    	for(int i = 0; i < aux.length; i++) {
    		this.push(aux[i]);
    	}
    	
    	while(!isEmpty()) {
    		pilhaAux.push(this.pop());
    	}
    	return this.pilha;
    }
    
    public int[] OrdenaPilhaInvertendo() {
    	this.getMax();
    	return this.pilha;
    }
	
	public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	int capacidade = sc.nextInt();
    	Pilha pilha = new Pilha(capacidade);
    	Pilha aux = new Pilha(capacidade);
    	
    	for(int n = 0; n < capacidade; n++) {
    		int e = sc.nextInt();
    		pilha.push(e);	
    	}
    	System.out.println("-");
    	int index = pilha.getMax();
    	System.out.println(index);
    	System.out.println(Arrays.toString(pilha.invertePilhaIndex(index)));
    	int[] lista = pilha.OrdenaPilhaInvertendo();
    	
//    	for (int i=0; i<lista.length; i++) {
//    		System.out.println(lista[i]);
//    	}
    }

}