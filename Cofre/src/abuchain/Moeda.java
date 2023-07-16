package abuchain;

//Classe abstrata que representa uma moeda genérica
public abstract class Moeda {
	double _valor;
	String _nome;

	public Moeda(double valor, String nome) {
		super();
		this._valor = valor;
		this._nome = nome;
	}

	abstract double getValor();
	abstract double convertReal();
	abstract String getDescricao();
}
