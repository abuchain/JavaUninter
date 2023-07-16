package abuchain;

public class Real extends Moeda {

	public Real(double valor) {
		super(valor, "Real");
	}

	@Override
	public double getValor() {
		return _valor;
	}

	public double convertReal(){
		return _valor;
	}


	@Override
	public String getDescricao() {
		return _nome;
	}
}
