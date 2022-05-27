package HTChaining;

import java.util.ArrayList;

import eda.Aluno;

public class HTChaining {
	
	private ArrayList[] tabela;
	
	public HTChaining(int tamanho) {
		this.tabela = new ArrayList[tamanho];
	}
	
	private int hash(int chave) {
        return chave % this.tabela.length;
    }
	
	public int[] keys() {
		ArrayList<Integer> saida = new ArrayList<>();
		for (ArrayList lista: this.tabela) {
			for (int i = 0; i < lista.size(); i++) {
				Pair pair = (Pair) lista.get(i);
				saida.add(pair.getChave());
			}
		}
		saida.sort(null);
		return saida;
	}
	
	public void put(int chave, String valor) {
		Pair pair = new Pair(chave, valor);
	    int hash = hash(chave);
	    ArrayList<Pair> pairs = this.tabela[hash];
	    
	    if (pairs == null) {
	    	pairs = new ArrayList<Pair>();
	    	pairs.add(pair);
	        this.tabela[hash] = pairs;

	    } else {
	    	//atualiza valor
	        for (int i = 0; i < pairs.size(); i++) {
	            if (pairs.get(i).getChave() == chave) {
	            	pairs.set(i, pair);
	                return;
	            }
	        }
	    
	        pairs.add(pair);
	    }    
	}   

//	public Aluno remove(int chave) {
//	    int hash = hash(chave);
//	    ArrayList<Aluno> alunos = this.tabela[hash];	    
//	    Iterator<Aluno> it = alunos.iterator();
//	    Aluno atual = null;
//	    
//	    while (it.hasNext()) {
//	        atual = it.next();
//	        if (atual.getMatricula() == chave) {
//	            it.remove();
//	            return atual;
//	        }
//	    }
//	    
//	    return atual;
//	}

}
