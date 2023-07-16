package SamuelAbuchain;

//Classe abstrata de moeda
public abstract class clsMoeda {
	double valor;

	public clsMoeda(double valor) {
		super();
		this.valor = valor;
	}

	abstract double obterValor();
	abstract String obterDescricao();
}
