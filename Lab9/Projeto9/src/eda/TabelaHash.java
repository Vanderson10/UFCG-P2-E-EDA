package eda;

class TabelaHash {
	
	private int tabelaInt[];
	private Aluno[] tabela;
	 
	public TabelaHash() {
		this.tabela = new Aluno[20];
    } 
	
	private int hash(int chave) {
        return chave % this.tabela.length;
    }
    
    public Aluno get(int chave) {
        int hash = hash(chave);
        return this.tabela[hash];
    }  

    public void put(int chave, Aluno valor) {
        int hash = hash(chave);
        this.tabela[hash] = valor;
    }  

    public Aluno remove(int chave) {
        int hash = hash(chave);
        Aluno aluno = this.tabela[hash];
        this.tabela[hash(chave)] = null;
        return aluno;
    }  
	
	public static void main(String[] args) {
	    Aluno[] alunos = new Aluno[20];

	    Aluno joao = new Aluno(10, "João Arthur");

//	    // inserindo em tempo constante
//	    alunos[joao.getMatricula()] = joao;
//
//	    // buscando em tempo constante
//	    if (alunos[joao.getMatricula()] != null)
//	        ...
//
//	    // removendo em tempo constante
//	    alunos[joao.getMatricula()] = null
	}
	

}
