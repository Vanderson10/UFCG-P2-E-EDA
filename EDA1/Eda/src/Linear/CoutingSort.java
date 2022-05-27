package Linear;

import java.util.Scanner;

class CoutingSort {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] A = sc.nextLine().split(" "); 
		int k = sc.nextInt();
		countingSort(converteLista(A), k);
	}
	
	public static void countingSort(int[] A, int k) {
	    
        int[] C = new int[k+1];

        // frequência
        for (int i = 0; i < A.length; i++) {
            C[A[i]] += 1;
            imprime(C, false);
        }
        
        // cumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
        imprime(C, true);

        int[] B = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] -= 1;
        }
        imprime(C, false);
        imprime(B, false);
	}
	
	private static int[] converteLista(String[] lista) {
		int[] listaInt = new int[lista.length]; 
		for (int i = 0; i < lista.length; i++) {
			listaInt[i] = Integer.parseInt(lista[i]);
		}
		return listaInt;
	}
	
	private static void imprime(int[] lista, boolean cumulativa) {
		String saida = "";
		for (int i = 0; i < lista.length; i++) {
			saida+= Integer.toString(lista[i])+" ";
		}
		if (cumulativa == true) {
			System.out.println("Cumulativa do vetor de contagem - "+saida.trim()); 
		}else {
			System.out.println(saida.trim());
		}
		
	}
	
}
