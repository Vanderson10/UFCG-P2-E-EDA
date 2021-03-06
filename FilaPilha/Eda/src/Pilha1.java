import java.util.Arrays;
import java.util.Scanner;

class Pilha1 {
	
	private int[] pilha;
    private int capacidade;
    private int topo;

    public Pilha1(int capacidade) {
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

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }
    
    public void inverteIndex(int indice) {
    	int[] aux1 = new int[this.capacidade];
    	int[] aux2 = new int[this.capacidade];
    	for (int i=0; i<this.capacidade;i++) {
    		if (i<indice) {
    			aux1[i] = this.pilha[i];
    			this.pilha.pop();
    		}else {
    			aux2[i] = this.pilha[i];
    		}
    	}
    	
    	System.out.println(Arrays.toString(aux1));
    	System.out.println(Arrays.toString(aux2));
    }
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		Pilha pilha = new Pilha(tamanho);
        
        for (int i=0; i<tamanho;i++) {
        	int elemento = sc.nextInt();
        	pilha.push(elemento);
        }
        int indice = sc.nextInt();
        System.out.println(Arrays.toString(pilha.pilha));
        pilha.inverteIndex(indice);
    }

}
