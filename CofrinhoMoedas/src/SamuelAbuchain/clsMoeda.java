package SamuelAbuchain;

// Classe abstrata de moeda
public abstract class clsMoeda {
	// Atributo para armazenar o valor da moeda
	double valor; 

	public clsMoeda(double valor) {
		super();
		// Define o valor da moeda com base no parâmetro recebido no construtor
		this.valor = valor; 
	}
	// Método abstrato para obter o valor da moeda
	abstract double obterValor(); 
	
	// Método abstrato para obter a descrição da moeda
	abstract String obterDescricao(); 
}
