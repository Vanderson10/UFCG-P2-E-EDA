import java.util.Scanner;

class Vetor_circular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int quant = sc.nextInt();
        int i = 0;
        int e = 0;
        String resultado = "";

        while (e<quant){
            if (i==sequencia.length){
                i=0;
            }
            resultado += sequencia[i]+" ";
            i++;
            e++;
        }
        System.out.println(resultado.trim());
    }
}
