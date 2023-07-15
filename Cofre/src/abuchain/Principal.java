package abuchain;

import java.util.InputMismatchException;
import java.util.Scanner;

// Classe principal que contém o método main
public class Principal {
    public static void main(String[] args) {
        Cofre cofrinho = new Cofre();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Listar moedas");
            System.out.println("2. Adicionar moeda");
            System.out.println("3. Remover moeda");
            System.out.println("4. Listagem de moedas");
            System.out.println("5. Total convertido em Reais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

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
                        break;
                    case 5:
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
    private static void adicionarMoeda(Cofre cofrinho, Scanner scanner) {
        System.out.println("Informe o valor da moeda: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Informe o tipo de moeda (1 - Dólar, 2 - Euro, 3 - Real): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Moeda moeda;
        switch (tipo) {
            case 1:
                moeda = new Dolar(valor);
                break;
            case 2:
                moeda = new Euro(valor);
                break;
            case 3:
                moeda = new Real(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido. Moeda não adicionada.");
                return;
        }

        cofrinho.adicionarMoeda(moeda);
    }

    // Função para remover uma moeda do cofrinho
    private static void removerMoeda(Cofre cofrinho, Scanner scanner) {
        cofrinho.listarMoedas();
        System.out.println("Informe o índice da moeda a ser removida: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        cofrinho.removerMoeda(indice);
    }
}

