package abuchain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Classe abstrata que representa uma moeda genérica
abstract class Moeda {
    private double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract String getDescricao();
}

// Classe que representa a moeda Dólar
class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Dólar";
    }
}

// Classe que representa a moeda Euro
class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Euro";
    }
}

// Classe que representa a moeda Real
class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public String getDescricao() {
        return "Real";
    }
}

// Classe que representa o cofrinho de moedas
class Cofre {
    private List<Moeda> moedas;

    public Cofre() {
        moedas = new ArrayList<>();
    }

    // Adiciona uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada ao cofrinho: " + moeda.getDescricao());
    }

    // Remove uma moeda do cofrinho pelo índice
    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(indice);
            System.out.println("Moeda removida do cofrinho: " + moedaRemovida.getDescricao());
        } else {
            System.out.println("Índice inválido. Moeda não removida.");
        }
    }

    // Lista todas as moedas presentes no cofrinho
    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            System.out.println("Moedas no cofrinho:");
            for (int i = 0; i < moedas.size(); i++) {
                Moeda moeda = moedas.get(i);
                System.out.println(i + ": " + moeda.getDescricao() + " - Valor: " + moeda.getValor());
            }
        }
    }

    // Calcula o valor total do cofrinho convertido para Real
    public double calcularValorTotalEmReal() {
        double valorTotal = 0;
        for (Moeda moeda : moedas) {
            if (moeda instanceof Real) {
                valorTotal += moeda.getValor();
            } else if (moeda instanceof Dolar) {
                valorTotal += moeda.getValor() * 5; // Conversão de dólar para real (valor fictício)
            } else if (moeda instanceof Euro) {
                valorTotal += moeda.getValor() * 6; // Conversão de euro para real (valor fictício)
            }
        }
        return valorTotal;
    }
}

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

