import java.util.Arrays;
import java.util.Scanner;

class FuraFilaAndreza {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] lista = sc.nextLine().split(" ");
		int num = sc.nextInt();
		int auxiliar = 0;
		int local = 0;
		for (int m=0; m<lista.length;m++) {
			if (m==num) {
				for (int n=m; n!=local; n--) {
					auxiliar = Integer.parseInt(lista[n]);
					lista[n]=lista[n-1];
					lista[n-1]=Integer.toString(auxiliar);
					
				}
				num+=1;
				local+=1;
				System.out.println(Arrays.toString(lista));
			}
		}
	}
}