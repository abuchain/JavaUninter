package SamuelAbuchain;

import java.util.ArrayList;
import java.util.List;

public class clsCofrinho {
	private List<clsMoeda> lstmoedas;

	public clsCofrinho() {
		lstmoedas = new ArrayList<>();
	}

	public void incluirMoeda(clsMoeda moeda) {
		lstmoedas.add(moeda);
		System.out.println("Moeda incluida no cofrinho: " + moeda.obterDescricao());
	}

	public void retirarMoeda(int indice) {
		if (indice >= 0 && indice < lstmoedas.size()) {
			clsMoeda _moedaExcluida = lstmoedas.remove(indice);
			System.out.println("Moeda retirada do cofrinho: " + _moedaExcluida.obterDescricao());
		} else {
			System.out.println("Índice inválido.");
		}
	}

	public void listadeMoedas() {
		if (!lstmoedas.isEmpty()) {
			System.out.println("Moedas no Cofrinho ");

			System.out.println("Moedas no cofrinho:");
			for (int i = 0; i < lstmoedas.size(); i++) {
				clsMoeda moeda = lstmoedas.get(i);
				System.out.println(i + ": " + moeda.obterDescricao() + " - Valor: " + moeda.obterValor());
			}

			System.out.println(" ");
		} else {
			System.out.println("O cofrinho está sem moedas.");
		}
	}

	public double calcularTotalReal() {
		double valorTotal = 0;
		for (clsMoeda moeda : lstmoedas) {
			if (moeda.obterDescricao().equals("Real")) {
				valorTotal += moeda.obterValor();
			} else if (moeda.obterDescricao().equals("Dólar")) {
				valorTotal += moeda.obterValor() * 5;
			} else if (moeda.obterDescricao().equals("Euro")) {
				valorTotal += moeda.obterValor() * 6;
			}
		}
		return valorTotal;
	}
}