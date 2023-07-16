package abuchain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		clsCofrinho _cofrinho = new clsCofrinho();
		Scanner _scanner = new Scanner(System.in);

		int _opcao;
		do {
			// Exibe o menu de opções do cofrinho
			montaMenu(); 

			try {
				// Lê a opção escolhida pelo usuário
				_opcao = _scanner.nextInt(); 
				_scanner.nextLine();

				switch (_opcao) {
				case 1:
					// Lista as moedas presentes no cofrinho
					_cofrinho.listarMoedas(); 
					break;
				case 2:
					// Adiciona uma moeda ao cofrinho
					adicionarMoeda(_cofrinho, _scanner); 
					break;
				case 3:
					// Remove uma moeda do cofrinho
					removerMoeda(_cofrinho, _scanner); 
					break;
				case 4:
					// Lista as moedas presentes no cofrinho
					_cofrinho.listarMoedas(); 

					// Calcula o valor total em reais
					double _valorTotalEmReal = _cofrinho.calcularValorTotalEmReal(); 
					System.out.print("Valor total no cofrinho em Real é: ");
					// Exibe o valor total em reais formatado com duas casas decimais
					System.out.printf("%.2f%n", _valorTotalEmReal); 
					break;
				case 0:
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Opção inválida. Tente novamente.");
				_opcao = -1;
				_scanner.nextLine();
			}
			System.out.println();
		} while (_opcao != 0);

		_scanner.close();
	}

	// Função para adicionar uma moeda ao cofrinho
	private static void adicionarMoeda(clsCofrinho cofrinho, Scanner scanner) {
		System.out.println("Informe qual o tipo da moeda que será incluida no cofre:");

		// Lista os tipos de moedas disponíveis
		listarTiposMoedas(cofrinho); 

		// Lê o tipo de moeda escolhido pelo usuário
		int _tipo = scanner.nextInt(); 
		scanner.nextLine();

		// Valida o tipo de moeda informado
		validaTipoMoedaInformado(_tipo); 

		System.out.println("Informe o valor da moeda: ");

		// Lê o valor da moeda informado pelo usuário
		double _valor = scanner.nextDouble(); 
		scanner.nextLine();

		// Cria uma instância da moeda escolhida
		Moeda _moeda;
		if(_tipo == 1) _moeda = new Dolar(_valor); 
		else if (_tipo == 2) _moeda = new Euro(_valor);
		else _moeda = new Real(_valor);

		// Adiciona a moeda ao cofrinho
		cofrinho.adicionarMoeda(_moeda); 

		// Pergunta se deseja adicionar mais moedas
		adicionarMaisMoedas(cofrinho, scanner); 
	}

	// Função para remover uma moeda do cofrinho
	private static void removerMoeda(clsCofrinho cofrinho, Scanner scanner) {
		// Lista as moedas presentes no cofrinho
		cofrinho.listarMoedas(); 

		System.out.println("Informe o Codigo da moeda a ser removida: ");
		// Lê o índice da moeda a ser removida
		int _indice = scanner.nextInt(); 
		scanner.nextLine();

		// Remove a moeda do cofrinho
		cofrinho.removerMoeda(_indice); 

		// Pergunta se deseja remover mais moedas
		removerMaisMoedas(cofrinho, scanner); 
	}

	private static void listarTiposMoedas(clsCofrinho cofrinho) {
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

	private static void removerMaisMoedas(clsCofrinho cofrinho, Scanner scanner)
	{
		System.out.println(" ");
		System.out.println("Deseja remover mais moedas: ");
		System.out.println("Opção 1: Nao");
		System.out.println("Opção 2: Sim");
		int _opcao = scanner.nextInt();
		scanner.nextLine();

		if(_opcao == 1) return;
		else if (_opcao == 2) removerMoeda(cofrinho, scanner);
		else {
			System.out.println("Opção Inválida.");
			System.out.println(" ");
			removerMaisMoedas(cofrinho, scanner);
		}
	}

	private static void adicionarMaisMoedas(clsCofrinho cofrinho, Scanner scanner)
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
			System.out.println("Opção Inválida.");
			System.out.println(" ");
			adicionarMaisMoedas(cofrinho, scanner);
		}
	}

	private static void montaMenu(){
		System.out.println(" ");
		System.out.println("########## Menu de Opções do Cofrinho ##########");
		System.out.println(" ");
		System.out.println("Opção 1: Listar moedas");
		System.out.println("Opção 2: Adicionar moeda");
		System.out.println("Opção 3: Remover moeda");
		System.out.println("Opção 4: Calcular valor total convertido para Reais");
		System.out.println("Opção 0: Sair");
		System.out.println("Escolha uma opção: ");
	}
}
