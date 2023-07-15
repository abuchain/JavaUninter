package abuchain;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
	private List<Moeda> moedas;
	private List<String> tiposMoeda = new ArrayList<>();

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    // Adiciona uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada ao cofrinho: " + moeda.getDescricao());
    }

    // Remove uma moeda do cofrinho pelo índice
    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(indice);
            System.out.println("Moeda removida do cofrinho: " + moedaRemovida.getDescricao());
        } else {
            System.out.println("Índice inválido. Moeda não removida.");
        }
    }

    // Lista todas as moedas presentes no cofrinho
    public void listarMoedas() {
    	if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
        	
        	System.out.println(" ");
        	System.out.println("########## Moedas no Cofre ##########");
        	System.out.println(" ");
        	System.out.println("Codigo  | Tipo Moeda | Valor  | Valor em Real");
            System.out.println("--------|------------|--------|--------------");

            for (int i = 0; i < moedas.size(); i++) {
                Moeda moeda = moedas.get(i);
                String tipoMoeda = moeda.getDescricao();
                double valor = moeda.getValor();
                double valorReal = moeda.convertReal();
                System.out.printf("%-8d| %-11s| %-7.2f| %-13.2f%n", i, tipoMoeda, valor, valorReal);
            }
            
            System.out.println(" ");
        }
    }

    // Calcula o valor total do cofrinho convertido para Real
    public double calcularValorTotalEmReal() {
        double valorTotal = 0;
        for (Moeda moeda : moedas) {
        	valorTotal += moeda.convertReal();
        }
        return valorTotal;
    }
}
