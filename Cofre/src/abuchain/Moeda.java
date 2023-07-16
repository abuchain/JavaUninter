package abuchain;

// Classe abstrata que representa uma moeda genérica
public abstract class Moeda {
	double _valor;
	String _nome;

	public Moeda(double valor, String nome) {
		super();
		this._valor = valor;
		this._nome = nome;
	}

	// Método abstrato para obter o valor da moeda
	abstract double getValor();

	// Método abstrato para converter o valor da moeda para Real
	abstract double convertReal();

	// Método abstrato para obter a descrição da moeda
	abstract String getDescricao();
}
