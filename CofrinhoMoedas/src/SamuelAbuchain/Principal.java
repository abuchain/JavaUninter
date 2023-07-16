package SamuelAbuchain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		// Cria um objeto da classe clsCofrinho
		clsCofrinho cofrinho = new clsCofrinho(); 
		
		// Cria um objeto Scanner para entrada de dados do usuário
		Scanner scanner = new Scanner(System.in); 

		int opcao;
		do {
			// Monta o menu
			System.out.println("----- Menu -----");
			System.out.println("1. Listar moedas");
			System.out.println("2. Adicionar moeda");
			System.out.println("3. Remover moeda");
			System.out.println("4. Total convertido em Reais");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				// Lê a opção escolhida pelo usuário
				opcao = scanner.nextInt(); 
				scanner.nextLine();

				switch (opcao) {
				case 1:
					// Chama o método listadeMoedas() da classe clsCofrinho para listar as moedas
					cofrinho.listadeMoedas(); 
					break;
				case 2:
					// Chama o método incluirMoeda() para adicionar uma moeda ao cofrinho
					incluirMoeda(cofrinho, scanner); 
					break;
				case 3:
					// Chama o método retirarMoeda() para remover uma moeda do cofrinho
					retirarMoeda(cofrinho, scanner); 
					break;
				case 4:
					// Calcula o valor total das moedas convertido para Real
					System.out.println("Valor total no cofrinho em Real: " + cofrinho.calcularTotalReal()); 
					break;
				case 0:
					// Encerra o programa
					System.out.println("Encerrando o programa."); 
					break;
				default:
					// Mensagem exibida quando a opção escolhida pelo usuário é inválida
					System.out.println("Opção inválida. Tente novamente."); 
				}
			} catch (InputMismatchException e) {
				// Mensagem exibida quando a opção escolhida pelo usuário não é um número
				System.out.println("Opção inválida. Tente novamente."); 
				opcao = -1;
				scanner.nextLine();
			}
			System.out.println();
		} while (opcao != 0);

		scanner.close();
	}

	private static void incluirMoeda(clsCofrinho cofrinho, Scanner scanner) {
		System.out.println("Informe o valor da moeda: ");
		// Obtem o valor da moeda informado pelo usuário
		double valor = scanner.nextDouble(); 
		scanner.nextLine(); 

		System.out.println("Informe o tipo de moeda (1 - Dólar, 2 - Euro, 3 - Real): ");
		// Obtem o tipo de moeda informado pelo usuário
		int tipo = scanner.nextInt(); 
		scanner.nextLine();

		clsMoeda moeda;
		switch (tipo) {
		case 1:
			// Cria um objeto da classe clsDolar com o valor informado pelo usuário
			moeda = new clsDolar(valor); 
			break;
		case 2:
			// Cria um objeto da classe clsEuro com o valor informado pelo usuário
			moeda = new clsEuro(valor);
			break;
		case 3:
			// Cria um objeto da classe clsReal com o valor informado pelo usuário
			moeda = new clsReal(valor); 
			break;
		default:
			// Mensagem exibida quando o tipo de moeda informado pelo usuário é inválido
			System.out.println("Tipo de moeda inválido. Moeda não adicionada."); 
			return;
		}

		// Chama o método incluirMoeda() da classe clsCofrinho para adicionar a moeda ao cofrinho
		cofrinho.incluirMoeda(moeda); 
	}

	private static void retirarMoeda(clsCofrinho cofrinho, Scanner scanner) {
		// Chama o método listadeMoedas() da classe clsCofrinho para listar todas as moedas do cofrinho
		cofrinho.listadeMoedas(); 
		System.out.println("Informe o índice da moeda a ser removida: ");
		
		// Obtem o índice da moeda informado pelo usuário
		int indice = scanner.nextInt(); 
		scanner.nextLine(); 

		// Chama o método retirarMoeda() da classe clsCofrinho para remover a moeda informda pelo usuário do cofrinho
		cofrinho.retirarMoeda(indice); 
	}
}
