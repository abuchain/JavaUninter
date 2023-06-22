package abuchain;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) 
	{
		int peso;
		double altura;
		double imc;
		
		System.out.println("Informe o peso e a altura :");
		
		try (Scanner teclado = new Scanner(System.in)) {
			peso = teclado.nextInt();
			altura = teclado.nextDouble();
		}
		
		imc = peso / (altura * altura);
		
		System.out.printf("O IMC e: %.2f", imc);
	}
}
