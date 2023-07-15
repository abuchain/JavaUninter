package abuchain;

public class Dolar extends Moeda {
 
	public Dolar(double valor) {
     super(valor, "Dólar");
 }

 @Override
 public double getValor() {
     return valor;
 }
 
 public double convertReal(){
	 return valor * 5;
 }
 
 @Override
 public String getDescricao() {
     return nome;
 }
}
