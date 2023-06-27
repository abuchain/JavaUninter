package abuchain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> listaNomes = new ArrayList<String>();
		
		System.out.println("Digite a quantidade de nome :");
		int qtde = teclado.nextInt();
		
		String nome;
		
		for(int i=0; i<qtde; i++)
		{
			nome = teclado.next();
			listaNomes.add(nome);
		}
		
		System.out.println("Lista Nomes Normal:");
		System.out.println(listaNomes);
		
		Collections.reverse(listaNomes);
		
		System.out.println("Lista Nomes Invertido:");
		System.out.println(listaNomes);
		
	}

}
