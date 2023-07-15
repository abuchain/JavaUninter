package abuchain;

public class Euro extends Moeda {
 
	public Euro(double valor) {
     super(valor, "Euro");
 }

 @Override
 public double getValor() {
     return valor;
 }
 
 public double convertReal(){
	 return valor * 6;
 }
 
 
 @Override
 public String getDescricao() {
     return nome;
 }
}
