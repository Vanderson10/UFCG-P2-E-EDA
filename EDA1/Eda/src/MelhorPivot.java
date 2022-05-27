import java.util.Scanner;

public class MelhorPivot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" "); 
		String[] indices = sc.nextLine().split(" ");
		int conti = 0;
		int contj = 0;
		
		//contador quantos elementos são maiores
		for (int i=0; i<lista.length;i++) {
			if (Integer.parseInt(lista[Integer.parseInt(indices[0])]) >= Integer.parseInt(lista[i])) {
				conti++;
			}else if (Integer.parseInt(lista[Integer.parseInt(indices[1])]) >= Integer.parseInt(lista[i])) {
				contj++;
			}
		}
		//verificação quem é mais proximo da metade
		
		if (conti==lista.length/2) {
			System.out.println(indices[0]);
		}
		
		if (contj==lista.length/2) {
			System.out.println(indices[1]);
		}
		
		int i = conti-(lista.length/2);
		int j = contj-(lista.length/2);
		
		if (i<0){
			i = i*-1;
		}
		if (j<0) {
			j = j*-1;
		}
		
		if (i<=j) {
			System.out.println(indices[0]);
		}else {
			System.out.println(indices[1]);
		}
		
	}

}
