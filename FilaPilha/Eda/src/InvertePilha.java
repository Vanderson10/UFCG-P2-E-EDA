import java.util.Scanner;

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


    public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
	
    	int capacidade = sc.nextInt();
    	Pilha1 pilha = new Pilha1(capacidade);
    	
    	for(int n = 0; n < capacidade; n++) {
    		int e = sc.nextInt();
    		pilha.push(e);	
    	}
    	
    	invertePilha(pilha, capacidade);
    }
    
    public static void invertePilha(Pilha1 pilha, int capacidade) {
    	Pilha1 aux = new Pilha1(capacidade);
    	while(!pilha.isEmpty()) {
    		aux.push(pilha.pop());
    	}
    	
    	while(!aux.isEmpty()) {
    		System.out.println(aux.pop());
    	}
    }
}

