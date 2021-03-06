import java.util.Scanner;

class InverteFrase {

    private String[] pilha; 
    private int capacidade;
    private int topo;

    public InverteFrase(int capacity){
      this.capacidade = capacity;
      this.topo = -1;
      this.pilha = new String[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(String p) {
        
        if (this.isFull())
            throw new RuntimeException("FullStackException");
        this.topo += 1;
        this.pilha[topo] = p;
    }
    
    public String pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        String valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }

    public String peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }

  public void addPilha(String frase){
    String palav = "";
      for(int i=0; i < frase.length(); i++){
        if(frase.charAt(i) == ' '){
          this.push(palav);
          palav = "";
        }else{
          palav += frase.charAt(i);
        }
      }
        
  }
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String entrada = sc.nextLine();
    int capac = getCapacidade(entrada);
    InverteFrase pilha = new InverteFrase(capac);
    pilha.addPilha(entrada+" ");

    String result="";
    for(int j=0; j < capac; j++){
      result += pilha.pop() + " ";
    }
    System.out.println(result.trim());
  }

   public static int getCapacidade(String frase){
     int soma = 0;
     for(int i=0; i < frase.length(); i++){
       if(frase.charAt(i) == ' '){
         soma += 1;
       }
     }
      return soma+1;
    }

} 

