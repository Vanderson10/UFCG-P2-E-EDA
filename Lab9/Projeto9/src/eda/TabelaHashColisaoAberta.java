package eda;

public class TabelaHashColisaoAberta {
	
	private Aluno[] tabela;
	 
	public TabelaHashColisaoAberta() {
		this.tabela = new Aluno[20];
    } 
	
	private int hash(int chave) {
        return chave % this.tabela.length;
    }
	
	public void put(int chave, Aluno valor) {       
        
	    int sondagem = 0;
	    int hash;
	    while (sondagem < tabela.length) {   
	        hash = (hash(chave) + sondagem) % tabela.length;
//	        if (tabela[hash] == null || tabela[hash].getMatricula() == chave || tabela[hash].equals(APAGADO)) {
	                tabela[hash] = valor;
	                return;
	        } 
	        sondagem += 1;
	    }
//	    throw new TabelaCheiaException();
//	}
	
	private void resize() {
//		if ( (this.size / this.tabela.length) >= this.fatorDeCarga) {
//		    resize()
//		}
	}

}
