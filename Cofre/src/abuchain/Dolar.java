package abuchain;

public class Dolar extends Moeda {

	public Dolar(double valor) {
		super(valor, "Dólar");
	}

	@Override
	public double getValor() {
		return _valor;
	}

	// Converte o valor da moeda em dólar para o valor em Real
	public double convertReal(){
		return _valor * 5;
	}

	@Override
	public String getDescricao() {
		return _nome;
	}
}
