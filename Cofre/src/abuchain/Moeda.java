package abuchain;

//Classe abstrata que representa uma moeda genérica
public abstract class Moeda {
	 double valor;
	 String nome;
	
	 public Moeda(double valor, String nome) {
		 super();
	     this.valor = valor;
	     this.nome = nome;
	 }
	
	 abstract double getValor();
	 abstract double convertReal();
	 abstract String getDescricao();
}
