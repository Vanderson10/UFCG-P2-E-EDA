package Lab9;

import java.util.HashMap;
import java.util.Scanner;

class WordCloud {
	
public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] frase = sc.nextLine().split(" ");
		
		for(String palavra : frase) {
			if(map.containsKey(palavra)) {
				map.put(palavra, map.get(palavra)+1);
			}else {
				map.put(palavra, 1);
			}
		}
		
		String opcao = sc.next();
		while(!opcao.equals("fim")) {
			System.out.println(map.get(opcao));
			opcao = sc.next();
		}
	}

}
