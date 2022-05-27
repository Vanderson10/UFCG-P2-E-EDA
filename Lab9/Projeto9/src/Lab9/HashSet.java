package Lab9;

import java.util.Arrays;
import java.util.Scanner;

class HashSet {
    
    private Integer[] tabela;
    
    public HashSet(int tamanho) {
        this.tabela = new Integer[tamanho];
        autoPreenchimento();
    }
    
    private void autoPreenchimento() {
        for (Integer valor: this.tabela) {
            valor = null;
        }
    }
    
    private int hash(int valor) {
        return valor % this.tabela.length;
    }
    
    public void put(int valor) {            
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {   
            hash = (hash(valor) + sondagem) % tabela.length;
            if(contains(valor) == true) {
                return;
            }
            if (tabela[hash] == null){
                    tabela[hash] = valor;
                    return;
            } 
            sondagem += 1;
        }
    }
    
    public Boolean contains(int valor) {
        for (Integer num : this.tabela) {
            if (num !=null && valor==num) {
                return true;
            }
        }
        return false;
    }
    
    public void remove(int valor) {       
        //true representa elementos apagados em algum momento
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {   
            hash = (hash(valor) + sondagem) % tabela.length;
            if (tabela[hash] != null && tabela[hash] == valor) {
                    tabela[hash] = null;
                    return;
            } 
            sondagem += 1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        HashSet hashset = new HashSet(tamanho);
        String entrada = "";
        while(!entrada.equals("end")) {
            String[] operacao = entrada.split(" ");    
            if (operacao[0].equals("put")) {
                hashset.put(Integer.parseInt(operacao[1]));
                System.out.println(Arrays.toString(hashset.tabela));
            } else if (operacao[0].equals("remove")) {
                hashset.remove(Integer.parseInt(operacao[1]));
                System.out.println(Arrays.toString(hashset.tabela));
            } else if (operacao[0].equals("contains")) {
                System.out.println(hashset.contains(Integer.parseInt(operacao[1])));
            } 
            entrada = sc.nextLine();
        }    
    }

}