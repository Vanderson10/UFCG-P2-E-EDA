import java.util.Scanner;

class EstatisticaOrdem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" "); 
		int cont = 0;

		for (int i=0; i<lista.length;i++) {
			if (Integer.parseInt(lista[0])>=Integer.parseInt(lista[i])) {
				cont++;
			}
		}
		System.out.println(cont);
	}	
}
