package SamuelAbuchain;

public class clsDolar extends clsMoeda {

	public clsDolar(double valor) {
		// Chama o construtor da classe clsMoeda passando o valor da moeda como parametro
		super(valor); 
	}

	// Retorna o valor da moeda
	@Override
	public double obterValor() {
		return valor; 
	}

	// Retorna a descrição da moeda
	@Override
	public String obterDescricao() {
		return "Dólar"; 
	}
}