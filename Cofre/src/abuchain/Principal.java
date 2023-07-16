package abuchain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Cofrinho cofrinho = new Cofrinho();
		Scanner scanner = new Scanner(System.in);

		int opcao;
		do {
			montaMenu();

			try {
				opcao = scanner.nextInt();
				scanner.nextLine(); // Limpar o buffer do scanner

				switch (opcao) {
				case 1:
					cofrinho.listarMoedas();
					break;
				case 2:
					adicionarMoeda(cofrinho, scanner);
					break;
				case 3:
					removerMoeda(cofrinho, scanner);
					break;
				case 4:
					cofrinho.listarMoedas();
					double valorTotalEmReal = cofrinho.calcularValorTotalEmReal();
					System.out.println("Valor total no cofrinho em Real: " + valorTotalEmReal);
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

	// Função para adicionar uma moeda ao cofrinho
	private static void adicionarMoeda(Cofrinho cofrinho, Scanner scanner) {
		System.out.println("Informe qual o tipo da moeda que será incluida no cofre:");
		listarTiposMoedas(cofrinho);
		int tipo = scanner.nextInt();
		scanner.nextLine();
		validaTipoMoedaInformado(tipo);

		System.out.println("Informe o valor da moeda: ");
		double valor = scanner.nextDouble();
		scanner.nextLine();

		Moeda moeda;
		if(tipo == 1) moeda = new Dolar(valor);
		else if (tipo == 2) moeda = new Euro(valor);
		else moeda = new Real(valor);
		cofrinho.adicionarMoeda(moeda);
		adicionarMaisMoedas(cofrinho, scanner);
	}

	// Função para remover uma moeda do cofrinho
	private static void removerMoeda(Cofrinho cofrinho, Scanner scanner) {
		cofrinho.listarMoedas();
		System.out.println("Informe o Codigo da moeda a ser removida: ");
		int indice = scanner.nextInt();
		scanner.nextLine();
		cofrinho.removerMoeda(indice);
		removerMaisMoedas(cofrinho, scanner);
	}

	private static void listarTiposMoedas(Cofrinho cofrinho) {
		System.out.println("Opção 1: Dólar");
		System.out.println("Opção 2: Euro");
		System.out.println("Opção 3: Real");
	}

	private static void validaTipoMoedaInformado(int tipo){
		switch (tipo) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Tipo de moeda inválido. Moeda não adicionada.");
			return;
		}
	}    

	private static void removerMaisMoedas(Cofrinho cofrinho, Scanner scanner)
	{
		System.out.println(" ");
		System.out.println("Deseja remover mais moedas: ");
		System.out.println("Opção 1: Nao");
		System.out.println("Opção 2: Sim");
		int opcao = scanner.nextInt();
		scanner.nextLine();

		if(opcao == 1) return;
		else if (opcao == 2) removerMoeda(cofrinho, scanner);
		else {
			System.out.println("Opçao Invalida.");
			System.out.println(" ");
			removerMaisMoedas(cofrinho, scanner);
		}
	}

	private static void adicionarMaisMoedas(Cofrinho cofrinho, Scanner scanner)
	{
		System.out.println(" ");
		System.out.println("Deseja adicionar mais moedas: ");
		System.out.println("Opção 1: Nao");
		System.out.println("Opção 2: Sim");
		int opcao = scanner.nextInt();
		scanner.nextLine();

		if(opcao == 1) return;
		else if (opcao == 2) adicionarMoeda(cofrinho, scanner);
		else {
			System.out.println("Opçao Invalida.");
			System.out.println(" ");
			adicionarMaisMoedas(cofrinho, scanner);
		}
	}

	private static void montaMenu(){

		System.out.println("########## Menu de Opçoes do Cofrinho ##########");
		System.out.println(" ");
		System.out.println("Opção 1: Listar moedas");
		System.out.println("Opção 2: Adicionar moeda");
		System.out.println("Opção 3: Remover moeda");
		System.out.println("Opção 4: Calcular valor total convertido para Reais");
		System.out.println("Opção 0: Sair");
		System.out.println("Escolha uma opção: ");
	}
}

