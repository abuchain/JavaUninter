package SamuelAbuchain;

public class clsDolar extends clsMoeda {

	public clsDolar(double valor) {
		super(valor);
	}

	@Override
	public double obterValor() {
		return valor;
	}

	@Override
	public String obterDescricao() {
		return "Dólar";
	}
}