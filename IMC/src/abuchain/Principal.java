package abuchain;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) 
	{
		int peso;
		double altura;
		double imc;
		
		Scanner teclado = new Scanner(System.in);
		
		peso = teclado.nextInt();
		altura = teclado.nextDouble();
		
		imc = peso / (altura * altura);
		
		System.out.println(imc);
	}
}
