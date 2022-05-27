import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        String auxiliar = "";
        int i = 1;
        while (i<sequencia.length) {
        	auxiliar = sequencia[i-1];
        	sequencia[i-1] = sequencia[i];
        	sequencia[i] = auxiliar;
            i = i+2;
        }
        System.out.println(Arrays.toString(sequencia));
    }

}