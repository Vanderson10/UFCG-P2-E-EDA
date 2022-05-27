import java.util.Scanner;

class TopN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int quant = sc.nextInt();
		
		for (int i = 0; i < valores.length; i++) {
			int i_menor = i;
			for (int j = i + 1; j < valores.length; j++)
				if (Integer.parseInt(valores[j]) < Integer.parseInt(valores[i_menor])) {
					i_menor = j;
				}
			String aux = valores[i];
			valores[i] = valores[i_menor];
			valores[i_menor] = aux;
		}	
		
		String resultado = "";
		int j = 1;
		while (j !=quant+1){
			resultado +=valores[valores.length-j]+" ";
			j+=1;
		}
		System.out.println(resultado.trim());
	}

}
