package Lab8;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

class InvertePilha {

	static class Pilha {
		
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
	        aux.push(maior);
	        while (!isEmpty()) {
	            int elemento = this.pop();
	            if (elemento>maior) {
	                maior = elemento;
	            }
	            aux.push(elemento);
	        }

	        while(!aux.isEmpty()) {
	            this.push(aux.pop());
	        }
	        return maior;
	    }
	    
	    public int getSize() {
	        return this.topo + 1;
	    }
	    
	    public int[] OrdenaPilhaInvertendo() {
	    	Pilha aux = new Pilha(this.size());
	    	for (int i = 0; i<this.size();i++) {
	    		aux.push(this.getMax());
	    		aux.removeMax(this.getMax());
	    	}
	    	return aux.pilha;
	    }
	    
	    public void removeMax(int max) {
	    	boolean ja = false;
	    	Pilha aux = new Pilha(this.size()-1);
	        int maior = max;
	        int i =0;
	        while (i<this.size()-1) {
	            int elemento = this.pop();
	            if (elemento!=maior && ja==false) {
	            	aux.push(elemento);
	            } else {
	            	ja = true;
	            }
	            i++;
	        }

	        int j =0;
	        while(i<this.size()-1) {
	            this.push(aux.pop());
	            j++;
	        }
	    }
	    
	    public static void main(String [] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int capacidade = sc.nextInt();
	    	Pilha p = new Pilha(capacidade);
	    	for(int n = 0; n < capacidade; n++) {
	    		int e = sc.nextInt();
	    		p.push(e);	
	    	}
	    	System.out.println("-");
	    	int[] lista = p.OrdenaPilhaInvertendo();
	    	System.out.println(Arrays.toString(lista));
		}
	}

}
