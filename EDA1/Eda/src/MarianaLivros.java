import java.util.Scanner;

class MarianaLivros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] livros = sc.nextLine().split(","); 
		for (int i = 1; i < livros.length; i++) { 
			
			int j = i;
			
			while (j > 0 && livros[j].compareTo(livros[j-1])<0) {
				String aux = livros[j];
				livros[j] = livros[j - 1];
				livros[j - 1] = aux;
				j -= 1;
			}
			imprimeLivros(livros);
		}
	}
	
	private static void imprimeLivros(String[] livros) {
		String saida = "";
		for (int i = 0; i < livros.length; i++) {
			if (i==livros.length-1) {
				saida += livros[i];
			}else {
				saida += livros[i]+", ";
			}
		}
		System.out.println(saida);
	}

}
