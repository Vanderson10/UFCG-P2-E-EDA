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

    public int getMax(int index) {
    	if (isEmpty()) throw new EmptyStackException();
    	
    	Pilha aux = new Pilha(this.size());
    	int maior = this.pop();
    	aux.push(maior);
    	while (!isEmpty()) {
    		int e = this.pop();
    		if (e>maior) {
    			maior = e;
    		}
    		aux.push(e);
    	}
    	
    	while(!aux.isEmpty()) {
    		this.push(aux.pop());
    	}
    	return maior;
    }
	
	public void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	int capacidade = sc.nextInt();
    	Pilha pilha = new Pilha(capacidade);
    	
    	for(int n = 0; n < capacidade; n++) {
    		int e = sc.nextInt();
    		pilha.push(e);	
    	}
    	System.out.println("-");
    	
    	invertePilha(pilha, capacidade);
    }

}


    
}