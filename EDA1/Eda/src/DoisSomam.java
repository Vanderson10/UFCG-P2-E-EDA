import java.util.Scanner;

class DoisSomam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = sc.nextLine().split(" ");
		int num = sc.nextInt();
		int soma=0;
		String resultado="-1";
		for (int i=0; i<nums.length;i++) {
			for (int t=0; t<nums.length;t++) {
				if (i!=t) {
					soma = Integer.parseInt(nums[i])+Integer.parseInt(nums[t]);
					if (soma==num) {
						resultado = nums[t]+" "+nums[i];
						break;
					}
					
				}
			}
		}
		System.out.println(resultado);
	}

}
