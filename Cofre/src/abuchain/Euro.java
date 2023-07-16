package abuchain;

public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor, "Euro");
	}

	@Override
	public double getValor() {
		return _valor;
	}

	// Converte o valor da moeda em euro para o valor em Real
	public double convertReal(){
		return _valor * 6;
	}


	@Override
	public String getDescricao() {
		return _nome;
	}
}
