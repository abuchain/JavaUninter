package SamuelAbuchain;

import java.util.ArrayList;
import java.util.List;

public class clsCofrinho {
	private List<clsMoeda> lstmoedas; 

	public clsCofrinho() {
		lstmoedas = new ArrayList<>(); 
	}

	// Adiciona uma moeda à lista de moedas
	public void incluirMoeda(clsMoeda moeda) {
		lstmoedas.add(moeda); 
		System.out.println("Moeda incluida no cofrinho: " + moeda.obterDescricao());
	}

	// Remove uma moeda da lista pelo índice fornecido pelo usuário
	public void retirarMoeda(int indice) {
		if (indice >= 0 && indice < lstmoedas.size()) {
			clsMoeda _moedaExcluida = lstmoedas.remove(indice); 
			System.out.println("Moeda retirada do cofrinho: " + _moedaExcluida.obterDescricao());
		} else {
			System.out.println("Índice inválido.");
		}
	}

	// Lista todas as moedas do cofrinho
	public void listadeMoedas() {
		if (!lstmoedas.isEmpty()) { 
			System.out.println(" ");
			System.out.println("Moedas no cofrinho:");
			for (int i = 0; i < lstmoedas.size(); i++) {
				clsMoeda moeda = lstmoedas.get(i); 
				System.out.print(i + ": " + moeda.obterDescricao() + " - Valor: ");
				System.out.printf("%.2f%n", moeda.obterValor());

			}
			System.out.println(" ");
		} else {
			System.out.println(" ");
			System.out.println("O cofrinho está vazio."); 
		}
	}

	// Calcula o valor em reais de todas as moedas do cofrinho
	public double calcularTotalReal() {
		double valorTotal = 0;
		// Percorre cada moeda na lista de moedas
		for (clsMoeda moeda : lstmoedas) { 
			// Se a moeda for Real, adiciona seu valor ao valor total
			if (moeda.obterDescricao().equals("Real")) {
				valorTotal += moeda.obterValor(); 
			} 
			// Se a moeda for Dólar, converte para Real e adiciona ao valor total
			else if (moeda.obterDescricao().equals("Dólar")) {
				valorTotal += moeda.obterValor() * 5; 
			} 
			// Se a moeda for Euro, converte para Real e adiciona ao valor total
			else if (moeda.obterDescricao().equals("Euro")) {
				valorTotal += moeda.obterValor() * 6; 
			}
		}
		return valorTotal;
	}
}
