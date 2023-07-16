package SamuelAbuchain;

public class clsReal extends clsMoeda {

	public clsReal(double valor) {
		super(valor);
	}

	@Override
	public double obterValor() {
		return valor;
	}

	@Override
	public String obterDescricao() {
		return "Real";
	}
}
