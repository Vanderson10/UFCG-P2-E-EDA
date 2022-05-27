import java.util.Scanner;

class EstatisticaOrdem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" ");
		particao(lista, 0, lista.length-1);
	}
	
	public static void particao(String[] valores, int left, int right) {
        
        int pivot = Integer.parseInt(valores[left]);
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (Integer.parseInt(valores[j]) <= pivot) {
                i+=1;
                int aux = Integer.parseInt(valores[i]);
                valores[i] = valores[j];
                valores[j] = Integer.toString(aux);
            }
        }
        int aux = Integer.parseInt(valores[left]);
        valores[left] = valores[i];
        valores[i] = Integer.toString(aux);
        
        System.out.println(i+1);
    }

}