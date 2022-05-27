import java.util.Arrays;
import java.util.Scanner;

class FuraFila {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nums = sc.nextLine().split(" ");
		int indice = sc.nextInt();
		int t = 0;
		int posicao = 0;
		int aux = 0;
		for (int i=0; i<nums.length;i++) {
			if (i==indice) {
				t=indice;
				while(t!=posicao) {
					aux=Integer.parseInt(nums[t]);
					nums[t]=nums[t-1];
					nums[t-1]= Integer.toString(aux);
					t-=1;
				}
				indice+=1;
				posicao+=1;
				System.out.println(Arrays.toString(nums));
			}
		}
	}
}