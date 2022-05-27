import java.util.Scanner;

class StopWords {
	
	public static void main(String [] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		String[] entrada = sc.nextLine().split(" ");
		String[] stopWords = sc.nextLine().split(" ");
		String resultado = "";
		boolean auxiliar = false;
		
		for(String palavra : entrada) {
			for (String p : stopWords) {
				if(palavra.equals(p)) {
					auxiliar = true;
				}
			}
			if(auxiliar == false) {
				resultado += palavra + " ";
			}
			auxiliar = false;
		}
		
		System.out.println(resultado.trim());
	}
}