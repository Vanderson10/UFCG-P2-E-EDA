import java.util.Scanner;

//1- criar variavel auxiliar para numeros em posições pares
//2- trocar os numeros das posições impares pelo numero anterior
//3- colocar indice para percorrer somente as posições pares (incrementar +2)

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        String auxiliar = "";
        int i = 1;
        while (i<sequencia.length) {
            auxiliar = sequencia[i-1];
            sequencia[i] = sequencia[i-1];
            i = i+2;
        }
        System.out.println(sequencia);
    }

}
