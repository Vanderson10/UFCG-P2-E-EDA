import java.util.Arrays;
import java.util.Scanner;

class MoveTres {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = sc.nextLine().split(" "); 
		int contDiferente = 0; 
		boolean entrou = false;
		
		for (int i = 1; i < nums.length; i++) { 
			int j = i;
			while (j > 0 && Integer.parseInt(nums[j]) < Integer.parseInt(nums[j-1])) {
				String aux = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = aux;
				j -= 1;
				entrou = true; 
				System.out.println(Arrays.toString(nums));
			}
			if (entrou==true) {
				contDiferente++;
				entrou = false;
			}
			if (contDiferente==3) {
				System.exit(0);
			}
		}	
	}

}
