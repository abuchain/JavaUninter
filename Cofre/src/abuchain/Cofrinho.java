package abuchain;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
	private List<Moeda> _moedas;
	private List<String> _tiposMoeda = new ArrayList<>();

	public Cofrinho() {
		_moedas = new ArrayList<>();
	}

	// Adiciona uma moeda ao cofrinho
	public void adicionarMoeda(Moeda moeda) {
		_moedas.add(moeda);
		System.out.println("Moeda adicionada ao cofrinho: " + moeda.getDescricao());
	}

	// Remove uma moeda do cofrinho pelo índice
	public void removerMoeda(int indice) {
		if (indice >= 0 && indice < _moedas.size()) {
			Moeda _moedaRemovida = _moedas.remove(indice);
			System.out.println("Moeda removida do cofrinho: " + _moedaRemovida.getDescricao());
		} else {
			System.out.println("Índice inválido. Moeda não removida.");
		}
	}

	// Lista todas as moedas presentes no cofrinho
	public void listarMoedas() {
		if (_moedas.isEmpty()) {
			System.out.println("----------------------------------");
			System.out.println("O cofrinho está vazio.");
			System.out.println("----------------------------------");
		} else {

			System.out.println(" ");
			System.out.println("########## Moedas no Cofre ##########");
			System.out.println(" ");
			System.out.println("Codigo  | Tipo Moeda | Valor  | Valor em Real");
			System.out.println("--------|------------|--------|--------------");

			for (int i = 0; i < _moedas.size(); i++) {
				Moeda _moeda = _moedas.get(i);
				String _tipoMoeda = _moeda.getDescricao();
				double _valor = _moeda.getValor();
				double _valorReal = _moeda.convertReal();
				System.out.printf("%-8d| %-11s| %-7.2f| %-13.2f%n", i, _tipoMoeda, _valor, _valorReal);
			}

			System.out.println(" ");
		}
	}

	// Calcula o valor total do cofrinho convertido para Real
	public double calcularValorTotalEmReal() {
		double _valorTotal = 0;
		for (Moeda _moeda : _moedas) {
			_valorTotal += _moeda.convertReal();
		}
		return _valorTotal;
	}
}

