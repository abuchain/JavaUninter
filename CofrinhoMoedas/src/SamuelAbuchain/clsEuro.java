package SamuelAbuchain;

public class clsEuro extends clsMoeda {

	public clsEuro(double valor) {
		super(valor);
	}

	@Override
	public double obterValor() {
		return valor;
	}

	@Override
	public String obterDescricao() {
		return "Euro";
	}
}