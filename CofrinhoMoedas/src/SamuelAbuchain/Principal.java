package SamuelAbuchain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		clsCofrinho cofrinho = new clsCofrinho();
		Scanner scanner = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("----- Menu -----");
			System.out.println("1. Listar moedas");
			System.out.println("2. Adicionar moeda");
			System.out.println("3. Remover moeda");
			System.out.println("4. Total convertido em Reais");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					cofrinho.listadeMoedas();
					break;
				case 2:
					incluirMoeda(cofrinho, scanner);
					break;
				case 3:
					retirarMoeda(cofrinho, scanner);
					break;
				case 4:
					System.out.println("Valor total no cofrinho em Real: " + cofrinho.calcularTotalReal());
					break;
				case 0:
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Opção inválida. Tente novamente.");
				opcao = -1;
				scanner.nextLine(); // Limpar o buffer do scanner
			}
			System.out.println();
		} while (opcao != 0);

		scanner.close();
	}

	private static void incluirMoeda(clsCofrinho cofrinho, Scanner scanner) {
		System.out.println("Informe o valor da moeda: ");
		double valor = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Informe o tipo de moeda (1 - Dólar, 2 - Euro, 3 - Real): ");
		int tipo = scanner.nextInt();
		scanner.nextLine();

		clsMoeda moeda;
		switch (tipo) {
		case 1:
			moeda = new clsDolar(valor);
			break;
		case 2:
			moeda = new clsEuro(valor);
			break;
		case 3:
			moeda = new clsReal(valor);
			break;
		default:
			System.out.println("Tipo de moeda inválido. Moeda não adicionada.");
			return;
		}

		cofrinho.incluirMoeda(moeda);
	}

	private static void retirarMoeda(clsCofrinho cofrinho, Scanner scanner) {
		cofrinho.listadeMoedas();
		System.out.println("Informe o índice da moeda a ser removida: ");
		int indice = scanner.nextInt();
		scanner.nextLine();

		cofrinho.retirarMoeda(indice);
	}
}