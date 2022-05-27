import java.util.Scanner;

public class MelhorPivotAndreza {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sequencia = sc.nextLine().split(" "); 
		String[] numeros = sc.nextLine().split(" ");
		int index1 = Integer.parseInt((numeros[0]));
		int index2 = Integer.parseInt(numeros[1]);
		int soma = 0;
		//calcula a media
		for (int i=0; i<sequencia.length;i++) {
			soma+= Integer.parseInt(sequencia[i]);
		}
		int media = soma/sequencia.length;
		
		int dif1 = diferenca(Integer.parseInt(sequencia[index1]),media);
		int dif2 = diferenca(Integer.parseInt(sequencia[index2]), media);
		
		if (dif1<=dif2) {
			System.out.println(index1);
		}else {
			System.out.println(index2);
		}
		
	}
	
	private static int diferenca(int num1,int num2) {
		int sub = num1-num2;
		if (sub<0) {
			return sub*-1;
		}
		return sub;
	}

}
