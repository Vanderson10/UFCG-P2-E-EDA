package Lab9;

import java.util.Scanner;

public class Teste {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("a) Ler uma string s1");
        System.out.println("b) Imprimir tamanho da string s1");
        System.out.println("c) Comparar a string s1 com a string s2");
        System.out.println("d) Concatenar a string s1 com a string s2");
        System.out.println("e) Imprimir a string s1 de forma inversa");
        System.out.println("x) Sair do programa");
        String escolha = sc.nextLine();
        
        while (escolha!="x") {
        	if (escolha.equalsIgnoreCase("a")) {
        		String s1 = sc.nextLine();
        		if (escolha.equalsIgnoreCase("b")) {
                    System.out.println(imprimirTamanho(s1));
                }
            	if (escolha.equalsIgnoreCase("c")) {
            		System.out.println("Digite a string s2:");
            		String s2 = sc.nextLine();
            		System.out.println(comparar(s1, s2));
            		if (escolha.equalsIgnoreCase("d")) {
                		System.out.println(concatenar(s1, s2));
                	}
            	}
            	if (escolha.equalsIgnoreCase("e")) {
            		System.out.println(imprimirInversa(s1));
            	}
            } 
        	escolha = sc.nextLine();
        }
        
    }
    
    private static int imprimirTamanho(String s1) {
    	return s1.length();
    }
    
    private static String comparar(String s1, String s2) {
    	if (s1.equalsIgnoreCase(s2)) {
            return "Strings iguais";
        } else {
            return "Strings diferentes";
        }
    }
    
    private static String concatenar(String s1, String s2) {
    	return s1 + " " + s2;
    }
    
    private static String imprimirInversa(String s1) {
    	return new StringBuilder(s1).reverse().toString();
    }
}