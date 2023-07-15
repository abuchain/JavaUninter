package abuchain;

public class Real extends Moeda {
	 
	public Real(double valor) {
     super(valor, "Real");
 }

 @Override
 public double getValor() {
     return valor;
 }
 
 public double convertReal(){
	 return valor;
 }
 
 
 @Override
 public String getDescricao() {
     return nome;
    }
}
