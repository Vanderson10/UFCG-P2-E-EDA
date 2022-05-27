import java.util.Scanner;

class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] frase = sc.nextLine().split(" ");
		String[] stops = sc.nextLine().split(" ");
		String saida = "";
		for (String palavra : frase) {
			if (EhStop(palavra, stops)==false) {
				saida+=palavra+" ";
			}
		}
		System.out.println(saida.trim());
	}
	
	private static boolean EhStop(String palavra, String[] stops) {
		for (String stop:stops) {
			if (stop.equals(palavra)) {
				return true;
			}
		}
		return false;
	}

}
