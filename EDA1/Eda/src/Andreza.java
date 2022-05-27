import java.util.Arrays;
import java.util.Scanner;

class Andreza {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] fila = sc.nextLine().split(" ");
		int index = sc.nextInt();
		String mediadora = "";
		
		for(int i = index; i < fila.length-1 ; i++) {
			for(int j = i; j >= 0 ; j--) {
				mediadora = fila[j];
				fila[j] = fila[j+1];
				fila[j+1] = mediadora;
			}
		}
		
		System.out.println(Arrays.toString(fila));
		
	}

}