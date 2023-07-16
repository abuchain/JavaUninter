package abuchain;

public class Real extends Moeda {

	public Real(double valor) {
		super(valor, "Real");
	}

	@Override
	public double getValor() {
		return _valor;
	}

	// Retorna o valor da moeda em Real
	public double convertReal(){
		return _valor;
	}


	@Override
	public String getDescricao() {
		return _nome;
	}
}
