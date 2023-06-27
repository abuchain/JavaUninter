package abuchain;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int palpite;
		int valorCorreto = 10000;
		
		System.out.println("Digite o palpite: ");
		palpite = teclado.nextInt();
		
		while(palpite != valorCorreto)
		{
			if(palpite > valorCorreto) {
				System.out.println("Um pouco menos ...");
			}
			else {
				System.out.println("Um pouco mais ...");
			}
			
			System.out.println("Digite outro palpite: ");
			palpite = teclado.nextInt();
		}
				
		System.out.println("Parabens, voce acertou !!! ");
	}

}
