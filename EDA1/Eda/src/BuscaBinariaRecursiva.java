import java.util.Scanner;

class BuscaBinariaRecursiva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nums= sc.nextLine().split(" ");
		int num = sc.nextInt();
		int inicio = 0;
		int fim = nums.length-1;
		Busca(nums, num, inicio, fim);
	}
	
	private static int Busca(String[] nums, int num, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		if (inicio <= fim) {
	        if (Integer.parseInt(nums[meio]) ==  num) {
	        	System.out.println(meio);
	        	return meio;
	        }
	        if (num < Integer.parseInt(nums[meio])) {
	        	System.out.println(meio);
	        	return Busca(nums, num, inicio, meio - 1);
	        }else {
	        	System.out.println(meio);
	        	return Busca(nums, num, meio + 1, fim);
	        }
		} else {
			System.out.println(-1);
			return -1;
		}
	}

}
