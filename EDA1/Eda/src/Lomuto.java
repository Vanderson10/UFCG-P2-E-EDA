import java.util.Arrays;
import java.util.Scanner;

class Lomuto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" ");
		particao(lista, lista.length-1, 0);
	}
	
	public static void particao(String[] valores, int left, int right) {
        boolean troca = false;
        int pivot = Integer.parseInt(valores[left]);
        int i = left;

        for (int j = left -1; j >= right; j--) {
            if (Integer.parseInt(valores[j]) >= pivot) {
            	i--;
                int aux = Integer.parseInt(valores[j]);
                valores[j] = valores[i];
                valores[i] = Integer.toString(aux);
                troca = true;
            }
            if (troca==true) {
            	System.out.println(Arrays.toString(valores));
            }
            troca=false;
        }
        int aux = Integer.parseInt(valores[left]);
        valores[left] = valores[i];
        valores[i] = Integer.toString(aux);
        System.out.println(Arrays.toString(valores));
        System.out.println(Arrays.toString(valores));
    }

}