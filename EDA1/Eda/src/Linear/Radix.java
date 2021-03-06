package Linear;

import java.util.Arrays;
import java.util.Scanner;

public class Radix {
	
	public static int[] countingSort(int[]a, int nthDig) {
		// estamos assumindo que não há número com o dígito 0.
		int[] c = new int[10];
		
		// freq
		for (int i = 0; i < a.length; i++) {
			int d = (int) (a[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 1));
			c[d] += 1;
		}
		
		// cumulativa
		for (int i = 1; i < c.length; i++)
			c[i] += c[i-1];
		
		int[] b = new int[a.length];
		for (int i = a.length - 1; i >=0; i--) {
			int d = (int) (a[i] % Math.pow(10, nthDig));
			d = (int) (d / Math.pow(10, nthDig - 1));
			
			b[c[d]-1] = a[i];
			c[d] -= 1;
			
		}
		
		return b;
		
	} 
	
	// estamos assumindo que todos possuem a mesma quantidade
	// de dígitos dada por nDig
	public static int[] radixSort(int[] a, int nDig) {
		
		for (int i = 1; i <= nDig; i++) {
			a = countingSort(a, i);
			System.out.println(Arrays.toString(a));
		}
		return a;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] A = sc.nextLine().split(" "); 
		int k = sc.nextInt();
		radixSort(converteLista(A), k);
		
		
	}
	
	private static int[] converteLista(String[] lista) {
		int[] listaInt = new int[lista.length]; 
		for (int i = 0; i < lista.length; i++) {
			listaInt[i] = Integer.parseInt(lista[i]);
		}
		return listaInt;
	}

}
