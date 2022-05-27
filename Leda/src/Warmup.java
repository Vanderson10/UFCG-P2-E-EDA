import java.util.Scanner;

class Warmup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        String resultado = "";

        for (int i=0; i<nums.length; i++) {
            resultado += Integer.toString((Integer.parseInt(nums[i])*n))+" ";
        }

        System.out.println(resultado.trim());
    }

}
